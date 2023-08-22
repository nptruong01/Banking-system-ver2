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
import model.giaodich;
//import static QLKS.view.Staffview.df;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.capnhat;
import model.chuyenkhoan;
import model.naptien;




public class giaodichDao implements Dao<giaodich>{
    private static final String TABLE_NAME = "giaodich";
    private static final String gd_id = "gd_id";
    private static final String acc_id = "acc_id";
    private static final String toacc_id = "toacc_id";
    private static final String type = "type";
    private static final String date = "date";
//    private static final String NGAYSINH_FIELD = "NgaySinh";
    
    private static final String amount = "amount";
    private static final String branch_id = "branch_id";
//    private static final String EMAIL_FIELD = "email";
//    private static final String DIACHI_FIELD = "DiaChi";
    Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public List<giaodich> getAll() {
        List<giaodich> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String magd = rs.getString(gd_id);
                String accid = rs.getString(acc_id);
                String toacc=  rs.getString(toacc_id);
                String loai = rs.getString(type);
                String ngay = rs.getString(date);
                int num = rs.getInt(amount);
//                String SDT = rs.getString(amount);
                String macn = rs.getString(branch_id);
//                String Email = rs.getString(EMAIL_FIELD);
                
                
                
                list.add(new giaodich(magd,accid ,toacc, loai, ngay, num,  macn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

            public ArrayList<giaodich> getListOto(){
        ArrayList<giaodich> list1 = new ArrayList<>();
        String sql = "SELECT * FROM giaodich";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                giaodich o = new giaodich();

    
                o.setGd_id(rs.getString("gd_id"));
                o.setAcc_id(rs.getString("acc_id"));
                o.setToacc_id(rs.getString("toacc_id"));
                o.setType(rs.getString("type"));
                o.setDate(rs.getString("date"));
                
                o.setAmount(rs.getInt("amount"));
                o.setBranch_id(rs.getString("branch_id"));

                list1.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return list1;
    }
    
    public List<giaodich> getAll(String key) {
        List<giaodich> list = new ArrayList<>();
        try {
//            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+acc_id+" like '%"+key+"%'";
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+acc_id+" like '"+key+"'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String magd = rs.getString(gd_id);
                String accid = rs.getString(acc_id);
                String toacc=  rs.getString(toacc_id);
                String loai = rs.getString(type);
                String ngay = rs.getString(date);
                int num = rs.getInt(amount);
//                String SDT = rs.getString(amount);
                String macn = rs.getString(branch_id);
//                String Email = rs.getString(EMAIL_FIELD);
                
                
                
                list.add(new giaodich(magd,accid ,toacc, loai, ngay, num,  macn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Optional<giaodich> get(int id) {
        giaodich st = new giaodich();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+gd_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {   
                
                
                
                st.setGd_id(rs.getString(gd_id));
                st.setAcc_id(rs.getString(acc_id));
                st.setToacc_id(rs.getString(toacc_id));
                st.setType(rs.getString(type));
                st.setDate(rs.getString(date));
                st.setAmount(rs.getInt(amount));
                st.setBranch_id(rs.getString(branch_id));
//                st.setBranch_id(rs.getString(EMAIL_FIELD));
                
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    

    

    @Override
    public Optional<giaodich> get(String id) {
        giaodich st = new giaodich();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+gd_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
 
                st.setGd_id(rs.getString(gd_id));
                st.setAcc_id(rs.getString(acc_id));
                st.setToacc_id(rs.getString(toacc_id));
                st.setType(rs.getString(type));
                st.setDate(rs.getString(date));
                st.setAmount(rs.getInt(amount));
                st.setBranch_id(rs.getString(branch_id));
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    
    @Override
    public int insert(giaodich t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, ?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getGd_id());
            ps.setString(2, t.getAcc_id());
            ps.setString(3, t.getToacc_id());
            ps.setString(4, t.getType());
            ps.setString(5, t.getDate());
            ps.setInt(6, t.getAmount());
            ps.setString(7, t.getBranch_id());
//            ps.setString(8, t.getEmail());
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
    public int naptien(naptien t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, null,'naptien',?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getGd_id());
            ps.setString(2, t.getAcc_id());
            ps.setString(3, t.getDate());
            ps.setInt(4, t.getAmount());
            ps.setString(5, t.getBranch_id());

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

    public int ruttien(naptien t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, null,'ruttien',?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getGd_id());
            ps.setString(2, t.getAcc_id());
            ps.setString(3, t.getDate());
            ps.setInt(4, t.getAmount());
            ps.setString(5, t.getBranch_id());

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
    
    public int chuyenkhoan(chuyenkhoan t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, ?,'chuyentien',?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getGd_id());
            ps.setString(2, t.getAcc_id());
            ps.setString(3, t.getToacc_id());
            ps.setString(4, t.getDate());
            ps.setInt(5, t.getAmount());
            ps.setString(6, t.getBranch_id());
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
    
        public int update(giaodich t) {
        try {
            
          
            
            
            String sql_update = "UPDATE "+TABLE_NAME+" SET  "+acc_id+" = ?, "+toacc_id+" = ?, "+type+" = ?, "+date+" = ?, "+amount+" = ?, "+branch_id+" = ?  WHERE "+gd_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(7, t.getGd_id());
            ps.setString(1, t.getAcc_id());
            ps.setString(2, t.getToacc_id());
            ps.setString(3, t.getType());
            ps.setString(4, t.getDate());
            ps.setInt(5, t.getAmount());
            ps.setString(6, t.getBranch_id());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int congtien(capnhat t) {
        try {
                        
            String sql_update = "UPDATE account SET  balance = balance+?  WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(2, t.getAcc_id());        
            ps.setInt(1, t.getBalance());
            
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int trutien(capnhat t) {
        try {
                        
            String sql_update = "UPDATE account SET  balance = balance-?  WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(2, t.getAcc_id());
            ps.setInt(1, t.getBalance());
            
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
    public int delete(giaodich t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+gd_id+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getGd_id());
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
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+gd_id+" = ?";
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
    public List<giaodich> find(String t) {
        List<giaodich> list = new ArrayList<>();
        try {
            String sql_find = "SELECT * FROM "+TABLE_NAME+ " WHERE ID > 0";
            if (!t.equals("")) {
                sql_find += " AND "+acc_id+" LIKE '%"+t+"%'";
            } 
            PreparedStatement ps = conn.prepareStatement(sql_find);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String magd = rs.getString(gd_id);
                String accid = rs.getString(acc_id);
                String toacc=  rs.getString(toacc_id);
                String loai = rs.getString(type);
                String ngay = rs.getString(date);
                int num = rs.getInt(amount);
//                String SDT = rs.getString(amount);
                String macn = rs.getString(branch_id);
//                String Email = rs.getString(EMAIL_FIELD);
                
                
                
                list.add(new giaodich(magd,accid ,toacc, loai, ngay, num,  macn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<giaodich> find(giaodich t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<giaodich> getList() {
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
    public List<giaodich> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
