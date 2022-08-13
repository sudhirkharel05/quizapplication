package Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Questionsadd extends javax.swing.JFrame {

    public Questionsadd() {
        initComponents();
        this.setLocationRelativeTo(null);
        show_question(); // shows the question in the table initially 
        Fillcombo();// fills the category list in the coombobox
        txtid.setVisible(false);
        btndelete.setVisible(false);// the delete and update butto will be visible only if the user want to update and delete the data 
        //the button will be visible if the user click the row in the table
        btnupdate.setVisible(false);
           
    }
    public void Fillcombo(){
        try{
            String sql="SELECT * FROM `category`";
            Connection con = MyConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("subject");
                setcatcombo.addItem(name); // add the item in category combo box
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void Fillsetcombo(){
        try{
            String sql="SELECT * FROM `sets` WHERE `category_id`=(SELECT `category_id` FROM `category` WHERE `subject` ='"+setcatcombo.getSelectedItem().toString()+"')";
            Connection con = MyConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("set_name");
                setcombo.addItem(name);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //collection of question
    public ArrayList<Question> questionList(){
        ArrayList<Question>questionList = new ArrayList<>();
        try{
        Connection con = MyConnection.getConnection();
        
        String query1 = "SELECT * FROM `question`";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);
        Question question;
        while(rs.next()){
            question = new Question(rs.getInt("question_id"),rs.getString("question"), rs.getString("option1"),rs.getString("option2"), rs.getString("option3"), rs.getString("option4"), rs.getString("correct"));
            questionList.add(question);
        }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return questionList;
    }
    public void show_question(){
        //showing the question in the table
    ArrayList<Question> list = questionList();
    DefaultTableModel model =(DefaultTableModel) jtablequestion.getModel();
    Object[] row = new Object[7];
    for(int i =0; i<list.size(); i++){
        row[0]= list.get(i).getquestion_id();
        row[1]= list.get(i).getquestion();
        row[2]= list.get(i).getoption1();
        row[3]= list.get(i).getoption2();
        row[4]= list.get(i).getoption3();
        row[5]= list.get(i).getoption4();
        row[6]= list.get(i).getcorrect();
        model.addRow(row);
        
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jaddquestion = new javax.swing.JTextField();
        opt2 = new javax.swing.JTextField();
        opt1 = new javax.swing.JTextField();
        optcorrect = new javax.swing.JTextField();
        opt4 = new javax.swing.JTextField();
        opt3 = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btnsubmit = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablequestion = new javax.swing.JTable();
        txtid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        setcatcombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        setcombo = new javax.swing.JComboBox<>();
        btnmin = new javax.swing.JLabel();
        btncancel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jaddquestion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jaddquestion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jaddquestion.setText("Type your Question Here");
        jaddquestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jaddquestionMouseClicked(evt);
            }
        });

        opt2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        opt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opt2.setText("OPTION 2");
        opt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt2MouseClicked(evt);
            }
        });

        opt1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        opt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opt1.setText("OPTION 1");
        opt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt1MouseClicked(evt);
            }
        });

        optcorrect.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        optcorrect.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        optcorrect.setText("CORRECT OPTION ");
        optcorrect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optcorrectMouseClicked(evt);
            }
        });
        optcorrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optcorrectActionPerformed(evt);
            }
        });

        opt4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        opt4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opt4.setText("OPTION 4");
        opt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt4MouseClicked(evt);
            }
        });
        opt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4ActionPerformed(evt);
            }
        });

        opt3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        opt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opt3.setText("OPTION 3");
        opt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt3MouseClicked(evt);
            }
        });
        opt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3ActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(0, 0, 255));
        btndelete.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(255, 51, 51));
        btncancel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Close");
        btncancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelMouseClicked(evt);
            }
        });
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        btnsubmit.setBackground(new java.awt.Color(0, 0, 255));
        btnsubmit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnsubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnsubmit.setText("Add");
        btnsubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsubmitMouseClicked(evt);
            }
        });
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(255, 51, 51));
        btnupdate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jtablequestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "setid", "question", "Option1", "Option2", "OPtion3", "Option4", "correct"
            }
        ));
        jtablequestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablequestionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtablequestion);

        txtid.setText("id");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)
                            .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(opt3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                            .addComponent(optcorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(120, 120, 120)
                            .addComponent(opt4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jaddquestion)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtid)
                .addGap(26, 26, 26)
                .addComponent(jaddquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optcorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opt3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categories:");

        setcatcombo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        setcatcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setcatcomboActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Set:");

        setcombo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        btnmin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnmin.setForeground(new java.awt.Color(255, 255, 255));
        btnmin.setText("  -");
        btnmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminMouseClicked(evt);
            }
        });

        btncancel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btncancel1.setForeground(new java.awt.Color(255, 255, 255));
        btncancel1.setText("  X");
        btncancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setcatcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 650, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btncancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setcatcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
          Adminpanel ad = new Adminpanel();
       ad.setVisible(true);
       this.dispose();
        
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnsubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsubmitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsubmitMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        //for updating the data in the table
        String question = jaddquestion.getText();
       String option1 = opt1.getText();
       String option2 = opt2.getText();
       String option3 = opt3.getText();
       String option4 = opt4.getText();
       String correct = optcorrect.getText();
       String id = txtid.getText();
       int q_id = Integer.parseInt(id);
       Connection con = MyConnection.getConnection();
       PreparedStatement ps;
          
         try{ 
           String query="UPDATE question SET question='"+question+"', option1='"+option1+"',option2='"+option2+"',option3='"+option3+"',option4='"+option4+"',correct='"+correct+"'WHERE question_id="+q_id+"";
         ps=con.prepareStatement(query);
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null,"Question has been Updated successfully");
         Questionsadd qad = new Questionsadd();
         qad.setVisible(true);
         this.dispose();
        
         }
             catch(Exception e){
                     JOptionPane.showMessageDialog(null, e);
                     }
          
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btncancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelMouseClicked
        Adminpanel ad = new Adminpanel();
       ad.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btncancelMouseClicked

    private void btnminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminMouseClicked

        this.setState(JFrame.ICONIFIED);// minimize
    }//GEN-LAST:event_btnminMouseClicked

    private void btncancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancel1MouseClicked
        Adminpanel ad = new Adminpanel();
       ad.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btncancel1MouseClicked

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
     if (opt1.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"Please give the option1.");
        }
     else if (opt2.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"Please give the option2.");
        }
     else if (opt3.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"Please give the option3.");
        }
     else if (opt4.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"Please give the option4.");
        }
     else if (optcorrect.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"Please give the Category name.");
        }
     else if (jaddquestion.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"Please add the question.");
        }
     else{
          //for adding the questions 
        String question = jaddquestion.getText();
       String option1 = opt1.getText();
       String option2 = opt2.getText();
       String option3 = opt3.getText();
       String option4 = opt4.getText();
       String correct = optcorrect.getText();
       Connection con = MyConnection.getConnection();
       PreparedStatement ps;
           ResultSet rs ;
       
      
       try{    
            String category= setcatcombo.getSelectedItem().toString();
            String set_name= setcombo.getSelectedItem().toString();
            PreparedStatement p = con.prepareStatement("SELECT * FROM `category` WHERE `subject`='"+category+"'");
            PreparedStatement pp = con.prepareStatement("SELECT set_id from sets where category_id =(SELECT category_id from category WHERE subject='"+category+"' AND set_name ='"+set_name+"')");
            rs = p.executeQuery();
            rs.beforeFirst();
            rs.next();
            int id = rs.getInt("category_id");
            ResultSet r = pp.executeQuery();
            r.beforeFirst();
            r.next();
            int set_id = r.getInt("set_id");
            
           ps = con.prepareStatement("INSERT INTO `question`(`option1`, `option2`, `option3`, `option4`, `correct`,`question`,`set_id`,`category_id`) VALUES (?,?,?,?,?,?,'"+set_id+"','"+id+"')");
           ps.setString(1, option1);
           ps.setString(2, option2);
           ps.setString(3, option3);
           ps.setString(4, option4);
           ps.setString(5, correct);
           ps.setString(6, question);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Question has been added successfully");
         show_question();
           
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
     }
       
    }//GEN-LAST:event_btnsubmitActionPerformed

    private void jtablequestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablequestionMouseClicked
        
        //actions when the table row is clicked
           try{
              int row = jtablequestion.getSelectedRow();
              String Table_Click=(jtablequestion.getModel().getValueAt(row, 0).toString());
              Connection con = MyConnection.getConnection();
              PreparedStatement ps;
              ResultSet rs;
              String sql="SELECT * FROM `question` WHERE `question_id`='"+Table_Click+"'";
              ps = con.prepareStatement(sql);
              rs = ps.executeQuery();
              if(rs.next()){
              
              String question = rs.getString("question");
              jaddquestion.setText(question);
              String option1 = rs.getString("option1");
              opt1.setText(option1);
              String option2 = rs.getString("option2");
               opt2.setText(option2);
              String option3 = rs.getString("option3");
               opt3.setText(option3);
              String option4 = rs.getString("option4");
               opt4.setText(option4);
              String correct = rs.getString("correct");
               optcorrect.setText(correct);
              int q_id = rs.getInt("question_id");
               txtid.setText(String.valueOf(q_id)); 
              int s_id = rs.getInt("set_id");
              txtid.setVisible(true);
               btndelete.setVisible(true);
                btnupdate.setVisible(true);
              
              
              }
              
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
    }//GEN-LAST:event_jtablequestionMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        
        //action when the delete button is clicked
         String id = txtid.getText();
       int q_id = Integer.parseInt(id);
       Connection con = MyConnection.getConnection();
       PreparedStatement ps;
       
       try{
           String query="DELETE FROM question WHERE question_id ="+q_id+"";
           ps=con.prepareStatement(query);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Question has been Deleted successfully");
         Questionsadd qad = new Questionsadd();
         qad.setVisible(true);
         this.dispose();
           
           
       }
       catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void setcatcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setcatcomboActionPerformed
        // add the set name as per the selected item
        setcombo.removeAllItems();
        
        Fillsetcombo();
    }//GEN-LAST:event_setcatcomboActionPerformed

    private void jaddquestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaddquestionMouseClicked
        jaddquestion.setText("");
    }//GEN-LAST:event_jaddquestionMouseClicked

    private void opt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt1MouseClicked
        opt1.setText("");
    }//GEN-LAST:event_opt1MouseClicked

    private void opt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt2MouseClicked
        opt2.setText("");
    }//GEN-LAST:event_opt2MouseClicked

    private void opt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3ActionPerformed
       
    }//GEN-LAST:event_opt3ActionPerformed

    private void optcorrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optcorrectActionPerformed
        
    }//GEN-LAST:event_optcorrectActionPerformed

    private void opt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4ActionPerformed
       
    }//GEN-LAST:event_opt4ActionPerformed

    private void opt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt3MouseClicked
         opt3.setText("");
    }//GEN-LAST:event_opt3MouseClicked

    private void optcorrectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optcorrectMouseClicked
        optcorrect.setText("");
    }//GEN-LAST:event_optcorrectMouseClicked

    private void opt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt4MouseClicked
         opt4.setText("");
    }//GEN-LAST:event_opt4MouseClicked

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Questionsadd().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JLabel btncancel1;
    private javax.swing.JButton btndelete;
    private javax.swing.JLabel btnmin;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jaddquestion;
    private javax.swing.JTable jtablequestion;
    private javax.swing.JTextField opt1;
    private javax.swing.JTextField opt2;
    private javax.swing.JTextField opt3;
    private javax.swing.JTextField opt4;
    private javax.swing.JTextField optcorrect;
    private javax.swing.JComboBox<String> setcatcombo;
    private javax.swing.JComboBox<String> setcombo;
    private javax.swing.JLabel txtid;
    // End of variables declaration//GEN-END:variables
}
