package org.example.main.model;

public class Employee {
    private Integer id;
    private String name;
    private String email;
    private int edad;
    private String curp;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Employee() {
    }

    public Employee(Integer id, String name, String email, int edad, String curp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.edad = edad;
        this.curp = curp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", curp='" + curp + '\'' +
                '}';
    }
}
