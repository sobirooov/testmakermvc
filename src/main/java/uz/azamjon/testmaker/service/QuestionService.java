package uz.azamjon.testmaker.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

   List<Question> questions = new ArrayList<>();
   List<Question> randomQuestions = new ArrayList<>(questions);

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

        Question q3 = new Question();
        q3.setText("O‘zbekiston poytaxti qaysi?");
        Answer a10 = new Answer("Toshkent", true);
        Answer a11 = new Answer("Samarqand", false);
        Answer a12 = new Answer("Buxoro", false);
        Answer a13 = new Answer("Xorazm", false);
        q3.setAnswers(List.of(a10, a11, a12, a13));
        questions.add(q3);
    }

   public void addQuestion(Question question){
       questions.add(question);
   }

   public List<Question> getQuestions(){
       return questions;
   }

   public List<Question> getRandomQuestions(){
       List<Question> randomQuestions = new ArrayList<>(questions);
       Collections.shuffle(randomQuestions);
       if (randomQuestions.size() > 10) {
           randomQuestions = randomQuestions.subList(0, 10);
       }

      return randomQuestions;
   }
}
