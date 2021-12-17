package com.liqiubo.provider.dao;

import com.liqiubo.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findOne(Long id) {
        String sql = "select id, name, username, age, balance from t_user where id = %d";
        sql = String.format(sql, id);
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setAge(rs.getShort("age"));
                user.setBalance(rs.getBigDecimal("balance"));
                return user;
            }
        });
    }
}
