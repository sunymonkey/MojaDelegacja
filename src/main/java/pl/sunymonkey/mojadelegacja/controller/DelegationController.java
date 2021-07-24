package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sunymonkey.mojadelegacja.exceptions.DelegationFailedException;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.model.Delegation;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.model.dto.DelegationDto;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.CountriesDietService;
import pl.sunymonkey.mojadelegacja.service.DelegationService;
import pl.sunymonkey.mojadelegacja.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/delegation")
public class DelegationController {
     @Autowired
    UserService userService;

    @Autowired
    DelegationService delegationService;

    @Autowired
    CountriesDietService countriesDietService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        List<CountriesDiet> countriesDiets = countriesDietService.findAll();
        model.addAttribute("countries", countriesDiets);
        List<User> users = userService.allEmployee("ROLE_EMPLOYEE");
        model.addAttribute("users", users);
        model.addAttribute("delegationDto", new DelegationDto());
        return "/delegation/commandDelegation";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String fortAdd(@Valid DelegationDto dto,
                          @AuthenticationPrincipal CurrentUser currentUser,
                          BindingResult result) {
        Delegation delegation;

        if(!result.hasErrors()) {
            try {
                delegation = delegationService.save(currentUser, dto);
            } catch (DelegationFailedException e) {
                return "delegation/commandDelegation";
            }

            if (delegation!=null){
                return "redirect:/delegation/list";
            }
        }
        return "delegation/commandDelegation";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        List<Delegation> delegationList = delegationService.findByMandatoryId(currentUser.getUser().getId());
        model.addAttribute("delegation", delegationList);
        return "delegation/delegationList";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable long id,
                               Model model) {
        Optional<Delegation> delegation = delegationService.findById(id);
        delegation.ifPresent(delegation1 -> model.addAttribute("delegation", delegation1));
        return "delegation/delegationDetails";
    }

}
