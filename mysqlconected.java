package jdbc;
import java.sql.*;

public class mysqlconected {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username="root";
        String password="Sachin@123";
        String query="Select * from employes";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getException());
        }
        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection successfully ");
            Statement strm= con.createStatement();
            ResultSet rs= strm.executeQuery(query);
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double Salary =rs.getDouble("salary");

                System.out.println();
                System.out.println("=====================================");
                System.out.println("ID: "+id);
                System.out.println("=====================================");
                System.out.println("NAME : "+ name);
                System.out.println("=====================================");
                System.out.println("job_title : "+job_title);
                System.out.println("salary : "+ Salary);

            }
        }catch (Exception e){
            System.out.println(e);
        }



    }

}
