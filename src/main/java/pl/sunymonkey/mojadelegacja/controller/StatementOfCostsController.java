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
import pl.sunymonkey.mojadelegacja.service.DBFileStorageService;
import pl.sunymonkey.mojadelegacja.service.ExpensesService;
import pl.sunymonkey.mojadelegacja.service.StatementOfCoastService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/diet")
public class StatementOfCostsController {

    private final CountriesDietRepository countriesDietRepository;
    private final UserRepository userRepository;
    private final StatementOfCostsRepository statementOfCostsRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final CurrencyRepository currencyRepository;

    @Autowired
    StatementOfCoastService statementOfCoastService;

    @Autowired
    DBFileStorageService dbFileStorageService;

    @Autowired
    ExpensesService expensesService;

    private final TypeOfExpensesRepository typeOfExpensesRepository;


    public StatementOfCostsController(CountriesDietRepository countriesDietRepository, UserRepository userRepository, StatementOfCostsRepository statementOfCostsRepository, PaymentMethodRepository paymentMethodRepository, CurrencyRepository currencyRepository, TypeOfExpensesRepository typeOfExpensesRepository) {
        this.countriesDietRepository = countriesDietRepository;
        this.userRepository = userRepository;
        this.statementOfCostsRepository = statementOfCostsRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.currencyRepository = currencyRepository;
        this.typeOfExpensesRepository = typeOfExpensesRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        List<CountriesDiet> countriesDiets = countriesDietRepository.findAll();
        model.addAttribute("countries", countriesDiets);
        model.addAttribute("statementOfCostsDto", new StatementOfCostsDto());
        return "statementOfCoast/tempform";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formAdd(@Valid StatementOfCostsDto dto,
                          @AuthenticationPrincipal CurrentUser currentUser,
                          BindingResult result) {
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
        if(statementOfCosts.isPresent()){
            model.addAttribute("statementOfCosts", statementOfCosts.get());
        }

        return "statementOfCoast/details";
    }

    @RequestMapping("/expenses/add/{id}")
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

        DBFile dbFile = new DBFile();
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
}
