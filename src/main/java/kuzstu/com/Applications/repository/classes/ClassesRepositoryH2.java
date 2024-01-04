package kuzstu.com.Applications.repository.classes;

import kuzstu.com.Applications.exception.NotFoundException;
import kuzstu.com.Applications.model.Classes;
import kuzstu.com.Applications.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class ClassesRepositoryH2 implements ClassesRepository{

    private static final String CREATE = """
            INSERT INTO Classes (id_class, quantity, name_class, headman)
            VALUES (:classId, :quantity, :name_class, :headman)
            """;
    private static final String UPDATE = """
            UPDATE Classes SET quantity = :quantity,
            name_class = :name_class,
            headman = :headman
            WHERE id_class = :classId
            """;

    private final RowMapper<Classes> rowMapper = new DataClassRowMapper<>(Classes.class);
    private final RowMapper<Students> studentsRowMapper = new DataClassRowMapper<>(Students.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ClassesRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Classes> readAllClass() {
        return jdbcTemplate.query("SELECT * FROM Classes", rowMapper);
    }

    @Override
    public Classes readClass(int classId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Classes WHERE id_class = ?", rowMapper, classId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Class with id = [" + classId + "] not found", e);
        }
    }

    @Override
    public List<Students> getStudentsByClassId(int classId) {
        return jdbcTemplate.query("SELECT * FROM Students WHERE id_class = ?", studentsRowMapper, classId);
    }

    @Override
    public void createClass(Classes classes) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(classes);
        namedParameterJdbcTemplate.update(CREATE, parameterSource);
    }

    @Override
    public void updateClass(Classes classes, int classId) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(classes);
        namedParameterJdbcTemplate.update(UPDATE, parameterSource);
    }

    @Override
    public void deleteClass(int classId) {
        jdbcTemplate.update("DELETE FROM Classes WHERE id_class = ?", classId);
    }
}
