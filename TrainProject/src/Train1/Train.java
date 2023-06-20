package Train1;

public class Train {
    private int tno;
    private int cap;
    String ride;

    Train(int train_no, int capacity,String a){
        this.tno=train_no;
        this.cap=capacity;
        this.ride=a;
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
      System.out.println("Train no : "+tno+ " Train capacity : "+cap +"  Ride on:  "+ride);
    }
}
