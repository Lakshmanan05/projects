package Train1;

import java.util.ArrayList;
import java.util.Scanner;
public class passenger {
    Scanner s=new Scanner(System.in);
    int Trainno;
    String name;
    int age;

    int ticket;
    passenger() {
        System.out.println("Enter Train no");
        Trainno=s.nextInt();
        System.out.println("Enter your name:");
        name=s.next();
        System.out.println("Enter your Age: ");
        age=s.nextInt();
    }
    public boolean avalability(ArrayList<passenger> Booking ,ArrayList<Train> Trains) {
        int capacity=0;
        int a=0;
        for(Train t:Trains){
           if(t.gettno()== Trainno){
               capacity=t.getcap();
           }
        }
        for(passenger p:Booking){
            if(p.Trainno==Trainno){
                a++;
            }
        }
        return a < capacity ?true:false;
    }
}

