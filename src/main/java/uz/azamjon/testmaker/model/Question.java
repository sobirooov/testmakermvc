package uz.azamjon.testmaker.model;

import java.util.List;

public class Question {
    private Integer id;
    private String text;
    private List<Answer> answers;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                "text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
