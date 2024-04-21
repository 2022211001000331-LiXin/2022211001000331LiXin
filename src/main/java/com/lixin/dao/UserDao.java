package com.lixin.dao;

import com.lixin.model.User;
import com.lixin.util.DateUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dabing
 */
public  class UserDao implements IUserDao {
    public static  String USERNAME="username";
    public static String PASSWORD="password";
    public static String EMAIL="email";
    public static String GENDER="gender";
    public static String BIRTHDATE="birthdate";
    public static String ID="id";
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {

         boolean success=false;
        try {
            //insert
            String sql="INSERT INTO usertable(username,password,email,gender,birthdate) values(?,?,?,?,?)";
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setString(1,user.getUsername());
            pt.setString(2,user.getPassword());
            pt.setString(3,user.getEmail());
            pt.setString(4,user.getGender());
            //pt.setDate(5,(Date) user.getBirthDate());
            pt.setDate(5,  new Date(user.getBirthdate().getTime()));
            success=pt.execute();

        }catch (RuntimeException re){
            throw re;
        }
        return success;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {

        String sql="update usertable set username = ?,password = ?,email = ?,gender = ?,birthdate = ? where id = ?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setString(1,user.getUsername());
        pt.setString(2,user.getPassword());
        pt.setString(3,user.getEmail());
        pt.setString(4,user.getGender());
        pt.setDate(5,user.getBirthdate());
        pt.setInt(6,user.getId());
        int i = pt.executeUpdate();
        return i;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }


    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="Select id,username,PASSWORD,email,gender,birthdate from usertable where username=? and password=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setString(1,username);
        pt.setString(2,password);
        ResultSet rs=pt.executeQuery();
        User u=null;
        while (rs.next()){
           u=new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setEmail(rs.getString("email"));
            u.setGender(rs.getString("gender"));
            u.setBirthdate(rs.getDate("birthdate"));
        }

        return u;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, java.util.Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con)  {
         List<User> userList=new ArrayList<User>();
         String sql="Select id,username,PASSWORD,email,gender,birthdate from usertable";
         PreparedStatement pt;
		try {
			pt = con.prepareStatement(sql);
         ResultSet rs=pt.executeQuery();
         while (rs.next()){
             User u=new User();
             u.setId(rs.getInt("id"));
             u.setUsername(rs.getString("username"));
             u.setPassword(rs.getString("password"));
             u.setEmail(rs.getString("email"));
             u.setGender(rs.getString("gender"));
             u.setBirthdate(rs.getDate("birthdate"));
             userList.add(u);
         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
         return userList;
    }
}
