package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionManagement {

    public Connection generateConnection() throws ClassNotFoundException, SQLException {
//        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/data";
        String userName="root";
        String password="root";
//        Class.forName(driver);
        return DriverManager.getConnection(url,userName,password);
    }

    public void applyAction(int option,Connection connection) throws SQLException {
        switch (option){
            case 1:
                new Queries().findAll(connection);
                break;
            case 2: {
                Scanner sc=new Scanner(System.in);
                while(true){
                    System.out.println("Enter the id for employee details");
                    try{
                        int id=Integer.parseInt(sc.nextLine());
                        new Queries().findById(id,connection);
                        break;
                    }catch(Exception e){
                       System.out.println("Invalid Id");
                    }
                }
                sc.close();
            };
            break;
        }
    }
}
