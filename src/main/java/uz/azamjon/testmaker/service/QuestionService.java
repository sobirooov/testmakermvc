package uz.azamjon.testmaker.service;

import org.springframework.stereotype.Service;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

   ArrayList<Question> questions = new ArrayList<>();

    {
        Question q1 = new Question();
        q1.setText("Question 1");
        Answer a1 = new Answer("A javob", true);
        Answer a2 = new Answer("B javob", false);
        Answer a3 = new Answer("C javob", false);
        Answer a4 = new Answer("D javob", false);
        q1.setAnswers(List.of(a1, a2, a3, a4));
        questions.add(q1);

        Question q2 = new Question();
        q2.setText("Question 2");
        Answer a5 = new Answer("A javob", false);
        Answer a6 = new Answer("B javob", false);
        Answer a7 = new Answer("C javob", false);
        Answer a8 = new Answer("D javob", true);
        q2.setAnswers(List.of(a5, a6, a7, a8));
        questions.add(q2);
    }

   public void addQuestion(Question question){
       questions.add(question);
   }

   public ArrayList<Question> getQuestions(){
       return questions;
   }
}
