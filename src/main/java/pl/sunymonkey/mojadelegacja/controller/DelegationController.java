package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import pl.sunymonkey.mojadelegacja.service.DelegationService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/delegation")
public class DelegationController {

    private final CountriesDietRepository countriesDietRepository;

    private final UserRepository userRepository;

    @Autowired
    DelegationService delegationService;

    @Autowired
    public DelegationController(CountriesDietRepository countriesDietRepository, UserRepository userRepository) {
        this.countriesDietRepository = countriesDietRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(Model model) {
        List<CountriesDiet> countriesDiets = countriesDietRepository.findAll();
        model.addAttribute("countries", countriesDiets);
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("delegationDto", new DelegationDto());
        return "/delegation/commandDelegation";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String fortAdd(@Valid DelegationDto dto, BindingResult result) {
        Delegation delegation;

        if(!result.hasErrors()) {
            try {
                delegation = delegationService.save(dto);
            } catch (DelegationFailedException e) {
                return "delegation/commandDelegation";
            }

            if (delegation!=null){
                return "redirect:/admin";
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

}
