package jdbc;

import java.sql.*;

public class INSERT {
    public static void main(String[] args) throws ClassNotFoundException {
      String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
      String username="root";
      String password="Sachin@123";
      String query="INSERT into employes (id,name,job_title,salary) VALUES (3,'rahul','Backend developer','10000.00')";

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          System.out.println("DRIVER LOADER SUCCESSFULLY");
      }catch (ClassNotFoundException e){
          System.out.println(e);

      }
      try {
          Connection conn= DriverManager.getConnection(url,username,password);
          System.out.println("connection successfully established ");
          Statement strm =conn.createStatement();
          int  result=strm.executeUpdate(query);

          if(result>0){
              System.out.println("insert successfully into the database "+ result);
              System.out.println("QUERY SUCESSFULLY INSERT");

          }
          else {
              System.out.println("Failed my database query ");
          }
          strm.close();
          conn.close();

      }catch (Exception e){

      }

    }
}
