package Train1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Train> Trains= new ArrayList();
        ArrayList<passenger> Booking=new ArrayList();
        Trains.add(new Train(1,true,2));
        Trains.add(new Train(2,false,4));
        Trains.add(new Train(3,true,5));
        for(Train t:Trains){
            t.Display();
        }
        int userid=1;

        while(userid==1){
            System.out.println("Enter 1 for booking or 2 for Exit");
            Scanner s=new Scanner(System.in);
            int a=s.nextInt();
            if(a==1){
                  passenger booking=new passenger();
                  if(booking.avalability(Booking,Trains)){
                      Booking.add(booking);
                      System.out.println("your booking is confirmed");
              }
              else{
                  System.out.println("Waiting list");
              }
            }
            else{
                System.out.print("thank for visiting the Train booking System");
                userid=2;
            }
        }
    }
}