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
       
       String folder ="C:\\Users\\Sachine Rathore\\Pictures\\image\\";
       String query ="Select * from image where image_id=?";
       

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

          
            conn.close();


        }catch (Exception e ){
            System.out.println(e);

        }

    }
}
