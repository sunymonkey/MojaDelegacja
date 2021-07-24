package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    UserService userService;


    @RequestMapping("/employeeList")
    public String employeeList(Model model) {
        List<User> users = userService.allEmployee("ROLE_EMPLOYEE");
        model.addAttribute("users", users);
        return "/manager/employeeList";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String employeeDetails(Model model,
                                  @PathVariable Long id) {
        Optional<User> employee = userService.findById(id);
        employee.ifPresent(user -> model.addAttribute("employee", user));
        return "/manager/employeeDetails";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    
    public String profileDetails(@AuthenticationPrincipal CurrentUser currentUser,
                                 Model model){
        Optional<User> user = userService.findById(currentUser.getUser().getId());
        user.ifPresent(user1 -> model.addAttribute("employee", user1));
        return "/manager/employeeDetails";
    }
}
