package org.example.main.main;


import org.example.main.model.Employee;
import org.example.main.repository.EmployeeRepository;
import org.example.main.repository.Repository;
import org.example.main.util.DataBaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("LISTANDO TODOS");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);

        System.out.println("---BUSCANDO POR ID---");
        System.out.println(repository.getById(4));

    }
}