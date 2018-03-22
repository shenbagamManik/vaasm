
import java.sql.*;
import java.io.*;
 
public class DatabaseImageExample {
    
    	public static void main(String args[]){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","mani123");
                
                File file=new File("C:\\shen\\IMAGES\\Electronics.jpg");
                FileInputStream fis=new FileInputStream(file);
                
                PreparedStatement ps=con.prepareStatement("insert into products  (CODE,image,NAME,PRICE,CREATE_DATE) values(?,?,?,?,?)"); 
                ps.setString(1,"S004");
                ps.setBinaryStream(2,fis,(int)file.length());
                ps.setString(3,"Electronics");
                ps.setDouble(4,65);
                ps.setTimestamp(5,TimeStamp());
                ps.executeUpdate();
     
                ps.close();
                fis.close();
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

		private static Timestamp TimeStamp() {
			// TODO Auto-generated method stub
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			return timestamp;
		}
}
	