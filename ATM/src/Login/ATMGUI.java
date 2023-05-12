package Login;

import java.util.Scanner;
import java.sql.*;

public class ATMGUI {
    String res;
    int b=1;
    private int id;
    private String name;
    private String password;
    private int Amount;
    ATMGUI(int a,String b,String c,int d){
       System.out.println("Press[1] Deposit");
       System.out.println("Press[2] Widthdraw");
       System.out.println("Press[3] Change PIN");
       System.out.println("Press[4] Balance Enquiry");
       System.out.println("--------------------------------------------------");  
       this.id=a;
       this.name=b;
       this.password=c;
       this.Amount=d;
}
public int getAmount(){
  return Amount;
}
public void setamount(int r){
      this.Amount=r;
}
public int getid(){
  return id;
}
public void setid(int r){
      this.id=r;
}
public String getname(){
  return name;
}
public void setname(String r){
      this.name=r;
}
public String getpassword(){
  return password;
}
public void setpassword(String r){
      this.password=r;
}
Scanner s=new Scanner(System.in);
  public void Check()throws Exception{
    while(b==1){
      System.out.println("Click the option : ");
      int a=Integer.parseInt(s.nextLine());
         if(a==1){
          System.out.println("you want to Deposit");
          int rec=getAmount();
          int id=getid();
          checkdeposit(rec,id);
          System.out.println("Deposit Successfully:");
          System.out.println("your balance :"+getAmount());
          break;
         }
         else if(a==2){
          System.out.println("you want to Widthdraw");
          int rec=getAmount();
          int id=getid();
          checkwithdraw(rec,id);
          System.out.println("Widthdraw Successfully:");
          System.out.println("your balance :"+getAmount());
          break;
         }
         else if(a==3){
          System.out.println("Enter last password");
          String b=s.nextLine();
          System.out.println("Enter new password");
          String c=s.nextLine();
          checkpass(b, c);
          break;
          }
         else if(a==4){
          System.out.println("you want to Balance Enquiry");
          System.out.println("your balance :"+getAmount());
          break;
          }
         else{
          System.out.println("invalid ");
         }
    }   
  }
  public void checkpass(String a,String b)throws Exception{
    if(a.equals(getpassword())){
      String query="update login set password =(?) where password =(?)";
      Connection cn = database.getConnection();
      PreparedStatement ps=cn.prepareStatement(query);
      ps.setString(1, b);
      ps.setString(2, a);
      ps.executeUpdate();
      cn.close();
      System.out.println("Successfully updated");
    }
  }
  public void checkdeposit(int Amt,int id) throws Exception{
    int sum=0;
    boolean flag=true;
    while(flag){
      System.out.println("Enter 1 for Rs:2000");
      System.out.println("Enter 2 for Rs:500");
      System.out.println("Enter 3 for Rs:200");
      System.out.println("Enter 4 for Rs:100");
      System.out.println("Enter 5 for Total Amount to deposit");
      int a=s.nextInt();
      if(a==1){
        System.out.println("2000 X :");
        int c=s.nextInt();
        sum=sum+(2000*c);
      }
      else if(a==2){
        System.out.println("500 X :");
        int c=s.nextInt();
        sum=sum+(500*c);
      }
      else if(a==3){
        System.out.println("200 X :");
        int c=s.nextInt();
        sum=sum+(200*c);
      }
      else if(a==4){
        System.out.println("100 X :");
        int c=s.nextInt();
        sum=sum+(100*c);
      }
      else if(a==5){
        System.out.println("total to deposit :" + sum);
        break;
      }
      else{
        System.out.println("invalid Rupees");
        flag=false;
      }
    }
    int recAmt=sum+Amt;
    setamount(recAmt);
    String query="update login set balance =(?) where id =(?)";
      Connection cn = database.getConnection();
      PreparedStatement ps=cn.prepareStatement(query);
      ps.setInt(1, recAmt);
      ps.setInt(2, id);
      ps.executeUpdate();
      cn.close();
  }

  public void checkwithdraw(int Amt,int id)throws Exception{
         System.out.println("Enter the rupees:");
         int a=s.nextInt();
         int AvailableRs=Amt-a;
         setamount(AvailableRs);
         if(AvailableRs<500){
          System.out.println("you don't have minimum balance");
          System.out.println("Enter 1 to withdraw 2 to cancel");
          int e=s.nextInt();
          if(e==1){
            String query="update login set balance =(?) where id =(?)";
            Connection cn = database.getConnection();
            PreparedStatement ps=cn.prepareStatement(query);
            ps.setInt(1, AvailableRs);
            ps.setInt(2, id);
            ps.executeUpdate();
            cn.close();
          }
          else{
            System.out.println("cancel the withdraw");
          }
         }
         else{
          String query="update login set balance =(?) where id =(?)";
          Connection cn = database.getConnection();
          PreparedStatement ps=cn.prepareStatement(query);
          ps.setInt(1, AvailableRs);
          ps.setInt(2, id);
          ps.executeUpdate();
          cn.close();
         }
  }
}  
