/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Customer;

import Database.DBUtil;
import Users.Users;
import java.sql.Connection;
import java.sql.Date;
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
public class CustomerDAO {
    private java.sql.Date date;
    public List<Customer> getData() throws Exception {
        List<Customer> returnValue;
        returnValue = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            String StrSQL = "SELECT * from Customer ";
            conn = DBUtil.connectSQlserver();
            st = conn.createStatement();
            rs = st.executeQuery(StrSQL);
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setId(rs.getInt(1));
                cus.setName(rs.getNString(2));
                cus.setIdentityNo(rs.getString(3));
                cus.setBirthday(rs.getDate(4));
                cus.setPhone(rs.getString(5));
                cus.setEmail(rs.getString(6));
                cus.setStatus(rs.getInt(7));
                returnValue.add(cus);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    public List<Customer> getData2(Integer Cusid) throws Exception {
        List<Customer> returnValue;
        returnValue = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            String StrSQL = "SELECT * from Customer where ID= "+Cusid;
            conn = DBUtil.connectSQlserver();
            st = conn.createStatement();
            rs = st.executeQuery(StrSQL);
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setId(rs.getInt(1));
                cus.setName(rs.getNString(2));
                cus.setIdentityNo(rs.getString(3));
                cus.setBirthday(rs.getDate(4));
                cus.setPhone(rs.getString(5));
                cus.setEmail(rs.getString(6));
                cus.setStatus(rs.getInt(7));
                returnValue.add(cus);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    public void insert(Customer cus) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "insert into Customer (name,identityNo,birthday,phone,email,status) values(?,?,?,?,?,?)";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, cus.getName());
            stmt.setString(2, cus.getIdentityNo());
            date = new Date(cus.getBirthday().getTime());
            stmt.setDate(3, date);
            stmt.setString(4, cus.getPhone());
            stmt.setString(5, cus.getEmail());
            stmt.setInt(6, cus.getStatus());
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
    public void update(Customer cus) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "update Customer set name=?, identityNo=?, birthday=?, phone=?, email=?, status=? where ID='"+cus.getId()+"'";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, cus.getName());
            stmt.setString(2, cus.getIdentityNo());
            date = new Date(cus.getBirthday().getTime());
            stmt.setDate(3, date);
            stmt.setString(4, cus.getPhone());
            stmt.setString(5, cus.getEmail());
            stmt.setInt(6, cus.getStatus());
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
    public void delete(Customer cus) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "delete from Customer where ID='"+cus.getId()+"'";
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
