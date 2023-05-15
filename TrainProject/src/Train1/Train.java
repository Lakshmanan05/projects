package Train1;

public class Train {
    private int tno;
    private int cap;

    Train(int train_no, int capacity){
        this.tno=train_no;
        this.cap=capacity;
    }
    public int getcap(){
        return cap;
    }
    public void setcap(int capacity){
        cap=capacity;
    }
    public int gettno(){
        return tno;
    }
    public  void Display(){
      System.out.println("Train no : "+tno+ " Train capacity : "+cap);
    }
}
