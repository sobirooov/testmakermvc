package uz.azamjon.testmaker.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import uz.azamjon.testmaker.model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class QuestionRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Question> findAll() {
        String sql =
                """
                SELECT id, text_value FROM testmaker.questions
                """;

        return jdbcTemplate.query(sql, new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setText(rs.getString("text_value"));

                return question;
            }
        });
    }

    public QuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("Azamjon test: QuestionRepository");
        for (Question question : findAll()) {
            System.out.println(question);
        }
    }

    public int createQuestion(Question question){
        String sql = "INSERT INTO testmaker.questions (text_value) VALUES (?) RETURNING id";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, question.getText());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }



}
