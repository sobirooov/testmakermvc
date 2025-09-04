package uz.azamjon.testmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;
import uz.azamjon.testmaker.service.QuestionService;

import java.util.ArrayList;


@Controller
public class InliningController {
    private final QuestionService questionService;

    public InliningController(QuestionService questionService) {
        this.questionService = questionService;
    }

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
    @GetMapping("/questions")
    public String listTest(Model model){
        model.addAttribute("questions", questionService.getQuestions());
        return "questions";
    }

    @PostMapping("/submit")
    public String submit(Question question){
        questionService.addQuestion(question);
        System.out.println(question);
        return "index";
    }
}
