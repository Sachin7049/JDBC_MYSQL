package jdbc;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete {
    public static void main(String[] args)  throws ClassNotFoundException{
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username="root";
        String password="Sachin@123";
        String query ="DELETE FROM employes where id= 3 ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection loader successfully ");

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement strm = conn.createStatement();
            int result =strm.executeUpdate(query);

            if (result>0){
                System.out.println("delection successfully "+ result);
            }
            else {
                System.out.println("Query falied");
            }
        }catch (Exception e){
            System.out.println(e);
        }




    }
}
