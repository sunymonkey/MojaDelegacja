package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.model.Diet;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sunymonkey.mojadelegacja.service.NBPService;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class CountriesDietController {

    private final CountriesDietRepository countriesDietRepository;
    NBPService nbpService = new NBPService();

    @Autowired
    public CountriesDietController(CountriesDietRepository countriesDietRepository) {
        this.countriesDietRepository = countriesDietRepository;
    }

    @RequestMapping(value = "/diets", method = RequestMethod.GET)
    public String calculateDiets(Model model){
        List<CountriesDiet> countriesDiets = countriesDietRepository.findAll();
        model.addAttribute("countries", countriesDiets);
        model.addAttribute("diet", new Diet());
        return "dietForm.jsp";
    }

    @RequestMapping(value = "/diets", method = RequestMethod.POST)
    @ResponseBody
    public String calculateDietsPost(Diet diet){
        long daysBetween = DAYS.between(diet.getFromDate(), diet.getToDate());
        CountriesDiet country = countriesDietRepository.getById(diet.getCountry());

        double result = daysBetween * country.getLumpSum();
        result -= diet.getCountBreakfast() * 0.15 * country.getLumpSum();
        result -= diet.getCountDinner() * 0.30 * country.getLumpSum();
        result -= diet.getCountSupper() * 0.30 * country.getLumpSum();

        double exchange = nbpService.getExchangeRate(country.getCurrency());

        return result + country.getCurrency() + "  =  " + exchange * result + "zł" + "   " + exchange + "   " + diet.getFromTime() + " - " + diet.getToTime();
    }
}

