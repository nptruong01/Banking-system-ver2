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
import model.user;
//import static QLKS.view.Staffview.df;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;




public class UserDao implements Dao<user>{
    private static final String user = "\"user\"";
    private static final String user_id = "user_id";
    private static final String ho = "ho";
    private static final String ten = "ten";
    private static final String street = "street";
    private static final String phone = "phone";
    private static final String username = "username";
    private static final String pass = "pass";
    private static final String phanquyen = "phanquyen";
    private static final String branch_id = "branch_id";
//    private static final String DIACHI_FIELD = "DiaChi";
    Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public List<user> getAll() {
        List<user> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+user;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                
                String maKH = rs.getString(user_id);
                String HoKH = rs.getString(ho);
                String TenKH = rs.getString(ten);
                String DC = rs.getString(street);
                String SDT = rs.getString(phone);
                String tk = rs.getString(username);
                String mk = rs.getString(pass);
                String pq = rs.getString(phanquyen);
                String macn = rs.getString(branch_id);

                list.add(new user(maKH,HoKH ,TenKH, DC, SDT, tk,  mk,pq,macn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

            public ArrayList<user> getListOto(){
        ArrayList<user> list1 = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user o = new user();
              
                
                o.setUser_id(rs.getString("user_id"));
                o.setHo(rs.getString("ho"));
                o.setTen(rs.getString("ten"));
                o.setStreet(rs.getString("street"));
                o.setPhone(rs.getString("phone"));
                
                o.setUsername(rs.getString("username"));
                o.setPass(rs.getString("pass"));
                o.setPhanquyen(rs.getString("phanquyen"));
                o.setBranch_id(rs.getString("branch_id"));

                list1.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return list1;
    }
    
    public List<user> getAll(String key) {
        List<user> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+user+" where "+ten+" like '%"+key+"%'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maKH = rs.getString(user_id);
                String HoKH = rs.getString(ho);
                String TenKH = rs.getString(ten);
                String DC = rs.getString(street);
                String SDT = rs.getString(phone);
                String tk = rs.getString(username);
                String mk = rs.getString(pass);
                String pq = rs.getString(phanquyen);
                String macn = rs.getString(branch_id);
                
                list.add(new user(maKH,HoKH ,TenKH, DC, SDT, tk,  mk,pq,macn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Optional<user> get(int id) {
        user st = new user();
        try {
            String sql_select_by_id = "SELECT * FROM "+user+" WHERE "+user_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {  
                
                st.setUser_id(rs.getString(user_id));
                st.setHo(rs.getString(ho));
                st.setTen(rs.getString(ten));
                st.setStreet(rs.getString(street));
                st.setPhone(rs.getString(phone));
                st.setUsername(rs.getString(username));
                st.setPass(rs.getString(pass));
                st.setPhanquyen(rs.getString(phanquyen));
                st.setBranch_id(rs.getString(branch_id));
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
    public Optional<user> get(String id) {
        user st = new user();
        try {
            String sql_select_by_id = "SELECT * FROM "+user+" WHERE "+user_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setUser_id(rs.getString(user_id));
                st.setHo(rs.getString(ho));
                st.setTen(rs.getString(ten));
                st.setStreet(rs.getString(street));
                st.setPhone(rs.getString(phone));
                st.setUsername(rs.getString(username));
                st.setPass(rs.getString(pass));
                st.setPhanquyen(rs.getString(phanquyen));
                st.setBranch_id(rs.getString(branch_id));
                
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    
    @Override
    public int insert(user t) {
        try {
            String sql_insert = "insert into "+user+" values(?, ?, ?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getUser_id());
            ps.setString(2, t.getHo());
            ps.setString(3, t.getTen());
            ps.setString(4, t.getStreet());
            ps.setString(5, t.getPhone());
            ps.setString(6, t.getUsername());
            ps.setString(7, t.getPass());
            ps.setString(8, t.getPhanquyen());
            ps.setString(9, t.getBranch_id());
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
    public int update(user t) {
        try {

            String sql_update = "UPDATE "+user+" SET  "+ho+" = ?, "+ten+" = ?, "+street+" = ?, "+phone+" = ?, "+username+" = ?, "+pass+" = ? ,"+phanquyen+" = ? ,"+branch_id+" = ? WHERE "+user_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(9, t.getUser_id());
            ps.setString(1, t.getHo());
            ps.setString(2, t.getTen());
            ps.setString(3, t.getStreet());
            ps.setString(4, t.getPhone());
            ps.setString(5, t.getUsername());
            ps.setString(6, t.getPass());
            ps.setString(7, t.getPhanquyen());
            ps.setString(8, t.getBranch_id());
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
    public int delete(user t) {
        try {
            String sql_delete = "DELETE FROM "+user+" WHERE "+user_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getUser_id());
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
            String sql_delete = "DELETE FROM "+user+" WHERE "+user_id+" = ?";
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
    public List<user> find(String t) {
        List<user> list = new ArrayList<>();
        try {
            String sql_find = "SELECT * FROM "+user+ " WHERE ID > 0";
            if (!t.equals("")) {
                sql_find += " AND "+ten+" LIKE '%"+t+"%'";
            } 
            PreparedStatement ps = conn.prepareStatement(sql_find);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maKH = rs.getString(user_id);
                String HoKH = rs.getString(ho);
                String TenKH = rs.getString(ten);
                String DC = rs.getString(street);
                String SDT = rs.getString(phone);
                String tk = rs.getString(username);
                String mk = rs.getString(pass);
                String pq = rs.getString(phanquyen);
                String macn = rs.getString(branch_id);
                
                list.add(new user(maKH,HoKH ,TenKH, DC, SDT, tk,  mk,pq,macn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<user> find(user t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<user> getList() {
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
    public List<user> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
