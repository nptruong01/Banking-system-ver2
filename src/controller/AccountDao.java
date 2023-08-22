/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import DAO.Dao;
import model.account;
//import static QLKS.view.Staffview.df;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;




public class AccountDao implements Dao<account>{
    private static final String TABLE_NAME = "account";
    private static final String aid = "acc_id";
    private static final String cid = "cust_id";
    private static final String bal = "balance";
    private static final String tt = "trangthai";
    
//    private static final String DIACHI_FIELD = "DiaChi";
    Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public List<account> getAll() {
        List<account> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String acc_id = rs.getString(aid);
                String cust_id = rs.getString(cid);
                int balance = rs.getInt(bal);
                String trangthai = rs.getString(tt);

                list.add(new account(acc_id,cust_id ,balance, trangthai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

            public ArrayList<account> getListOto(){
        ArrayList<account> list1 = new ArrayList<>();
        String sql = "SELECT * FROM account";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                account o = new account();
                
//                private static final String TABLE_NAME = "customer";
//    private static final String MAKH_FIELD = "cust_id";
//    private static final String HOKH_FIELD = "ho";
//    private static final String TENKH_FIELD = "ten";
//    private static final String CMND_FIELD = "cmnd";
//    private static final String DIACHI_FIELD = "street";
////    private static final String NGAYSINH_FIELD = "NgaySinh";
//    
//    private static final String SDT_FIELD = "phone";
//    private static final String GIOITINH_FIELD = "gioitinh";
//    private static final String EMAIL_FIELD = "email";

                
                o.setAcc_id(rs.getString("acc_id"));
                o.setCust_id(rs.getString("cust_id"));
                o.setBalance(rs.getInt("balance"));
                o.setTrangthai(rs.getString("trangthai"));
//                o.setCmnd(rs.getString("cmnd"));
//                o.setStreet(rs.getString("street"));
//                
//                o.setPhone(rs.getString("phone"));
//                o.setGioitinh(rs.getString("gioitinh"));
//                o.setEmail(rs.getString("email"));
//                o.setDate(rs.getString("date"));
              
//                st.setCust_id(rs.getString(MAKH_FIELD));
//                st.setHo(rs.getString(HOKH_FIELD));
//                st.setTen(rs.getString(TENKH_FIELD));
//                st.setCmnd(rs.getString(CMND_FIELD));
//                st.setStreet(rs.getString(DIACHI_FIELD));
//                st.setPhone(rs.getString(SDT_FIELD));
//                st.setGioitinh(rs.getString(GIOITINH_FIELD));
//                st.setEmail(rs.getString(EMAIL_FIELD));
                list1.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return list1;
    }
    
    public List<account> getAll(String key) {
        List<account> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+tt+" like '%"+key+"%'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String acc_id = rs.getString(aid);
                String cust_id = rs.getString(cid);
                int balance = rs.getInt(bal);
                String trangthai = rs.getString(tt);

                list.add(new account(acc_id,cust_id ,balance, trangthai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Optional<account> get(int id) {
        account st = new account();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+aid+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 

                st.setAcc_id(rs.getString(aid));
                st.setCust_id(rs.getString(cid));
                st.setBalance(rs.getInt(bal));
                st.setTrangthai(rs.getString(tt));
                
                
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    
    //Optional là một kiểu dữ liệu container, nó bao bọc chỉ một giá trị duy nhất nếu giá trị đó tồn tại.
    //Như vậy mục đích của nó đưa ra là về sự tồn tại của dữ liệu hay không. 
    //Optional<String> optional = Optional.of(str);
    //Tạo một đối tượng Optional chứa giá trị non-null
    

    @Override
    public Optional<account> get(String id) {
        account st = new account();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+aid+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setAcc_id(rs.getString(aid));
                st.setCust_id(rs.getString(cid));
                st.setBalance(rs.getInt(bal));
                st.setTrangthai(rs.getString(tt));
                
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    
    @Override
    public int insert(account t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, ?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getAcc_id());
            ps.setString(2, t.getCust_id());
            ps.setInt(3, t.getBalance());
            ps.setString(4, t.getTrangthai());
            
            int k = ps.executeUpdate();
            if (k > 0) {
                ResultSet rsKey = ps.getGeneratedKeys();  
                if (rsKey.next()) {
                    return rsKey.getInt(1);
                }else{
                    return 1;
                }                
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(account t) {
        try {
            
          
            
            
            String sql_update = "UPDATE "+TABLE_NAME+" SET  "+cid+" = ?, "+bal+" = ?, "+tt+" = ? WHERE "+aid+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(4, t.getAcc_id());
            ps.setString(1, t.getCust_id());
            ps.setInt(2, t.getBalance());
            ps.setString(3, t.getTrangthai());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    
    @Override
    public int delete(account t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+aid+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getAcc_id());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int delete(String t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+aid+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t);
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<account> find(String t) {
        List<account> list = new ArrayList<>();
        try {
            String sql_find = "SELECT * FROM "+TABLE_NAME+ " WHERE ID > 0";
            if (!t.equals("")) {
                sql_find += " AND "+cid+" LIKE '%"+t+"%'";
            } 
            PreparedStatement ps = conn.prepareStatement(sql_find);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String acc_id = rs.getString(aid);
                String cust_id = rs.getString(cid);
                int balance = rs.getInt(bal);
                String trangthai = rs.getString(tt);

                list.add(new account(acc_id,cust_id ,balance, trangthai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<account> find(account t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<account> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findT(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getData(String dataIn, String colIn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<account> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
