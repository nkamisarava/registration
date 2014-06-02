package com.springapp.dao;

import com.springapp.domain.User;
import com.springapp.jdbc.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource dataSource;

    public void insertData(User user) {
        String sql = "insert into user (first_name, last_name, password, gender, city) values (?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[] {user.getFirstName(), user.getLastName(), user.getPassword(), user.getGender(), user.getCity()});
    }

    @Override
    public List<User> getUserList() {
        List userList = new ArrayList();
        String sql = "select * from user";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    @Override
    public void deleteData(String id) {
        String sql = "delete from user where id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public void updateData(User user) {
        String sql = "update user set first_name=?, last_name=?, password=?, gender=?, city=? where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[] {user.getFirstName(), user.getLastName(), user.getPassword(), user.getGender(), user.getCity(), user.getId()});
    }

    @Override
    public User getUser(String id) {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from user where id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList.get(0);
    }
}
