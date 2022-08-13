
package Assignment;


class Question {
     private int question_id;
    private String question,option1, option2, option3, option4, correct;
    
    public Question(int question_id, String question, String option1,String option2,String option3,String option4,String correct ){
        this.question = question;
        this.question_id = question_id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct = correct;
    }
    public int getquestion_id(){
        return question_id;
    }
    public String getquestion(){
        return question;
    }
    public String getoption1(){
        return option1;
    }
     public String getoption2(){
        return option2;
    }
      public String getoption3(){
        return option3;
    }
     public String getoption4(){
        return option4;
    }
     public String getcorrect(){
        return correct;
    }
}
