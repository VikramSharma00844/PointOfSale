
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
public class GenerateBill extends javax.swing.JFrame {
   
    
    ArrayList<Cart> al;
    mytablemodel tm;
//  Constructor Code Section
    public GenerateBill() {
        al = new ArrayList<>();
        tm =  new mytablemodel ();
        initComponents();
        jTable1.setModel(tm);
        showCategories();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        getContentPane().setBackground(Color.CYAN);
        int width = (int)d.getWidth();
        int height = (int)d.getHeight();
        setSize(width,height);
        setVisible(true);
    }

//  Constructor Ends HEre
   
   int grandtotal; 
    
//    Code Section of User defined function1 to display different already added Categories on the panel    
    void showCategories(){
     
        int count = 1;
        try {
            
            ResultSet rs = dbloader.executeQuery("select * from categories");
            while (rs.next()) {
                
             
                
                String catname = rs.getString("catname");
                String photo = rs.getString("photo");
                
                JButton bt1 = new JButton();
                bt1.setText(catname);
                
                try {
                    BufferedImage bi = ImageIO.read(new File(photo));
                    
                    bi = scale(bi, 140, 80);
                    
                    bt1.setIcon(new ImageIcon(bi));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                bt1.setHorizontalTextPosition(SwingConstants.CENTER);
                bt1.setVerticalTextPosition(SwingConstants.BOTTOM);
                
                bt1.setBounds(75, 135*count,140,120);
                
                bt1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showProducts(catname);
                    }
                });
                
                jPanel1.add(bt1);
                jPanel1.repaint();
                
                count++;
                
            }
              
              } catch (Exception ex) {
            ex.printStackTrace();
        }
        jPanel1.setPreferredSize(new Dimension(250,150*count));
      
    }
//  User defined functiion1 ends here 
    
    void Cart(String productname){
        String ans = JOptionPane.showInputDialog(this,"Enter Quantity");
        int quantity = Integer.parseInt(ans);
        try{
        ResultSet rs2 = dbloader.executeQuery("Select * from products where productname = '"+productname+"'");
        if(rs2.next()){
            int databaseQuantity = rs2.getInt("quantity");
            
            
            if(databaseQuantity>=quantity){
                ResultSet rs3 = dbloader.executeQuery("Select * from products where productname = '"+productname+"'");
                if(rs3.next()){
                    rs3.updateInt("quantity", databaseQuantity-quantity);
                    rs3.updateRow();
                }
                
                
                
                
                 String catname;
        int offerprice;
        int perTotal;
        
        try {
            ResultSet rs = dbloader.executeQuery("select * from products where productname = '" + productname + "' ");
            if (rs.next()) {
                catname = rs.getString("category");
                offerprice =rs.getInt("offerprice");
                perTotal = quantity*offerprice;
                grandtotal = grandtotal + perTotal;
                Global.grandTotal = grandtotal;
                jLabel6.setText(grandtotal + "");
                al.add(new Cart(productname, catname, quantity, offerprice,perTotal));
            }
            
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            }
            
            else{
                JOptionPane.showMessageDialog(this, "Quantity Exceeds");
            }
        }
        }catch (Exception ex){
            ex.printStackTrace();
        }   
    }
    
    
//  Code of User Defined Function2 to display Different Products of choosen Category on Panel2
    void showProducts(String catname)
    {
        jPanel2.removeAll();
        int count = 1;
        try {
            
            ResultSet rs = dbloader.executeQuery("select * from products where category = '"+catname+"' ");
            while (rs.next()) {
                
                String productname = rs.getString("productname");
                String photo = rs.getString("photo");
                
                JButton bt2 = new JButton();
                bt2.setText(productname);
                
                try {
                    BufferedImage bi = ImageIO.read(new File(photo));
                    
                    bi = scale(bi, 140, 80);
                    
                    bt2.setIcon(new ImageIcon(bi));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                bt2.setHorizontalTextPosition(SwingConstants.CENTER);
                bt2.setVerticalTextPosition(SwingConstants.BOTTOM);
                
                bt2.setBounds(75, 135*count,140,120);
                
                jPanel2.add(bt2);
                jPanel2.repaint();
                
                bt2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Cart(productname);
                    }
                });
                
                count++;
                
            }jPanel2.setPreferredSize(new Dimension(250,150*count));
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        
    }
//  User Defined function2 ends here

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("New Billing Form ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(600, 10, 420, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("Choose Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 90, 200, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setText("Choose Product");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 100, 180, 40);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 160, 330, 420);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 160, 330, 420);

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
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(830, 160, 490, 330);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("Your Cart ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1070, 100, 130, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Grand Total");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(870, 500, 110, 40);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Generate Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1010, 540, 240, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1160, 500, 210, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminGetDetails obj = new AdminGetDetails(al);
        
    }//GEN-LAST:event_jButton1ActionPerformed

//  Code for full Prieview of photo    
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
//  Code of Full Preview ends here
    
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
           Cart obj =  al.get(i);
           if(j==0){
               return obj.productname;
           }
           else if(j==1){
               return obj.catname;
           }
           else if(j==2){
               return obj.quantity;
           }
           else if(j==3){
               return obj.offerprice;
           }
           else{
               return obj.perTotal;
           }
           
        }
        @Override
        public String getColumnName(int j){
            String col[] = {"Product Name","Category ","Quantity","Offer Price","perTotal"};
            return col[j];
                    }
      
  }  
    
    
//  Main Function 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
