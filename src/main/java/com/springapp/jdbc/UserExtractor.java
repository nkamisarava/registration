package com.springapp.jdbc;

import com.springapp.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExtractor implements ResultSetExtractor<User> {
    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setFirstName(resultSet.getString(2));
        user.setLastName(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        user.setGender(resultSet.getString(5));
        user.setCity(resultSet.getString(6));

        return user;
    }
}
