/* JDBC Test with proper input handling*/
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] agrs) throws SQLException {
        Connection myConn = null;
        Statement myStmt;
        ResultSet myRs;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "testuser", "password");
            //myConn.
            System.out.println("Database connection successful! \n");
        } catch (Exception e) {
            System.out.println("database fail connection");
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Options: \n1: Print Database\n2: Insert Entries\n3: Delete Entries");
        System.out.println("Enter a choice: ");
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        //once finished
        myStmt = myConn.createStatement();
        switch (n) {
            case 1:
                myRs = myStmt.executeQuery("SELECT * FROM customers");
                while (myRs.next()) {
                    System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
                    // read data from each row
                }
                break;
            case 2:
                System.out.println("Enter first name: ");
                String first_name = reader.next(); // Scans the next token of the input as an int.
                System.out.println("Enter last name: ");
                String last_name = reader.next(); // Scans the next token of the input as an int.
                //once finished
                String build = "insert into customers " + "(first_name, last_name) " + "values " + "('" +first_name+"', " + "'" + last_name + "')";
                myStmt.executeUpdate(build);
                break;
            case 3:
                System.out.println("Enter first name: ");
                first_name = reader.next(); // Scans the next token of the input as an int.
                System.out.println("Enter last name: ");
                last_name = reader.next(); // Scans the next token of the input as an int.
                //once finished
                build = "delete from customers " + "where first_name='" + first_name + "' and " + "last_name='" + last_name + "'";
                myStmt.executeUpdate(build);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        //reader.close();

    }
}
