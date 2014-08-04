/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Users;

import Database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PDBac
 */
public class UserDAO {
    private java.sql.Date date;
    public List<Users> getData() throws Exception {
        List<Users> returnValue;
        returnValue = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            String StrSQL = "SELECT * from users ";
            conn = DBUtil.connectSQlserver();
            st = conn.createStatement();
            rs = st.executeQuery(StrSQL);
            while (rs.next()) {
                Users user = new Users();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setIdCustomer(rs.getInt(3));
                user.setStatus(rs.getInt(4));
                returnValue.add(user);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    public List<Users> getData2(Integer Cusid) throws Exception {
        List<Users> returnValue;
        returnValue = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            String StrSQL = "SELECT * from users where ID_Customer= "+Cusid;
            conn = DBUtil.connectSQlserver();
            st = conn.createStatement();
            rs = st.executeQuery(StrSQL);
            while (rs.next()) {
                Users user = new Users();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setIdCustomer(rs.getInt(3));
                user.setStatus(rs.getInt(4));
                returnValue.add(user);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    public void insert(Users user) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "insert into users (username,password,ID_Customer,status) values(?,?,?,?)";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getIdCustomer());
            stmt.setInt(4, user.getStatus());
            stmt.executeUpdate();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
    public void update(Users user) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "update users set password=?, ID_Customer=?, status=? where username='"+user.getUsername()+"'";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, user.getPassword());
            stmt.setInt(2, user.getIdCustomer());
            stmt.setInt(3, user.getStatus());
            stmt.executeUpdate();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
    public void delete(Users user) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "delete from users where username='"+user.getUsername()+"'";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.executeUpdate();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
    public void deletebycustomerid(Integer cusId) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "delete from users where ID_Customer='"+cusId+"'";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.executeUpdate();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }
  
}
