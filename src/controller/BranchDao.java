/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connect.MyConnection;
import DAO.Dao;
import model.Branch;
//import model.chinhanh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class BranchDao implements Dao<Branch>{

    
    Connection conn=MyConnection.getInstance().getConnection();
    @Override
    public List<Branch> getList() {
        List listLP=new ArrayList<>();
        try 
        {
             String query="Select * from chinhanh";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             Branch cn;
             while(rs.next())
             {
                 cn=new Branch();
                 cn.setBranch_id(rs.getString("branch_id"));
                 cn.setLocation(rs.getString("location"));
                 cn.setBranch_name(rs.getString("branch_name"));
                 listLP.add(cn);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listLP;
    }

    @Override
    public int insert(Branch t) {
        try 
        {
             String query="Insert into chinhanh values(?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getBranch_id());
             ps.setString(2, t.getLocation());
             ps.setString(3, t.getBranch_name());
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã thêm thành công !");
                 return 1;
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Thao tác thất bại !");
                 return 0;
             }
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Branch t) {
        try
        {
             String query="Update chinhanh set location=?,branch_name=? where branch_id=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(3, t.getBranch_id());
             ps.setString(1, t.getLocation());
             ps.setString(2, t.getBranch_name());
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã cập nhật thành công !");
                 return 1;
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Thao tác thất bại !");
                 return 0;
             }
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String t) {
        try
        {
             String query="Delete from chinhanh where branch_id=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,t);
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã xóa thành công !");
                 return 1;
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Thao tác thất bại !");
                 return 0;
             }
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int findT(String t) {
        try 
        {   
           
             String query="Select * from chinhanh where branch_id = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,t);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 return 1;
             }
             else
             {
                 return 0;
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return 0;
    }

    @Override
    public List<Branch> find(String data, String colName) {
        List listLP=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("Loại phòng"))
            {
              query="Select * from chinhanh where branch_name like %?% ";
            }
            else
            {
              query="Select * from chinhanh where location like \"%\"?\"%\" ";
            }
            
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             
             ResultSet rs=ps.executeQuery();
             Branch lp;
             while(rs.next())
                 
                
             {
                 lp=new Branch();
                 lp.setBranch_id(rs.getString("branch_id"));
                 lp.setLocation(rs.getString("location"));
                 lp.setBranch_name(rs.getString("branch_name"));
                 listLP.add(lp);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listLP;
    }

    @Override
    public String getData(String dataIn, String colIn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Branch> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Branch> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Branch> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Branch t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Branch> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Branch> find(Branch t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
