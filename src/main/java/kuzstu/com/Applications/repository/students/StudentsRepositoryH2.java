package kuzstu.com.Applications.repository.students;

import kuzstu.com.Applications.exception.NotFoundException;
import kuzstu.com.Applications.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsRepositoryH2 implements StudentsRepository{

    private static final String CREATE = """
            INSERT INTO Students (id_student, id_class, name_student, dater , addresses, gender, estimation)
            VALUES (:studentId, :classId, :name_student, :dater, :addresses, :gender, :estimation.id)
            """;

    private static final String UPDATE = """
            UPDATE Students SET id_class = :id_class,
            name_student = :name_student,
            dater = :dater,
            addresses = :addresses,
            gender = :gender,
            estimation = :estimation.id
            WHERE id_student = :id_student
            """;

    private final RowMapper<Students> rowMapper = new DataClassRowMapper<>(Students.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public StudentsRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Students> readAllStudents() {
        return jdbcTemplate.query("SELECT * FROM Students", rowMapper);
    }

    @Override
    public Students readStudent(int studentId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Students WHERE id_student = ?", rowMapper, studentId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Student with id = [" + studentId + "] not found", e);
        }
    }

    @Override
    public void createStudent(Students students) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(students);
        namedParameterJdbcTemplate.update(CREATE, parameterSource);
    }

    @Override
    public void updateStudent(Students students, int studentId) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(students);
        namedParameterJdbcTemplate.update(UPDATE, parameterSource);
    }

    @Override
    public void deleteStudent(int studentId) {
        jdbcTemplate.update("DELETE FROM Students WHERE student_id = ?", studentId);
    }

}
