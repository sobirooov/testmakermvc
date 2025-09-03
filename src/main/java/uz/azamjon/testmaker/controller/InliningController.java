package uz.azamjon.testmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InliningController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){

        return "index";
    }

    @GetMapping("/createQuestion")
    public String createQuestion(Model model){
        Question question = new Question();
        ArrayList<Answer> answers = new ArrayList<Answer>();
        answers.add(new Answer());
        answers.add(new Answer());
        answers.add(new Answer());
        answers.add(new Answer());
        question.setAnswers(answers);
        model.addAttribute("createQuestion", question);
        return "createQuestion";
    }

    @PostMapping("/submit")
    public String submit(Question question){
        System.out.println(question);
        return "index";
    }
}
