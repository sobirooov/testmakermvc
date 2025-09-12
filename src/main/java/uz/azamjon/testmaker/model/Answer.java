package uz.azamjon.testmaker.model;

import java.util.ArrayList;

public class Answer {
    private Integer id;
    private Integer questionid;
    private String text;
    private boolean isCorrect;

    public Answer() {
    }
    public Answer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getQuestionid() {
        return questionid;
    }
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                "questionId='" + questionid + '\'' +
                "text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
