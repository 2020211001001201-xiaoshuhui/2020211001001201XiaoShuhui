package com.XiaoShuhui.dao;

import com.XiaoShuhui.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.executeUpdate();
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return true;
        }


    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id=? ";
        PreparedStatement st = con.prepareStatement(sql);
        st.executeUpdate();
        String username = null;
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        System.out.println("delete successfully!!!");
        return 0;
    }

    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update  usertable set username=? where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        String username = null;
        st.setString(1,username);
        String id = null;
        st.setString(2,id);
        st.executeUpdate();
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthDate"));
        }
        return 1;
    }

    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);
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

    public User findByUsername(Connection con, String username) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where username=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
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

    public User findByPassword(Connection con, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,password);
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
    public User findByEmail(Connection con, String email) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where email=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,email);
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

    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where gender=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,gender);
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
        return (List<User>) user;
    }

    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select id,username,password,email,gender,birthDate from usertable where birthDate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
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
        return (List<User>) user;
    }

    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable ";
        PreparedStatement st = con.prepareStatement(sql);
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
        return (List<User>) user;
    }
}
