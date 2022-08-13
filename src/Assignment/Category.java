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
class Category {
    private int category_id;
    private String subject;
    
    public Category(int category_id, String subject){
        this.category_id = category_id;
        this.subject = subject;
    }
    public int getcategory_id(){
        return category_id;
    }
    public String getsubject(){
        return subject;
    }
    

}
