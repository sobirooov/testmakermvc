package uz.azamjon.testmaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;
import uz.azamjon.testmaker.repository.AnswerRepository;
import uz.azamjon.testmaker.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

   public void addQuestion(Question question){
       int questionId = questionRepository.createQuestion(question);
       for(Answer answer : question.getAnswers()){
           answer.setQuestionid(questionId);
           answerRepository.createAnswer(answer);
       }
   }

   public List<Question> getQuestions(){
        List<Question> questions = questionRepository.findAll();
       for (Question q : questions) {
           q.setAnswers(answerRepository.findByQuestionId(q.getId()));
       }
       return questions;
   }

   public List<Question> getRandomQuestions(){
       List<Question> randomQuestions = new ArrayList<>(getQuestions());
       Collections.shuffle(randomQuestions);
       if (randomQuestions.size() > 10) {
           randomQuestions = randomQuestions.subList(0, 10);
       }

      return randomQuestions;
   }
}
