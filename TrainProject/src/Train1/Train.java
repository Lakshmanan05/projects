package Train1;

public class Train {
    private int tno;
    private boolean Ac;
    private int cap;

    Train(int train_no,boolean AC, int capacity){
        this.tno=train_no;
        this.Ac = AC;
        this.cap=capacity;
    }
    public int getcap(){
        return cap;
    }
    public void setcap(int capacity){
        cap=capacity;
    }
    public boolean getAc(){
        return Ac;
    }
    public void setAc(boolean AC){
        Ac=AC;
    }
    public int gettno(){
        return tno;
    }
    public  void Display(){
      System.out.println("Train no : "+tno+" Ac or Non-Ac : " +Ac+ " Train capacity : "+cap);
    }
}
