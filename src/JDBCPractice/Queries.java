package JDBCPractice;

import java.sql.*;

public class Queries {

    private String findAllQuery(){
        return "SELECT * FROM data.employeedetails";
    }

    public void findAll(Connection connection) throws SQLException {
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(findAllQuery());

            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("employee_id"));
                System.out.println("Name: " + resultSet.getString("employee_name"));
            }
    }

    private String insertDataQuery(){
        return "Insert into data.employeedetails (employee_id,employee_address,employee_email,employee_name,employee_phone) values (?, ?, ?, ?, ?)";
    }

    public void insertData(Connection connection) throws SQLException {
        PreparedStatement preparedStatement= connection.prepareStatement(insertDataQuery());
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"Guntur");
        preparedStatement.setString(3,"srimanth@gmail.com");
        preparedStatement.setString(4,"ram");
        preparedStatement.setString(5,"9390299551");
        preparedStatement.executeUpdate();
    }

    public String findByIdQuery(){
        return "SELECT * FROM data.employeedetails where employee_id= ";
    }

    public void findById(int id, Connection connection) throws SQLException {
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(findByIdQuery()+id);
        if(resultSet.getFetchSize()==0){
            System.out.println("No employee with "+id);
        }else{
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("employee_id"));
                System.out.println("Name: " + resultSet.getString("employee_name"));
            }
        }
    }

}
