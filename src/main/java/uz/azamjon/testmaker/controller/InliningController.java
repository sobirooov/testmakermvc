package uz.azamjon.testmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InliningController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String exampleHTML(Model model) {
        model.addAttribute("message", "Test Maker");
        model.addAttribute("description", "Thymeleaf tutorial");
        return "index";
    }
}
