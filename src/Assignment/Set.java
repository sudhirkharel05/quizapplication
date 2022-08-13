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
class Set {
    private int set_id, category_id;
    private String name;
    
    public Set(int set_id, int category_id, String name){
        this.category_id = category_id;
        this.set_id = set_id;
        this.name = name;
    }
    public int getset_id(){
        return set_id;
    }
    public int getcategory_id(){
        return category_id;
    }
    public String getname(){
        return name;
    }
}
