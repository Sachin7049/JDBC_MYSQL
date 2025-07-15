package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class update {
    public static void main(String[] args) throws  ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Sachin@123";
        String query = "update employes Set job_title='software Enginer',salary='90000' where id=2";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection loader Successfully ");
        } catch (Exception E) {
            System.out.println(E);
        }
        try {
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement strm=conn.createStatement();
            int result =strm.executeUpdate(query);
            if(result>0){
                System.out.println("Upadtion successfully " + result);
            }
            else {
                System.out.println("Query failed" );
            }

        }catch (Exception E ){
            System.out.println(E);
        }

    }
}
