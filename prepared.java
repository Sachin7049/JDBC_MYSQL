package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class prepared {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Sachin@123";
        String query = "INSERT INTO employes (id,name,job_title,salary) VALUES (?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loader successfully ");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            PreparedStatement pre=conn.prepareStatement(query);
            pre.setString(1,"3");
            pre.setString(2,"rahul");
            pre.setString(3,"java developer");
            pre.setString(4,"200000.00");
            int result = pre.executeUpdate();

            if(result>0){
                System.out.println("Insert successfully " + result);

            }
            else {
                System.out.println("Insert failed ");
            }
            pre.close();
            conn.close();



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
