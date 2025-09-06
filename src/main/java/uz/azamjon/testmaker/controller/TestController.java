package uz.azamjon.testmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;
import uz.azamjon.testmaker.service.QuestionService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TestController {
    private final QuestionService questionService;

    public TestController(QuestionService questionService) {
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
    @GetMapping("/result")
    public String resultTest(HttpSession session, Model model){
        List<Question> questions = (List<Question>) session.getAttribute("myQuestions");
        Integer correntCounter = (Integer) session.getAttribute("correntCounter");
        int total = questions.size();
        int wrong = total - correntCounter;
        model.addAttribute("total", total);
        model.addAttribute("correct", correntCounter);
        model.addAttribute("wrong", wrong);
        return "result";
    }
    @GetMapping("/reset")
    public String resetTest(HttpSession session){
        session.setAttribute("myQuestions", null);
        session.setAttribute("currentQuestion", null);
        session.setAttribute("correntCounter", null);
        System.out.println("reset ishladi");
        return "redirect:/test";
    }

    @GetMapping("/test")
    public String test(HttpSession session,
                       Model model,
                       @RequestParam(required = false)
                       String userResponse){
        List<Question> questions = (List<Question>) session.getAttribute("myQuestions");
        Integer currentIndex = (Integer) session.getAttribute("currentQuestion");
        if (currentIndex == null){
            currentIndex = 0;
        } else {
            currentIndex++;
        }

        if(questions==null){
            questions = questionService.getRandomQuestions();
            session.setAttribute("myQuestions", questions);
        }
        if (userResponse!=null){
            int previosIndex = currentIndex - 1;
            Question question = questions.get(previosIndex);
            for (int i=0; i<question.getAnswers().size(); i++){
                Answer answer = question.getAnswers().get(i);
                Integer correntCounter = (Integer) session.getAttribute("correntCounter");
                if (correntCounter==null){
                    correntCounter = 0;
                }
                if (answer.getText().equals(userResponse) && answer.isCorrect()){
                    correntCounter++;
                }
                session.setAttribute("correntCounter", correntCounter);
            }
        }

        boolean isLastQuestion = currentIndex == questions.size();
        if (isLastQuestion){
            return "redirect:/result";
        }

        session.setAttribute("currentQuestion", currentIndex);
        model.addAttribute("question", questions.get(currentIndex));
        return "test";
    }

    @PostMapping("/submit")
    public String submit(Question question){
        questionService.addQuestion(question);
        System.out.println(question);
        return "index";
    }
}
