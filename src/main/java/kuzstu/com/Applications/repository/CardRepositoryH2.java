package kuzstu.com.Applications.repository;

import kuzstu.com.Applications.exception.NotFoundException;
import kuzstu.com.Applications.model.Card;
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
public class CardRepositoryH2 extends CardRepository {
    private static final String CREATE = """
            INSERT INTO Card (id, concentration, student, gallery, green, scheme, drink)
            VALUES (:id, :concentration, :student, :gallery, :green, :scheme.id, :drink)
            """;
    private static final String UPDATE = """
            UPDATE Card SET concentration = :concentration,
            student = :student,
            gallery = :gallery,
            green = :green,
            scheme = :scheme.id,
            drink = :drink,
            WHERE id = :id
            """;

    private final RowMapper<Card> rowMapper = new DataClassRowMapper<>(Card.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CardRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Card> readAll() {
        return jdbcTemplate.query("SELECT * FROM Card", rowMapper);
    }

    @Override
    public Card readCard(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Card WHERE id = ?", rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Card with id = [" + id + "] not found", e);
        }
    }

    @Override
    public void createCard(Card card) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(card);
        namedParameterJdbcTemplate.update(CREATE, parameterSource);
    }

    @Override
    public void updateClass(Card card, int id) {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(card);
        namedParameterJdbcTemplate.update(UPDATE, parameterSource);
    }

}
