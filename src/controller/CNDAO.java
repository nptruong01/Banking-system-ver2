/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Branch;
//import model.Student;

/**
 *
 * @author Than
 */
public class CNDAO {
    private Connection conn;
    
    public CNDAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=bank;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public boolean addStudent(Student s){
//        
//        String sql = "INSERT INTO tblStudent(ID, name, dob, address, phone, email, mark) "
//                + "VALUES(?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, s.getID());
//            ps.setString(2, s.getName());
//            ps.setDate(3, new Date(s.getDob().getTime()));
//            ps.setString(4, s.getAddress());
//            ps.setString(5, s.getPhone());
//            ps.setString(6, s.getEmail());
//            ps.setFloat(7, s.getMark());
//            
//            return ps.executeUpdate() > 0;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return false;
//    }
    //////
        public boolean addBranch(Branch o){
        
//            String query="Insert into chinhanh values(?,?,?)";
//             PreparedStatement ps = conn.prepareStatement(query);
//             ps.setString(1, t.getBranch_id());
//             ps.setString(2, t.getLocation());
//             ps.setString(3, t.getBranch_name());
            
        String sql = "Insert into chinhanh values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, o.getBranch_id());
            ps.setString(2, o.getLocation());
            ps.setString(3, o.getBranch_name());
//            ps.setFloat(4, o.getTonkho());
//            
//            ps.setString(5, o.getMakho());
//            ps.setString(6, o.getMancc());
//            ps.setString(7, o.getMausac());
//            ps.setString(8, o.getDate());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
        
        public ArrayList<Branch> getListBranch(){
        ArrayList<Branch> list1 = new ArrayList<>();
        String sql = "Select * from chinhanh";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Branch o = new Branch();
                
                
                
                o.setBranch_id(rs.getString("branch_id"));
                o.setLocation(rs.getString("location"));
                o.setBranch_name(rs.getString("branch_name"));
//                o.setDonvitinh(rs.getFloat("donvitinh"));
//                o.setTonkho(rs.getFloat("tonkho"));
//                
//                o.setMakho(rs.getString("makho"));
//                o.setMancc(rs.getString("mancc"));
//                o.setMausac(rs.getString("mausac"));
//                o.setDate(rs.getString("date"));
              
                
                list1.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return list1;
    }
    //////
//    public ArrayList<Student> getListStudent(){
//        ArrayList<Student> list = new ArrayList<>();
//        String sql = "SELECT * FROM tblStudent";
//        
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Student s = new Student();
//                s.setID(rs.getString("ID"));
//                s.setName(rs.getString("name"));
//                s.setDob(rs.getDate("dob"));
//                s.setAddress(rs.getString("address"));
//                s.setPhone(rs.getString("phone"));
//                s.setEmail(rs.getString("email"));
//                s.setMark(rs.getFloat("mark"));
//                
//                list.add(s);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return list;
//    }
    
    public static void main(String[] args) {
        new CNDAO();
    }
}
