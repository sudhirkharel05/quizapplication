/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author SUDHIR
 */
class Student {
    private int student_id, Batch;
    private String student_name, student_username, student_password,section;
 
    
    public Student(int student_id, int Batch, String student_name,String student_username, String student_password, String section){
        this.student_id = student_id;
        this.Batch = Batch;
        this.student_username = student_username;
        this.student_password = student_password;
        this.student_name = student_name;
        this.section = section;
    }
    public int getstudent_id(){
        return student_id;
    }
    public int getBatch(){
        return Batch;
    }
    public String getstudent_name(){
        return student_name;
    }
     public String getstudent_username(){
        return student_username;
    }
     public String getstudent_password(){
        return student_password;
    }
      public String getsection(){
        return section;
    }
    
  
}
