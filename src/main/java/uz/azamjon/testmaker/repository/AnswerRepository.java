package uz.azamjon.testmaker.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uz.azamjon.testmaker.model.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AnswerRepository {
    private JdbcTemplate jdbcTemplate;
    public AnswerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("Mana qara shu yerga:");
        for (Answer answer : findByQuestionId(14)) {
            System.out.println(answer);
        }
    }

    private RowMapper<Answer> rowMapper = new RowMapper<Answer>() {
        @Override
        public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Answer answer = new Answer();
            answer.setText(rs.getString("text_value"));
            answer.setCorrect(rs.getBoolean("is_correct"));
            answer.setId(rs.getInt("id"));
            answer.setQuestionid(rs.getInt("question_id"));
            return answer;
        }
    };


    public List<Answer> findByQuestionId(int questionId) {
        String sql = "select * from testmaker.answers where question_id = ?";
        return jdbcTemplate.query(sql, rowMapper, questionId);
    }

    public void createAnswer(Answer answer) {
        String sql =
                    """
                    INSERT INTO testmaker.answers (question_id,text_value,is_correct) 
                    VALUES (?,?,?)
                    """;

        jdbcTemplate.update(sql, answer.getQuestionid(), answer.getText(), answer.isCorrect());
    }
}
