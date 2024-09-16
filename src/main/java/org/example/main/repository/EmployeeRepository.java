package org.example.main.repository;

import org.example.main.model.Employee;
import org.example.main.util.DataBaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getConnection();
    }



    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try(Connection myCon = getConnection();
                Statement myStam = myCon.createStatement();
            ResultSet myRes = myStam.executeQuery("SELECT * FROM Employees")){
            while (myRes.next()) {
                Employee e = createEmployee(myRes);
                employees.add(e);
            }
        }
        return employees;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(Connection myCon = getConnection();
                PreparedStatement myStam = myCon.prepareStatement("SELECT * FROM Employees WHERE id = ? ")){
            myStam.setInt(1, id);
            try(ResultSet myRes = myStam.executeQuery()){
                if(myRes.next()){
                    employee = createEmployee(myRes);
                }
            }
        }
        return employee;
    }

    public void update(Employee employee) throws SQLException {

        String sql = "UPDATE Employees set nombre ? "+"WHERE id = ?";

        try(Connection myCon = getConnection();
                PreparedStatement myStam = myCon.prepareStatement(sql)){
            myStam.setString(1,employee.getName());
            myStam.setInt(2,employee.getId());
            myStam.executeUpdate();
        }
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql;
        if(employee.getId() != null && employee.getId() > 0){
            sql = "UPDATE Employees SET nombre = ? , email = ?, edad = ?, curp = ? WHERE id = ?";
        }else {
            sql = "INSERT INTO Employees (nombre, email, edad, curp) VALUES (?, ?, ?, ?)";
        }
        try(Connection myCon = getConnection();
                PreparedStatement myStam = myCon.prepareStatement(sql)){
            myStam.setString(1,employee.getName());
            myStam.setString(2,employee.getEmail());
            myStam.setInt(3,employee.getEdad());
            myStam.setString(4, employee.getCurp());
            if(employee.getId() != null && employee.getId() > 0){
                myStam.setInt(5,employee.getId());
            }
            myStam.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(Connection myCon = getConnection();
                PreparedStatement myStam = myCon.prepareStatement("DELETE FROM Employees WHERE id=?")){
        myStam.setInt(1,id);
        myStam.executeUpdate();
        }

    }
    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setName(myRes.getString("nombre"));
        e.setEmail(myRes.getString("email"));
        e.setEdad(myRes.getInt("edad"));
        e.setCurp(myRes.getString("curp"));
        return e;
    }

}
