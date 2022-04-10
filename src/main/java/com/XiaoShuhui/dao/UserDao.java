package com.XiaoShuhui.dao;

import com.XiaoShuhui.model.User;

import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert into usertable
        return false;
    }

    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    public int updateUser(Connection con, User user) throws SQLException {
        return 0;
    }

    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where username=? and password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return user;
    }

    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
