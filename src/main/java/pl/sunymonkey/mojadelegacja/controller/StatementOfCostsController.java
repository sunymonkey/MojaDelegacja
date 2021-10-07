package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.exceptions.ExpensesFailedException;
import pl.sunymonkey.mojadelegacja.exceptions.FileStorageException;
import pl.sunymonkey.mojadelegacja.model.*;
import pl.sunymonkey.mojadelegacja.model.dto.ExpensesDto;
import pl.sunymonkey.mojadelegacja.model.dto.StatementOfCostsDto;
import pl.sunymonkey.mojadelegacja.repository.*;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/diet")
public class StatementOfCostsController {

    private final StatementOfCostsRepository statementOfCostsRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final CurrencyRepository currencyRepository;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    DelegationService delegationService;

    @Autowired
    StatementOfCoastService statementOfCoastService;

    @Autowired
    DelegationCostsService delegationCostsService;

    @Autowired
    DBFileStorageService dbFileStorageService;

    @Autowired
    ExpensesService expensesService;

    @Autowired
    CountriesDietService countriesDietService;

    private final TypeOfExpensesRepository typeOfExpensesRepository;

    public StatementOfCostsController(StatementOfCostsRepository statementOfCostsRepository, PaymentMethodRepository paymentMethodRepository, CurrencyRepository currencyRepository, TypeOfExpensesRepository typeOfExpensesRepository) {
        this.statementOfCostsRepository = statementOfCostsRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.currencyRepository = currencyRepository;
        this.typeOfExpensesRepository = typeOfExpensesRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        List<CountriesDiet> countriesDiets = countriesDietService.findAll();
        model.addAttribute("countries", countriesDiets);
        model.addAttribute("statementOfCostsDto", new StatementOfCostsDto());
        return "statementOfCoast/tempform";
    }

    @RequestMapping(value = "/add/application/{id}", method = RequestMethod.GET)
    public String formApplicationView(@PathVariable long id,
                                      Model model) {
        List<CountriesDiet> countriesDiets = countriesDietService.findAll();
        model.addAttribute("countries", countriesDiets);

        StatementOfCostsDto statementOfCostsDto = new StatementOfCostsDto();
        Optional<Application> application = applicationService.findById(id);
        if(application.isPresent()){
            statementOfCostsDto = statementOfCoastService.newApplication(application.get());
        }
        model.addAttribute("statementOfCostsDto", statementOfCostsDto);
        return "statementOfCoast/tempform";
    }

    @RequestMapping(value = "/add/application/{id}", method = RequestMethod.POST)
    public String formApplicationAdd(@Valid StatementOfCostsDto dto,
                          BindingResult result,
                          @AuthenticationPrincipal CurrentUser currentUser) {
        StatementOfCosts statementOfCosts;

        if(!result.hasErrors()) {
            try {
                statementOfCosts = statementOfCoastService.save(currentUser, dto);
            } catch (ApplicationFailedException e) {
                return "statementOfCoast/tempform";
            }

            if (statementOfCosts!=null) {
                return "redirect:/diet/details/" + statementOfCosts.getId();
            }
        }
        return "statementOfCoast/tempform";
    }

    @RequestMapping(value = "/add/delegation/{id}", method = RequestMethod.GET)
    public String formDelegationView(@PathVariable long id,
                                      Model model) {
        List<CountriesDiet> countriesDiets = countriesDietService.findAll();
        model.addAttribute("countries", countriesDiets);

        StatementOfCostsDto statementOfCostsDto = new StatementOfCostsDto();
        Optional<Delegation> delegation = delegationService.findById(id);
        if(delegation.isPresent()){
            statementOfCostsDto = statementOfCoastService.newApplication(delegation.get());
        }
        model.addAttribute("statementOfCostsDto", statementOfCostsDto);
        return "statementOfCoast/tempform";
    }

    @RequestMapping(value = "/add/delegation/{id}", method = RequestMethod.POST)
    public String formDelegationAdd(@Valid StatementOfCostsDto dto,
                                     BindingResult result,
                                     @AuthenticationPrincipal CurrentUser currentUser) {
        StatementOfCosts statementOfCosts;

        if(!result.hasErrors()) {
            try {
                statementOfCosts = statementOfCoastService.save(currentUser, dto);
            } catch (ApplicationFailedException e) {
                return "statementOfCoast/tempform";
            }

            if (statementOfCosts!=null) {
                return "redirect:/diet/details/" + statementOfCosts.getId();
            }
        }
        return "statementOfCoast/tempform";
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formAdd(@Valid StatementOfCostsDto dto,
                          BindingResult result,
                          @AuthenticationPrincipal CurrentUser currentUser) {
        StatementOfCosts statementOfCosts;

        if(!result.hasErrors()) {
            try {
                statementOfCosts = statementOfCoastService.save(currentUser, dto);
            } catch (ApplicationFailedException e) {
                return "statementOfCoast/tempform";
            }

            if (statementOfCosts!=null) {
                return "redirect:/diet/details/" + statementOfCosts.getId();
            }
        }
        return "statementOfCoast/tempform";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String detailStatementOfCosts(@PathVariable Long id,
                                         Model model){
        Optional<StatementOfCosts> statementOfCosts = statementOfCostsRepository.findById(id);
        statementOfCosts.ifPresent(cos -> model.addAttribute("statementOfCosts", cos));
        return "statementOfCoast/details";
    }

    @RequestMapping(value = "/expenses/add/{id}", method = RequestMethod.GET)
    public String expenses(@PathVariable Long id,
                           Model model) {
        List<TypeOfExpenses> typeOfExpenses = typeOfExpensesRepository.findAll();
        model.addAttribute("expensesDao", new ExpensesDto());
        model.addAttribute("typeOfExpenses", typeOfExpenses);
        model.addAttribute("statementOfCoast", id);
        List<PaymentMethod> paymentMethodList = paymentMethodRepository.findAll();
        model.addAttribute("paymentMethodList", paymentMethodList);
        List<Currency> currencyList = currencyRepository.findAll();
        model.addAttribute("currencyList", currencyList);
        return "statementOfCoast/expensesAdd";
    }

    @RequestMapping(value = "/expenses/add/{id}", method = RequestMethod.POST)
    public String expensesAdd(@Valid ExpensesDto dto,
                              BindingResult result,
                              @RequestParam long id) throws FileStorageException {
        Expenses expenses;

        DBFile dbFile;
        dbFile = dbFileStorageService.storeFile(dto.getDbFile());
        Optional<StatementOfCosts> byId = statementOfCostsRepository.findById(id);
        StatementOfCosts statementOfCosts = new StatementOfCosts();
        if(byId.isPresent()) {
            statementOfCosts = byId.get();
        }

        if(!result.hasErrors()) {
            try {
                expenses = expensesService.save(dto, dbFile,statementOfCosts);
            } catch (ExpensesFailedException e) {
                return "statementOfCoast/expensesAdd";
            }

            if(expenses!=null) {
                return "redirect:/";
            }
        }
        return "statementOfCoast/expensesAdd";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<StatementOfCosts> all = statementOfCostsRepository.findAll();
        model.addAttribute("statementOfCosts", all);
        return "statementOfCoast/list";
    }


    @RequestMapping(value = "/list/person", method = RequestMethod.GET)
    public String personList(@AuthenticationPrincipal CurrentUser currentUser,
                             Model model) {
        List<StatementOfCosts> person = statementOfCoastService.findByUser(currentUser.getUsername());
        model.addAttribute("statementOfCosts", person);
        return "statementOfCoast/list";
    }

    @RequestMapping(value = "/final/{id}", method = RequestMethod.GET)
    public String finalCalculate(@PathVariable long id,
                                 Model model){
        Optional<StatementOfCosts> statement = statementOfCostsRepository.findById(id);
        statement.ifPresent(statementOfCosts -> delegationCostsService.finishCalculateAndSave(statementOfCosts));

        model.addAttribute("statementOfCosts", statement.get());
        return "raport/preview";
    }

    @RequestMapping(value = "/send/{id}", method = RequestMethod.GET)
    public String finalSend(@AuthenticationPrincipal CurrentUser currentUser,
                            @PathVariable long id) {
        StatementOfCosts statementOfCosts = statementOfCoastService.findById(id);
        statementOfCoastService.sendDokument(statementOfCosts, currentUser);
        return "statementOfCoast/list";
    }

    @RequestMapping(value = "/list/accept", method = RequestMethod.GET)
    public String acceptList(Model model) {
        List<StatementOfCosts> list = statementOfCoastService.allStatus("Wysłany");
        model.addAttribute("statementOfCosts", list);
        return "statementOfCoast/acceptList";
    }

    @RequestMapping(value = "/list/accept/{id}", method = RequestMethod.GET)
     public String acceptForm(@PathVariable long id,
                            Model model){
        StatementOfCosts statementOfCosts = statementOfCoastService.findById(id);
        model.addAttribute("statementOfCosts", statementOfCosts);
        return "statementOfCoast/acceptDetails";

    }

    @RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
    public String accept(@PathVariable long id,
                         Model model) {
        StatementOfCosts statementOfCosts = statementOfCoastService.findById(id);
        model.addAttribute("statementOfCosts", statementOfCosts);
        return "statementOfCoast/accept";
    }

    @RequestMapping(value = "/accept/{id}", method = RequestMethod.POST)
    public String acceptFinish(@AuthenticationPrincipal CurrentUser currentUser,
                               @RequestParam long id) {
        StatementOfCosts statementOfCosts = statementOfCoastService.findById(id);
        statementOfCoastService.acceptDokument(statementOfCosts, currentUser);
        return "statementOfCoast/list";
    }

    @RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
    public String reject(@PathVariable long id,
                         Model model) {
        StatementOfCosts statementOfCosts = statementOfCoastService.findById(id);
        model.addAttribute("statementOfCosts", statementOfCosts);
        return "statementOfCoast/reject";
    }

    @RequestMapping(value = "/reject/{id}", method = RequestMethod.POST)
    public String rejectFinish(@AuthenticationPrincipal CurrentUser currentUser,
                               @RequestParam long id) {
        StatementOfCosts statementOfCosts = statementOfCoastService.findById(id);
        statementOfCoastService.rejectDokument(statementOfCosts, currentUser);
        return "statementOfCoast/list";
    }

}
