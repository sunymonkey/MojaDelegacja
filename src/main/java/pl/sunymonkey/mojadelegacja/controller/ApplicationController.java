package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.dto.ApplicationDto;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.ApplicationService;
import pl.sunymonkey.mojadelegacja.service.CountriesDietService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    CountriesDietService countriesDietService;

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        model.addAttribute("countries", countriesDietService.findAll());
        model.addAttribute("applicationDto", new ApplicationDto());
        return "application/applicationForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formAdd(@Valid ApplicationDto dto,
                          BindingResult result,
                          @AuthenticationPrincipal CurrentUser currentUser,
                          Model model) {
        Application application;
        ObjectError globalError = result.getGlobalError();

        if(!result.hasErrors()) {
            try {
                application = applicationService.save(currentUser, dto);
            } catch (ApplicationFailedException e) {
                return "application/applicationForm";
            }

            if (application!=null) {
                return "redirect:/application/list";
            }
        }
        model.addAttribute("countries", countriesDietService.findAll());
        model.addAttribute("error", globalError.getDefaultMessage());
        return "application/applicationForm";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@AuthenticationPrincipal CurrentUser currentUser,
                       Model model) {
        List<Application> applicationList = applicationService.findByApplicantId(currentUser.getUser().getId());
        model.addAttribute("application", applicationList);
        return "application/applicationList";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable Long id,
                          Model model) {
        Optional<Application> application = applicationService.findById(id);
        application.ifPresent(application1 -> model.addAttribute("application", application1));
        return "application/applicationDetails";
    }

    @RequestMapping(value = "/change/{id}", method = RequestMethod.GET)
    public String accept(@PathVariable Long id,
                         Model model) {
        Optional<Application> application = applicationService.findById(id);
        application.ifPresent(application1 -> model.addAttribute("application", application1));
        return "application/applicationStatusChange";
    }

    @RequestMapping(value = "/change/{id}", method = RequestMethod.POST)
    public String changeStatus(@AuthenticationPrincipal CurrentUser currentUser,
                               @RequestParam String status,
                               Long id) {
        System.out.println(status);
        Optional<Application> application = applicationService.findById(id);
        if (application.isPresent()){
            Application application1 = application.get();
            applicationService.save(currentUser, application1);
        }
        return "redirect:/application/list";
    }

}
