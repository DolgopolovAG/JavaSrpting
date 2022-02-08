package ru.gb.dao.product;


import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.dao.ManufacturerDao;

import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

//@Component
@RequiredArgsConstructor
public class NamedParameterJDBCTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, (rs, rn) ->
                Product.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .date(rs.getDate("date").toLocalDate())
                        .build());
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM product where id = :productId;";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new ProductSetExtractor());
    }

    @Override
    public String findNameById(Long id) {
        String sql = "SELECT name FROM product where id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    private static class ProductSetExtractor implements ResultSetExtractor<Product> {

        @Override
        public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
            return ru.gb.entity.Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .date(rs.getDate("date").toLocalDate())
                    .build();
        }
    }



}


