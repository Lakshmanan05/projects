package Train1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count=0;

        ArrayList<Train> Trains= new ArrayList();
        ArrayList<passenger> Booking=new ArrayList();
        Trains.add(new Train(1,2,"Chennai to Bangalore              Rupees:160"));
        Trains.add(new Train(2,4,"Tiruchirappalli to Chennai      Rupees:90"));
        Trains.add(new Train(3,5,"Salem to Mumbai                   Rupees:125"));
        for(Train t:Trains){
            t.Display();
        }
        int userid=1;
        int ticket;

        while(userid==1){
            System.out.println("Enter 1 for booking or 2 for Exit");
            Scanner s=new Scanner(System.in);
            int a=s.nextInt();
            if(a==1){
                  passenger booking=new passenger();
                System.out.print("press [1] for Reservation press [2] for Unreservation");
                ticket=s.nextInt();
                if(ticket==1){
                    if(booking.avalability(Booking,Trains)){
                        Booking.add(booking);
                        System.out.println("your booking is confirmed");
                    }
                    else{
                        count++;
                        System.out.println("Waiting list"+count);
                    }
                }
                else {
                    System.out.print("Your booking is confirmed Unreservation");
                }
            }
            else{
                System.out.print("thank you!");
                userid=2;
            }
        }
    }
}