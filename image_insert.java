package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.classfile.instruction.StackInstruction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class image_insert {
    public static void main(String[] args) throws  ClassNotFoundException {
       String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
       String username="root";
       String password="Sachin@123";
       String folder ="C:\\Users\\Sachine Rathore\\Pictures\\image\\";
       String query ="Select * from image where image_id=?";
       //String image_path="C:\\Users\\Sachine Rathore\\Pictures\\image\\image.png";
        //String query="INSERT INTO image (image_data) Values(?)";

       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       }catch (Exception E){
           System.out.println(E);
       }
        try{
            Connection conn= DriverManager.getConnection(url,username,password);
//            FileInputStream fileInputStream=new FileInputStream(image_path);
//            byte[] image_paths=new byte[fileInputStream.available()];
            PreparedStatement pre=conn.prepareStatement(query);
            pre.setInt(1,1);
            ResultSet result =pre.executeQuery();

            if(result.next()){

                byte[] image_data= result.getBytes("image_data");
                String image_path=folder+"exceuteimage.jpg";
                OutputStream outputStream=new FileOutputStream(image_path);
                outputStream.write(image_data);

            }
            else {
                System.out.println("Image not found");
            }

          //  pre.setString(1,"image_data");
            //int result =pre.executeUpdate();
//            if(result>0){
//                System.out.println("Insert successfully query ");
//            }else {
//                System.out.println("Not insert unsuccessfully");
//            }
            conn.close();


        }catch (Exception e ){
            System.out.println(e);

        }

    }
}
