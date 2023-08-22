package ChucNang;



import Connect.MySQLConnection;
import controller.AccountDao;
import controller.CustomerDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.account;
import model.customer;
import sun.util.logging.PlatformLogger;


/**
 *
 * @author MSI-VN
 */
public class Account1 extends javax.swing.JFrame {
    
    MySQLConnection connection = new MySQLConnection();
    DefaultTableModel tableModel;
    /**
     * Creates new form AddInventory
     */
    public Account1() {
        initComponents();
        setTitle("Quản Lý Thông Tin Tài Khoản");
//        ShowOto();
//        autoID();
//        kho();
//        ncc();
//        date();

//        list1 = new CustomerDao().getListOto();
//        model = (DefaultTableModel) tableKH.getModel();
//        showTable();
          loadTable();
          loadTable1();
          autoID();
//        ShowOto();

    }
    

    
    private void reset(){
        txtma.setText("");
        
        txtcust.setText("");
        
    } 
    
    DefaultTableModel dtmDanhSach;
    AccountDao accdao = new AccountDao();
    private void loadTable(){
        dtmDanhSach = new DefaultTableModel();
        String[] columnTitle = {"Mã Tài Khoản",  "Mã Khách Hàng", "Số Dư", "Trạng Thái"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<account> lisacc = accdao.getAll();
        for (account p : lisacc) {
            
            
            dataRow = new Object[]{p.getAcc_id(),  p.getCust_id(), p.getBalance(), p.getTrangthai()};
            dtmDanhSach.addRow(dataRow);
        }

        tableTK.setModel(dtmDanhSach);
        
        tableTK.getColumnModel().getColumn(0).setPreferredWidth(15);
        tableTK.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableTK.getColumnModel().getColumn(2).setPreferredWidth(25);
        tableTK.getColumnModel().getColumn(3).setPreferredWidth(40);
//        tableKH.getColumnModel().getColumn(4).setPreferredWidth(250);
//        tableKH.getColumnModel().getColumn(5).setPreferredWidth(90);
//        tableKH.getColumnModel().getColumn(6).setPreferredWidth(40);
//        tableKH.getColumnModel().getColumn(7).setPreferredWidth(100);
        

        
    }
    
    CustomerDao customerdao = new CustomerDao();
    private void loadTable1(){
        dtmDanhSach = new DefaultTableModel();
        String[] columnTitle = {"Mã KH",  "Họ", "Tên", "CMND"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<customer> liscustomer = customerdao.getAll();
        for (customer p : liscustomer) {
            dataRow = new Object[]{p.getCust_id(),  p.getHo(), p.getTen(), p.getCmnd()};
            dtmDanhSach.addRow(dataRow);
        }

        tableKH.setModel(dtmDanhSach);
        
        tableKH.getColumnModel().getColumn(0).setPreferredWidth(15);
        tableKH.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableKH.getColumnModel().getColumn(2).setPreferredWidth(25);
        tableKH.getColumnModel().getColumn(3).setPreferredWidth(40);
        
        

        
    }
 
//    public void showTable() {
//        for (customer s : list1) {
//            model.addRow(new Object[]{
//                s.getCust_id(), s.getHo(), s.getTen(), s.getCmnd(), s.getStreet(), s.getPhone(), s.getGioitinh(), s.getEmail()
//            });
//        }
//    }

//    public void date()
//    {
//
//        
//        
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        String date = dtf.format(now);
//     
//        txtdate.setText(date);
// 
//    }
        Connection con;
        public void autoID()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=bank; user=sa;password=123456");
            Statement s = con.createStatement();
            
            ResultSet rs =s.executeQuery("select Max(acc_id)as 'MAX(id)' from account ");
            rs.next();
            rs.getString("MAX(id)");
            if (rs.getString("MAX(id)") == null) {
                txtma.setText("A001");     
            } else {
                long id = Long.parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
                id++;
                txtma.setText("A" + String.format("%03d", id));
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Account1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Account1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
//        public void kho()
//    {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            insert = con.prepareStatement("SELECT * FROM kho");
//            Statement s = con.createStatement();
//            ResultSet rs = insert.executeQuery();
//            jComboBox1.removeAllItems();
//             while(rs.next())
//             {
//               jComboBox1.addItem(rs.getString(1) );        
//             }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
    
//        public void ncc()
//    {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            insert = con.prepareStatement("SELECT * FROM NhaCungCap");
//            Statement s = con.createStatement();
//            ResultSet rs = insert.executeQuery();
//            jComboBox2.removeAllItems();
//             while(rs.next())
//             {
//               jComboBox2.addItem(rs.getString(1) );        
//             }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
//        private void ShowOto(){
//            DefaultTableModel tableModel= (DefaultTableModel)tableKH.getModel();
//            tableModel.setRowCount(0);
//            Connection conn = connection.ConnectMySQL();
//            Statement Stmt = null;
//            ResultSet rs = null;
//        try {
//            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT `maoto`,hang,loai,`tenoto`, `donvitinh`, `tonkho`,  `mausac` FROM `oto`");
//            rs = cStmt.executeQuery();
//            while(rs.next()){
////                String id = rs.getString("id");
//                String maoto = rs.getString("maoto");
//                String hang = rs.getString("hang");
//                String loai = rs.getString("loai");
//                String tenoto = rs.getString("tenoto");
//                String donvitinh = rs.getString("donvitinh");
////                 String tonkho = rs.getString("tonkho");
////                 String makho = rs.getString("makho");
////                 String mancc = rs.getString("mancc");
//                String mausac = rs.getString("mausac");
//                        if(mausac.equals("0")){
//                            mausac = "Đỏ";
//                        }else if(mausac.equals("1")){
//                            mausac = "Đen";
//                        }else{
//                            mausac = "Trắng";
//                        }
////                String date = rs.getString("date");
//                tableModel.addRow(new String[]{maoto,hang,loai, tenoto, donvitinh,mausac});
//            } 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
 
//              private void table_update() {
//
//                  int CC;
//        
//                  try {
//            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            
//            insert = con.prepareStatement("SELECT * FROM oto2");
//             ResultSet Rs = insert.executeQuery();
//            
//   
//            ResultSetMetaData RSMD = Rs.getMetaData();
//            CC = RSMD.getColumnCount();
//            DefaultTableModel DFT = (DefaultTableModel) ototable.getModel();
//            DFT.setRowCount(0);
//
//            while (Rs.next()) {
//                Vector v2 = new Vector();
//           
//                for (int ii = 1; ii <= CC; ii++) {
//                    v2.add(Rs.getString("id"));
//                    v2.add(Rs.getString("maoto"));
//                    v2.add(Rs.getString("tenoto"));
//                     v2.add(Rs.getString("donvitinh"));
//                     v2.add(Rs.getString("tonkho"));
//                    v2.add(Rs.getString("makho"));
//                    v2.add(Rs.getString("mancc"));
//                     v2.add(Rs.getString("mausac"));
//                     v2.add(Rs.getString("date"));
// 
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                }
//
//                DFT.addRow(v2);
//            }
//        } catch (Exception e) {
//        }
//    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Exit1 = new javax.swing.JButton();
        Exit2 = new javax.swing.JButton();
        txtcust = new javax.swing.JTextField();
        txtbal = new javax.swing.JLabel();
        txttt = new javax.swing.JLabel();
        txtma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTK = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();
        txtma1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Inventory in Warehouse");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 709));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THÔNG TIN TÀI KHOẢN");

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setToolTipText("");
        jPanel3.setEnabled(false);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(361, 272));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Trạng Thái");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Khách Hàng");

        jButton1.setBackground(new java.awt.Color(114, 114, 244));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Thêm");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(114, 114, 244));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Xóa");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mã Tài Khoản");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số Dư");

        Exit1.setBackground(new java.awt.Color(255, 51, 51));
        Exit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit1.setText("Thoát");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        Exit2.setBackground(new java.awt.Color(102, 255, 102));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Reset");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        txtcust.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcust.setText("Chọn bên trong Bảng thông tin KH");
        txtcust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtcustMouseExited(evt);
            }
        });
        txtcust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustActionPerformed(evt);
            }
        });

        txtbal.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtbal.setForeground(new java.awt.Color(0, 0, 255));
        txtbal.setText("0");

        txttt.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txttt.setForeground(new java.awt.Color(255, 51, 51));
        txttt.setText("Active");

        txtma.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma.setForeground(new java.awt.Color(255, 51, 51));
        txtma.setText("ID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcust, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );

        tableTK.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTK);

        tableKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKH);

        txtma1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtma1.setForeground(new java.awt.Color(51, 51, 51));
        txtma1.setText("Bảng Thông Tin Khách Hàng");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/debit-card.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel12)
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(txtma1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtma1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1698, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        private Boolean checkMa(String ma){
        List<account> list = new ArrayList<>();
        list = accdao.getAll();
        for (account b : list) {
            if(ma.equals(b.getAcc_id())){
                return true;
            }
        }
        return false;
    }
    private void tableTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTKMouseClicked
        
                txtma.setEnabled(false);
                DefaultTableModel tableModel= (DefaultTableModel)tableTK.getModel();
                String ma = tableModel.getValueAt(tableTK.getSelectedRow(), 0).toString();
                
        
        
                txtma.setText(ma);
                 

    }//GEN-LAST:event_tableTKMouseClicked

    private void txtcustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustActionPerformed

    private void txtcustMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcustMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustMouseExited

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        txtma.setEnabled(true);
                autoID();
                reset();
        
    }//GEN-LAST:event_Exit2ActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa tài khoản này?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){

            int a = accdao.delete(txtma.getText());
            if (a==1) {
                JOptionPane.showMessageDialog(this,"Xoá tài khoản thành công!","Xóa tài khoản",JOptionPane.INFORMATION_MESSAGE);
//                lblerro.setText("");
                loadTable();
                autoID();
            }else
            JOptionPane.showMessageDialog(this,"Xoá tài khoản thất bại!","Xóa tài khoản",JOptionPane.INFORMATION_MESSAGE);

        }
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (txtma.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Hãy điền mã tài khoản");
        } else if(checkMa(txtma.getText())==true){
            JOptionPane.showMessageDialog(this,"Mã tài khoản bị trùng");
        } else if(txtcust.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Hãy điền mã khách hàng");
        
        }else {
            
                
                String ma = String.valueOf(txtma.getText()).trim();
                String cid = String.valueOf(txtcust.getText()).trim();
                int bal = Integer.parseInt(txtbal.getText());
//                float bal = Float.parseFloat(txtbal.getText());
                String tt = String.valueOf(txttt.getText()).trim();
         
//        String gia = String.valueOf(txtgia.getText()).trim();
////        String soluong = String.valueOf(txtsoluong.getText()).trim();
//        String Mau =jComboBox3.getSelectedItem().toString();
//        String mau = chuyendoiMau(Mau);
            
                account newcustomer = new account(ma, cid,bal, tt);
                int a = accdao.insert(newcustomer);

                    JOptionPane.showMessageDialog(this,"Thêm tài khoản thành công","Thêm tài khoản",JOptionPane.INFORMATION_MESSAGE);

            }

        loadTable();
        autoID();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKHMouseClicked

        DefaultTableModel tableModel= (DefaultTableModel)tableKH.getModel();
        String ma = tableModel.getValueAt(tableKH.getSelectedRow(), 0).toString();
        

        txtcust.setText(ma);
        
    }//GEN-LAST:event_tableKHMouseClicked
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Account1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account1().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableKH;
    private javax.swing.JTable tableTK;
    private javax.swing.JLabel txtbal;
    private javax.swing.JTextField txtcust;
    private javax.swing.JLabel txtma;
    private javax.swing.JLabel txtma1;
    private javax.swing.JLabel txttt;
    // End of variables declaration//GEN-END:variables
}
