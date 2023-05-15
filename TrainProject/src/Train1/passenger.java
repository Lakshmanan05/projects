package Train1;

import java.util.ArrayList;
import java.util.Scanner;
public class passenger {
    Scanner s=new Scanner(System.in);
    int busno;
    String name;
    int age;
    long phoneno;
    String emailid;
    passenger() {
        System.out.println("Enter Train no");
        busno=s.nextInt();
        System.out.println("Enter your name");
        name=s.next();
        System.out.println("Enter your Age: ");
        age=s.nextInt();
        System.out.println("Enter your Mobile no: ");
        phoneno=s.nextLong();
        System.out.println("Enter your mail id");
        emailid=s.next();
    }
    public boolean avalability(ArrayList<passenger> Booking ,ArrayList<Train> Trains) {
        int capacity=0;
        int a=0;
        for(Train t:Trains){
           if(t.gettno()== busno){
               capacity=t.getcap();
           }
        }
        for(passenger p:Booking){
            if(p.busno==busno){
                a++;
            }
        }
        return a < capacity ?true:false;
    }
}

