/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;
// this class is the studnent dashboard where it contains the data of student along with the test of subject that they want to perform
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SUDHIR
 */
public class TakeTest extends javax.swing.JFrame {

    int studentid;
   Connection con;
    
    public TakeTest(int id) {
        initComponents();
        this.studentid=id;
        con = MyConnection.getConnection();
        StudentDetails();
        studentExamDetail(); // initialize the student data in the table
        Fillcombo(); // fills the combobox with the subject name
        this.setLocationRelativeTo(null); // locate them in the center
    }

     public void Fillcombo(){
        try{
            catcombo.removeAllItems();
            String sql="SELECT * FROM `category`";
            Connection con = MyConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("subject");
                catcombo.addItem(name);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
     private void StudentDetails(){
         //loading the student details
         try{
              Connection con = MyConnection.getConnection();
            String query = "SELECT * from students where student_id = "+studentid+"";
            PreparedStatement ps = con.prepareStatement(query);
            
             ResultSet rs = ps.executeQuery(query);
             while(rs.next()){
                 lblstudentname.setText(rs.getString("Student_name"));
                 lblbatch.setText(rs.getString("Batch"));
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     private void studentExamDetail(){
         //codes for showing the student exam details
         DefaultTableModel model = (DefaultTableModel)tblexamdetails.getModel();
         try{
         String query = "Select s.set_student_id, s.marks, c.subject, sn.set_name, sn.set_id from set_students AS s, category AS c, sets AS sn, students AS st WHERE s.student_id ="+studentid+" AND s.student_id = st.student_id AND s.set_id = sn.set_id AND sn.category_id = c.category_id"; 
         Connection con = MyConnection.getConnection();
         PreparedStatement ps;
         ps = con.prepareStatement(query);
        
         ResultSet rs = ps.executeQuery(query);
         while(rs.next()){
         Object row[]={rs.getString("subject"),rs.getString("set_name"),rs.getInt("marks")};
         model.addRow(row);
         }}
         catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
         }
    }
     
     ArrayList total_sets = new ArrayList();
     private void availablesets(){
         //codes for checking the sets
         try {
           String query = "Select s.* from sets as s,category as c where"
                   + " c.subject = '"+catcombo.getSelectedItem()+"' and c.category_id = s.category_id";
            Connection con = MyConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while(rs.next()){
                total_sets.add(rs.getInt("set_id"));
            }
         }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     int setid;
     public Boolean set(){
         Boolean result = false;
         for(int i=0; i<total_sets.size(); i++){
             setid=Integer.parseInt(total_sets.get(i).toString());
             Boolean results = checkGiven();
             if(results==false){
                 result = true;
                 break;
             }
         }
         return result;
     }
     public Boolean checkGiven(){
         int counter =0;
         try{
             String query = "SELECT * from set_students WHERE set_id="+setid+"";
             Connection con = MyConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(query);
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  counter++;
              }
              
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         return counter >0;
     }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblexamdetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        catcombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblstudentname = new javax.swing.JLabel();
        lblbatch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        tblexamdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "subject", "set name", "Mark"
            }
        ));
        jScrollPane1.setViewportView(tblexamdetails);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("YOUR PROFILE");

        catcombo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        catcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcomboActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setText("Select Category ");

        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblstudentname.setText("jLabel3");

        lblbatch.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblstudentname)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(catcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblbatch))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(461, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(174, 174, 174)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblstudentname)
                .addGap(18, 18, 18)
                .addComponent(lblbatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(319, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(225, 225, 225)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    int id;
    String cat;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
      try{
          availablesets();
          Boolean result = set();
          if(result == true){
              Test ts = new Test(studentid, setid); // passing the arguments to the next form
              ts.setVisible(true);
              this.dispose();
          }
          else{
              // displays the message when no any sets are available
             JOptionPane.showMessageDialog(null, "You have given exam of all the set."); 
          }
      }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void catcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catcomboActionPerformed

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
            java.util.logging.Logger.getLogger(TakeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        java.awt.EventQueue.invokeLater(new Runnable() {
              int studentid=0;
            public void run() {
                
                try{
                new TakeTest(studentid).setVisible(true);
                }
                catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> catcombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbatch;
    private javax.swing.JLabel lblstudentname;
    private javax.swing.JTable tblexamdetails;
    // End of variables declaration//GEN-END:variables
}
