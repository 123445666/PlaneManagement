/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Plane;

import Plane.Plane;
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
 * @author aFun
 */
public class PlaneDAO {
    public List<Plane> getData() throws Exception {
        List<Plane> returnValue;
        returnValue = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            String StrSQL = "SELECT * from Plane ";
            conn = DBUtil.connectSQlserver();
            st = conn.createStatement();
            rs = st.executeQuery(StrSQL);
            while (rs.next()) {
                Plane planmb = new Plane();
                planmb.setId(rs.getInt(1));
                planmb.setType(rs.getNString(2));
                planmb.setLenght(Float.parseFloat(rs.getString(3)));
                planmb.setWeight(Float.parseFloat(rs.getString(4)));
                planmb.setColor(rs.getString(5));
                planmb.setSeats(Integer.parseInt(rs.getString(6)));
                planmb.setDescription(rs.getString(7));
                planmb.setStatus(rs.getShort(8));
                returnValue.add(planmb);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    public List<Plane> getData2(Integer planmbid) throws Exception {
        List<Plane> returnValue;
        returnValue = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            String StrSQL = "SELECT * from Plane where ID= "+planmbid;
            conn = DBUtil.connectSQlserver();
            st = conn.createStatement();
            rs = st.executeQuery(StrSQL);
            while (rs.next()) {
                Plane planmb = new Plane();
                planmb.setId(rs.getInt(1));
                planmb.setType(rs.getNString(2));
                planmb.setLenght(Float.parseFloat(rs.getString(3)));
                planmb.setWeight(Float.parseFloat(rs.getString(4)));
                planmb.setColor(rs.getString(5));
                planmb.setSeats(Integer.parseInt(rs.getString(6)));
                planmb.setDescription(rs.getString(7));
                planmb.setStatus(rs.getShort(8));
                returnValue.add(planmb);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    public void insert(Plane planmb) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "insert into Plane (type,lenght,weight,color,seats,description,status) values(?,?,?,?,?,?,?)";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, planmb.getType());
            stmt.setDouble(2, planmb.getLenght());
            stmt.setDouble(3, planmb.getWeight());
            stmt.setString(4, planmb.getColor());
            stmt.setInt(5, planmb.getSeats());
            stmt.setString(6, planmb.getDescription());
            stmt.setInt(7, planmb.getStatus());
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
    public void update(Plane planmb) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "update Plane set type=?, lenght=?, weight=?, color=?, seats=?, description=?, status=? where ID='"+planmb.getId()+"'";
            conn = DBUtil.connectSQlserver();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, planmb.getType());
            stmt.setDouble(2, planmb.getLenght());
            stmt.setDouble(3, planmb.getWeight());
            stmt.setString(4, planmb.getColor());
            stmt.setInt(5, planmb.getSeats());
            stmt.setString(6, planmb.getDescription());
            stmt.setInt(7, planmb.getStatus());
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
    public void delete(Plane planmb) throws Exception {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "delete from Plane where ID='"+planmb.getId()+"'";
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
