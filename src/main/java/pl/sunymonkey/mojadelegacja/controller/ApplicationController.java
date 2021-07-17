package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.model.dto.ApplicationDto;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.ApplicationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    private final CountriesDietRepository countriesDietRepository;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    public ApplicationController(CountriesDietRepository countriesDietRepository) {
        this.countriesDietRepository = countriesDietRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        List<CountriesDiet> countriesDiets = countriesDietRepository.findAll();
        model.addAttribute("countries", countriesDiets);
        model.addAttribute("applicationDto", new ApplicationDto());
        return "application/applicationForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formAdd(@Valid ApplicationDto dto,
                          @AuthenticationPrincipal CurrentUser currentUser,
                          BindingResult result) {
        Application application;

        if(!result.hasErrors()) {
            try {
                application = applicationService.save(currentUser, dto);
            } catch (ApplicationFailedException e) {
                return "application/applicationForm";
            }

            if (application!=null) {
                return "redirect:/admin";
            }
        }
        return "application/applicationForm";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Application> applicationList = applicationService.findAll();
        model.addAttribute("application", applicationList);
        return "application/applicationList";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable Long id,
                          Model model) {
        Optional<Application> application = applicationService.findById(id);
        if(application.isPresent()) {
            model.addAttribute("application", application.get());
        }
        return "application/applicationDetails";
    }
}
