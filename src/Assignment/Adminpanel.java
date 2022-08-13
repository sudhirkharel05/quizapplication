
package Assignment;
import javax.swing.JFrame;

public class Adminpanel extends javax.swing.JFrame {
//consist of 4 buttons which has 4 different function
    public Adminpanel() {
        initComponents(); 
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnmin = new javax.swing.JLabel();
        btncancel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btngenerate1 = new javax.swing.JButton();
        btnquestion = new javax.swing.JButton();
        btnset = new javax.swing.JButton();
        btncategory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to the Admin Panel");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 40, 580, 60);

        btnmin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnmin.setForeground(new java.awt.Color(255, 255, 255));
        btnmin.setText("  -");
        btnmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminMouseClicked(evt);
            }
        });
        jPanel1.add(btnmin);
        btnmin.setBounds(1040, 0, 30, 30);

        btncancel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("  X");
        btncancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelMouseClicked(evt);
            }
        });
        jPanel1.add(btncancel);
        btncancel.setBounds(1070, 0, 30, 30);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(null);

        btngenerate1.setBackground(new java.awt.Color(255, 153, 51));
        btngenerate1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btngenerate1.setForeground(new java.awt.Color(255, 255, 255));
        btngenerate1.setText("GENERATE USERNAME & PASSWORD");
        btngenerate1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngenerate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerate1ActionPerformed(evt);
            }
        });
        jPanel2.add(btngenerate1);
        btngenerate1.setBounds(40, 210, 380, 110);

        btnquestion.setBackground(new java.awt.Color(255, 153, 51));
        btnquestion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnquestion.setForeground(new java.awt.Color(255, 255, 255));
        btnquestion.setText("MAKE QUESTIONS");
        btnquestion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnquestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnquestionMouseClicked(evt);
            }
        });
        btnquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquestionActionPerformed(evt);
            }
        });
        jPanel2.add(btnquestion);
        btnquestion.setBounds(650, 210, 380, 110);

        btnset.setBackground(new java.awt.Color(255, 153, 51));
        btnset.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnset.setForeground(new java.awt.Color(255, 255, 255));
        btnset.setText("ADD SET");
        btnset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsetMouseClicked(evt);
            }
        });
        btnset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsetActionPerformed(evt);
            }
        });
        jPanel2.add(btnset);
        btnset.setBounds(40, 400, 380, 110);

        btncategory.setBackground(new java.awt.Color(255, 153, 51));
        btncategory.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btncategory.setForeground(new java.awt.Color(255, 255, 255));
        btncategory.setText("ADD CATEGORY");
        btncategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncategoryMouseClicked(evt);
            }
        });
        btncategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncategoryActionPerformed(evt);
            }
        });
        jPanel2.add(btncategory);
        btncategory.setBounds(650, 400, 380, 110);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminMouseClicked
       
        this.setState(JFrame.ICONIFIED);// minimize
    }//GEN-LAST:event_btnminMouseClicked

    private void btncancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelMouseClicked
        
        System.exit(0);
        
    }//GEN-LAST:event_btncancelMouseClicked

    private void btngenerate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerate1ActionPerformed
        generateUsername gn = new generateUsername();
        gn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btngenerate1ActionPerformed

    private void btnquestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnquestionMouseClicked
           Questionsadd que = new Questionsadd();
           que.setVisible(true);
           
           
           this.dispose();
             
           
    }//GEN-LAST:event_btnquestionMouseClicked

    private void btnquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquestionActionPerformed
            
    }//GEN-LAST:event_btnquestionActionPerformed

    private void btnsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsetActionPerformed

    private void btncategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncategoryMouseClicked
       AddCategory acat = new AddCategory();
       acat.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btncategoryMouseClicked

    private void btncategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncategoryActionPerformed

    private void btnsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsetMouseClicked
        Setadd aset = new Setadd();
        aset.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsetMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminpanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btncancel;
    private javax.swing.JButton btncategory;
    private javax.swing.JButton btngenerate1;
    private javax.swing.JLabel btnmin;
    private javax.swing.JButton btnquestion;
    private javax.swing.JButton btnset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
