
package Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class Test extends javax.swing.JFrame {
  
    
    // this the the class where the game is played and the scores are provided
    
    Connection con = MyConnection.getConnection();
    public final int studentid;
    public final int setid;
    public int question_no;
    public String Question;
    
    
 
   
    
    public Test(int studentid, int setid){
        initComponents();
        this.studentid = studentid;
        this.setid = setid;
        questionslist(); 
        answerfill();
        showData();
        
    }
    ArrayList<TestQuestion>qlist = new ArrayList<>();
    private void showData(){
        //for showing the data in the area selected
    questionslbl.setText(qlist.get(counter).getquestion());
    option1.setText(qlist.get(counter).getoption1());
    option2.setText(qlist.get(counter).getoption2());
    option3.setText(qlist.get(counter).getoption3());
    option4.setText(qlist.get(counter).getoption4());
}
    private void questionslist(){
        //selecting the questions of the perticular set id
       try{ 
     String query = "SELECT * FROM question WHERE set_id = "+setid+" LIMIT 5";   
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(query);
        TestQuestion question;
        while(rs.next()){
            question = new TestQuestion(rs.getInt("set_id"),rs.getString("question"), rs.getString("option1"),rs.getString("option2"),rs.getString("option3"),rs.getString("option4"),rs.getString("correct"));
            qlist.add(question);
        }
    }
    catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
    }
    
}
    ArrayList answer = new ArrayList();
private void answerfill(){
    
    for (int i=0; i<qlist.size(); i++){
        answer.add("");
    }
}

public void answerslist(String value){
    answer.set(counter, value);
}

//calculating the marks of the student
int ans_correct=0;
int marks;
public void calculate(){
    int list = qlist.size();
    for(int i=0; i<answer.size(); i++){
        String ans1 = qlist.get(i).getcorrect().replace(" ", "");
        String ans2 = answer.get(i).toString().replace(" ", "");
        if(ans1.equals(ans2)){
            ans_correct++;
        }
    }
    marks = (ans_correct*100)/list;
}
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        subject = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        questionslbl = new javax.swing.JLabel();
        option2 = new javax.swing.JRadioButton();
        option1 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        btnpre = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        questionno = new javax.swing.JLabel();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        subject.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subject.setForeground(new java.awt.Color(255, 255, 255));
        subject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        questionslbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        questionslbl.setForeground(new java.awt.Color(102, 0, 102));
        questionslbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionslbl.setText("question");

        option2.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(option2);
        option2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        option2.setText("3");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        option1.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(option1);
        option1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        option1.setText("1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        option3.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(option3);
        option3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        option3.setText("2");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });

        option4.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(option4);
        option4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        option4.setText("4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });

        btnpre.setText("<<PRE");
        btnpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreActionPerformed(evt);
            }
        });

        btnnext.setText("NEXT >>");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        questionno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        questionno.setForeground(new java.awt.Color(102, 0, 102));
        questionno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionno.setText("q");

        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(option3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(option4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(option2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnpre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(165, 165, 165))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(option1)
                    .addContainerGap(781, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(option2)
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option4)
                    .addComponent(option3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(option1)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int counter =0;
    private void btnpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreActionPerformed
        // for enabling the previous questions
        counter--;
        questionno.setText(Integer.toString(counter+1));
        selectRdo();
        btnnext.setEnabled(true);
        if(counter != 0){
            btnpre.setEnabled(true);
        }
        else{
            btnpre.setEnabled(false);
        }
        showData();
        
    }//GEN-LAST:event_btnpreActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
           // bringiing the next question list after the next btton is clicked
        counter++;
        questionno.setText(Integer.toString(counter+1));
         option1.setSelected(false);
       option2.setSelected(false);
       option3.setSelected(false);
       option4.setSelected(false);
        selectRdo();
        btnpre.setEnabled(true);
        if(counter < (qlist.size()-1))
        {
            btnnext.setEnabled(true);
            
        }
        else{
            btnnext.setEnabled(false);
        }
        showData();
    }//GEN-LAST:event_btnnextActionPerformed
    public void selectRdo(){
        // selecting the radio button
       if((qlist.get(counter).getoption1())==answer.get(counter)){
       option1.setSelected(true);
       option2.setSelected(false);
       option3.setSelected(false);
       option4.setSelected(false);
      
       }
       else if((qlist.get(counter).getoption2())==answer.get(counter)){
       option1.setSelected(false);
       option2.setSelected(true);
       option3.setSelected(false);
       option4.setSelected(false);
       }
       else if((qlist.get(counter).getoption3())==answer.get(counter)){
       option1.setSelected(false);
       option2.setSelected(false);
       option3.setSelected(true);
       option4.setSelected(false);
       }
       else if((qlist.get(counter).getoption4())==answer.get(counter)){
       option1.setSelected(false);
       option2.setSelected(false);
       option3.setSelected(false);
       option4.setSelected(true);
       }
       else{
       option1.setSelected(false);
       option2.setSelected(false);
       option3.setSelected(false);
       option4.setSelected(false);
       }
       
          
    }
    private void insert(){
        //inserting the marks of the student
        try{
            String query="INSERT INTO set_students(set_id, student_id, marks) VALUES("+setid+","+studentid+","+marks+")";
            PreparedStatement ps=con.prepareStatement(query);
         ps.executeUpdate();
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       // this displays the marks of the studnet in the pop up windows
        calculate();
       JOptionPane.showMessageDialog(null, "You have Scored "+marks);
       insert();
       try{
           TakeTest tkt = new TakeTest(studentid); // takes into the student dashboard page
           tkt.setVisible(true);
           this.dispose();
       }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_submitActionPerformed
//selecting and getting the value of radio button
    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        String ans = option1.getText();
         option2.setSelected(false);
       option3.setSelected(false);
       option4.setSelected(false);
       answerslist(ans);
    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        String ans = option2.getText();
         option1.setSelected(false);
       option3.setSelected(false);
       option4.setSelected(false);
       answerslist(ans);
    }//GEN-LAST:event_option2ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
         String ans = option3.getText();
         option2.setSelected(false);
       option1.setSelected(false);
       option4.setSelected(false);
       answerslist(ans);
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        
         String ans = option4.getText();
         option2.setSelected(false);
       option1.setSelected(false);
       option3.setSelected(false);
       answerslist(ans);
    }//GEN-LAST:event_option4ActionPerformed

    
    public static void main(String args[]) {
                int setid=0;
                int studentid=0;
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try{
                new Test(studentid, setid).setVisible(true);
                }
                catch(Exception e){
                     JOptionPane.showMessageDialog(null, e);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnpre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JLabel questionno;
    private javax.swing.JLabel questionslbl;
    private javax.swing.JLabel subject;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
