package pl.sunymonkey.mojadelegacja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/applicationForm")
public class ApplicationController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formView(){
        return "admin/applicationForm";
    }
}
