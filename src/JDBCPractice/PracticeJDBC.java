package JDBCPractice;

import java.sql.*;
import java.util.Scanner;

public class PracticeJDBC {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner =new Scanner(System.in);
        Connection connection= new ConnectionManagement().generateConnection();
        System.out.println("Connection Established");
        while (true){
            System.out.println("Choose an Option");
            new ProvideOptions().options().forEach((key,value)->System.out.println(key+": "+value));
            try{
                int option=Integer.parseInt(scanner.nextLine());
                if(option==6){
                    break;
                }else if(option>=1 && option<=6){
                    new ConnectionManagement().applyAction(option,connection);
                }else{
                    System.out.println("No option Available");
                }
            }catch (Exception e){
                System.out.println("Invalid Input");
            }

        }
        scanner.close();
        connection.close();
    }



}
