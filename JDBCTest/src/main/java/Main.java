import java.sql.*;
public class Main {

    public static void main(String[] agrs) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","testuser", "password");
            //myConn.
            System.out.println("Database connection successful! \n");

        }
        catch (Exception e){
            System.out.println("database fail connection");

        }
    }

}