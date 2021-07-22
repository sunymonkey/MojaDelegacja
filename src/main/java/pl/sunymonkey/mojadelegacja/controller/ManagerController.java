package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manager")
public class ManagerController {


    private final UserRepository userRepository;

    public ManagerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/employeeList")
    public String employeeList(Model model) {
        List<User> users = userRepository.allEmployee("ROLE_EMPLOYEE");
        model.addAttribute("users", users);
        return "/manager/employeeList";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String employeeDetails(Model model,
                                  @PathVariable Long id) {
        Optional<User> employee = userRepository.findById(id);
        if(employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        }
        return "/manager/employeeDetails";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    
    public String profileDetails(@AuthenticationPrincipal CurrentUser currentUser,
                                 Model model){
        Optional<User> user = userRepository.findById(currentUser.getUser().getId());
        if(user.isPresent()) {
            model.addAttribute("employee", user.get());
        }
        return "/manager/employeeDetails";
    }
}
