
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AdminManageProducts extends javax.swing.JFrame {
    Vector<String> vl;
    ArrayList<products> al;
    mytablemodel tm;
//   Constructor Code Section Starts
    public AdminManageProducts() {
        vl = new Vector<>();
        al = new ArrayList<>();
        tm = new mytablemodel();
        initComponents();
        jTable1.setModel(tm);
        adminShowDropdown();
        showAlreadyAddedProducts();
         Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
         jComboBox1.setModel(new DefaultComboBoxModel<>(vl)); 
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        setSize(width, height);
        setVisible(true);
        
    }   
//  Constructor Code Section Ends    

//  User defined function to display already added product on the table    
     void showAlreadyAddedProducts(){
        try{
            ResultSet  rs = dbloader.executeQuery("Select * from products");
            al.clear();
            while(rs.next()){
               String productname =  rs.getString("productname");
               String desc =   rs.getString("desc");
               int quantity = rs.getInt("quantity");
               String category = rs.getString("category");
               int offerprice = rs.getInt("offerprice");
               al.add(new products(productname,desc,category,offerprice,quantity));
            }
            tm.fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
//  User defined Function Ends Here
     
//     My Table Model Code Section Starts Here
    
           class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
             return al.size();
         }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int i, int j) {
            products obj = al.get(i);
            if(j==0){
                return obj.productname;
            }
            else if(j==1){
            return obj.desc;
        }
            else if(j==2){
                return obj.catname;
            }
            else if(j==3){
                return obj.offerprice;
            }
            else if(j==4){
                return obj.quantity;
            }
           return null;
        }
        @Override
        public String getColumnName(int j){
            String col[] = {"Product Name", "Description","Category Name","Offer Price","Quantity"};
            return col[j];
        }
               
           }    
    
//     My Table Model Code Section Ends Here
     
     
     
//     User Defined function of Dropdown List To Choose Category Code Section   
    void adminShowDropdown(){
        try{
           ResultSet rs = dbloader.executeQuery("Select * from categories");
           while(rs.next()){
               String catname = rs.getString("catname");
               vl.add(catname);
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
//  User Defined Function Ends Here 
    @SuppressWarnings("unchecked")   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel10 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setText("Manage Your Products");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 0, 560, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Add Product");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 50, 150, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Product Name : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 110, 140, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Description : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 170, 130, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Photo:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 270, 120, 30);
        getContentPane().add(tf1);
        tf1.setBounds(320, 100, 230, 40);

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane1.setViewportView(ta1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 160, 234, 90);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(330, 260, 160, 110);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Choose");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 290, 110, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Category :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 390, 110, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(330, 390, 260, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Price :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(120, 440, 110, 30);
        getContentPane().add(tf2);
        tf2.setBounds(330, 440, 260, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setText("Offer Prize : ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(120, 490, 120, 40);
        getContentPane().add(tf3);
        tf3.setBounds(330, 490, 260, 40);

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 620, 180, 50);
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(150, 920, 605, 347);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setText("Quantity :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(120, 550, 130, 30);
        getContentPane().add(tf4);
        tf4.setBounds(330, 540, 260, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("View Product");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(950, 90, 160, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(790, 150, 500, 410);

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(960, 580, 130, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//  Choose Photo Button Code Section  Starts
    File selectedfile;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION){
            selectedfile = jFileChooser1.getSelectedFile();
            try{
                BufferedImage bi = ImageIO.read(selectedfile);
                bi = scale(bi,160,110);
                jLabel6.setIcon(new ImageIcon(bi));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
//  Choose photo button code Section Ends
    
//   Add Button Code Section Starts    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String productname = tf1.getText();
        String desc = ta1.getText();
        int price = Integer.parseInt(tf2.getText());
        int offerprice = Integer.parseInt(tf3.getText());
        String category = (String) jComboBox1.getSelectedItem();
        int quantity = Integer.parseInt(tf4.getText());
        
        try{
           ResultSet rs = dbloader.executeQuery("select * from products where productname = '"+productname+"'");
           if(rs.next()){
               JOptionPane.showMessageDialog(this, "Product Already Exist");
           }
           else{
               String path = SaveFile.saveFile(selectedfile);
               rs.moveToInsertRow();
               rs.updateString("productname",productname);
               rs.updateString("desc",desc);
               rs.updateString("photo",path);
               rs.updateInt("price", price);
               rs.updateInt("offerprice", offerprice);
               rs.updateInt("quantity", quantity);
               rs.updateString("category",category);
               rs.insertRow();
               
               JOptionPane.showMessageDialog(this, "Product Added Successfully");
               showAlreadyAddedProducts();
           }   
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//  Add Button Code Section Ends 
    
//  Delete Button Code Section Starts Here
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this,"Are you sure to delete","Deleting Product ",JOptionPane.YES_NO_OPTION);
            
        if(a == JOptionPane.YES_OPTION){
        int column = 0;
        int row = jTable1.getSelectedRow();
        
        String productname = (String)jTable1.getModel().getValueAt(row,column);
        try{
            ResultSet rs = dbloader.executeQuery("select * from products where productname = '"+productname+"'");
            if(rs.next()){
                rs.deleteRow();
                showAlreadyAddedProducts();
                JOptionPane.showMessageDialog(this, "Product Deleted Successfully");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
//  Delete Button Code Sectiion ends 

//  User defined function for Full Prieview of photo     
     public static BufferedImage scale(BufferedImage src, int w, int h)
{
    BufferedImage img = 
            new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    int x, y;
    int ww = src.getWidth();
    int hh = src.getHeight();
    int[] ys = new int[h];
    for (y = 0; y < h; y++)
        ys[y] = y * hh / h;
    for (x = 0; x < w; x++) {
        int newX = x * ww / w;
        for (y = 0; y < h; y++) {
            int col = src.getRGB(newX, ys[y]);
            img.setRGB(x, y, col);
        }
    }
    return img;
}
    
//  User defined functiion ends    
    
//  Main Function   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminManageProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
