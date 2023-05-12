package Login;
import java.util.Scanner;
import java.sql.*;

public class Loginpage {
    int id;
    String name1;
    String pass;
    int Amount;
    public void Display(int a,String name,String password) throws Exception{
        String query="select * from login";
        Connection cnt= database.getConnection();
        Statement sn= cnt.createStatement();
        ResultSet rs= sn.executeQuery(query); 
        boolean flag=rs.next();
        while(flag){
              id=rs.getInt(1);
              name1=rs.getString(2);
              pass = rs.getString(3);
              Amount=rs.getInt(4);
             if(a==id && name.equals(name1) && password.equals(pass)){
                System.out.println("Successfully log in ");
                ATMGUI A=new ATMGUI(id,name1,pass,Amount);
                A.Check();
                break;
             } 
             flag=rs.next();
             if(flag == false)
             System.out.println("invalid username or password");
        } 
     
    }
    public void check() throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your ID :");
        int a=sc.nextInt();
        System.out.println("Enter Your name:");
        String name=sc.next();
        System.out.println("Your password :");
        String password=sc.next();
        Display(a,name,password);
        sc.close();
    }
    
}
