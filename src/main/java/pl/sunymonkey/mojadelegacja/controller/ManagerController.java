package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {


    private final UserRepository userRepository;

    public ManagerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/employeeList")
    public String employeeList(Model model){
        List<User> users = userRepository.employeeList();


        return "/manager/employeeList";
    }
}
