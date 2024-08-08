
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AdminManageCategories extends javax.swing.JFrame {
// Table Portion Starts Here 
    ArrayList<categories> al;
    mytablemodel tm;
//  Constructor Portion Start
    public AdminManageCategories() {
        al = new ArrayList<>();
        tm = new mytablemodel();
        
        initComponents();
        jTable1.setModel(tm);
        showAlreadyAddedCategories();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        setSize(width, height);
        setTitle("Manage Categories");
        setVisible(true);
    }
// Constructor Portion End
   
//  Function Created for the table
    void showAlreadyAddedCategories(){
        try{
            ResultSet  rs = dbloader.executeQuery("Select * from categories");
            al.clear();
            while(rs.next()){
               String catname =  rs.getString("catname");
               String desc =   rs.getString("description");
               al.add(new categories(catname,desc));
            }
            tm.fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
//  Function ends here
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Manage  Your  Categories");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 10, 590, 80);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("ADD NEW CATEGORY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 130, 250, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Category Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 230, 120, 30);
        getContentPane().add(tf1);
        tf1.setBounds(310, 230, 220, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Description :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 340, 90, 30);

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane1.setViewportView(ta1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 300, 290, 130);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Photo :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 530, 50, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Choose Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(300, 460, 200, 140);

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setText("Choose File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 530, 100, 30);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 640, 140, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category Name", "Description"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(760, 200, 452, 402);

        jButton3.setBackground(new java.awt.Color(255, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(900, 640, 150, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Already Added Categories");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(940, 120, 310, 40);
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(90, 870, 605, 347);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  // Add Button Code Section Starts here
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String catname = tf1.getText();
        String desc = ta1.getText();
        try{
        ResultSet rs = dbloader.executeQuery("Select * from categories where catname = '"+catname+"' and description = '"+desc+"'");
        if(rs.next()){
            JOptionPane.showMessageDialog(this,"This Category is already Added");
        }
        else{
            String path = SaveFile.saveFile(selectedfile);
            rs.moveToInsertRow();
            
            rs.updateString("catname", catname);
            rs.updateString("description", desc);
            rs.updateString("photo", path);
            rs.insertRow();
            
            JOptionPane.showMessageDialog(this, "Category Added Successfully");
            showAlreadyAddedCategories();
        }
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
//Add Button Code Section Ends Here
    
//   Chooose file Button Code Section Starts 
    File selectedfile;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION){
            selectedfile = jFileChooser1.getSelectedFile();
            try{
                BufferedImage bi = ImageIO.read(selectedfile);
                bi = scale(bi,200,140);
                jLabel6.setIcon(new ImageIcon(bi));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//   Choose File Button Code Section Ends Here

//   Delete Button Code Section Starts Here
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         int a = JOptionPane.showConfirmDialog(this,"Are you sure to delete","Deleting Something",JOptionPane.YES_NO_OPTION);
            
        if(a == JOptionPane.YES_OPTION){
        int column = 0;
        int row = jTable1.getSelectedRow();
        
        String catname = (String)jTable1.getModel().getValueAt(row,column);
        try{
            ResultSet rs = dbloader.executeQuery("select * from categories where catname = '"+catname+"'");
            if(rs.next()){
                rs.deleteRow();
                showAlreadyAddedCategories();
                JOptionPane.showMessageDialog(this, "Category Deleted Successfully");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
   
//  Delete Button Code Section Ends Here  
    
//     My Table Model Code Section Starts Here
    
           class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
             return al.size();
         }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int i, int j) {
            categories obj = al.get(i);
            if(j==0){
                return obj.catname;
            }
            else if(j==1){
            return obj.desc;
        }
           return null;
        }
        @Override
        public String getColumnName(int j){
            String col[] = {"Category Name", "Description"};
            return col[j];
        }
               
           }    
    
//     My Table Model Code Section Ends Here
           
           
//     For full Preview of  Choose Photo 
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
//  Full Preview of photo Code Section ends here
    
//  Main Function Starts Here
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminManageCategories().setVisible(true);
            }
        });
    }
//   Main Functions  End Here
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
