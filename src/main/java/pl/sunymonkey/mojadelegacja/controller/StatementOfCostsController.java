package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.dto.ApplicationDto;
import pl.sunymonkey.mojadelegacja.model.dto.StatementOfCostsDto;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.service.StatementOfCoastService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/diet")
public class StatementOfCostsController {

    private final CountriesDietRepository countriesDietRepository;
    private final UserRepository userRepository;

    @Autowired
    StatementOfCoastService statementOfCoastService;


    public StatementOfCostsController(CountriesDietRepository countriesDietRepository, UserRepository userRepository) {
        this.countriesDietRepository = countriesDietRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        List<CountriesDiet> countriesDiets = countriesDietRepository.findAll();
        model.addAttribute("countries", countriesDiets);
        model.addAttribute("statementOfCostsDto", new StatementOfCostsDto());
        return "statementofcoast/tempform";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formAdd(@Valid StatementOfCostsDto dto, BindingResult result) {
        StatementOfCosts statementOfCosts;

        if(!result.hasErrors()) {
            try {
                statementOfCosts = statementOfCoastService.save(dto);
            } catch (ApplicationFailedException e) {
                return "statementofcoast/tempform";
            }

            if (statementOfCosts!=null) {
                return "redirect:/admin";
            }
        }
        return "statementofcoast/tempform";
    }


}
