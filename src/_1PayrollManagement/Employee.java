package LabPrac._1PayrollManagement;

public class Employee {
    String name,designation;
    double salary;
    int age;

    Employee(String name, String designation , double salary, int age){
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.age = age;
    }
    public double calculate(){
        salary = 0;
        return salary;
    }
    public String toString(){
        return name + "\t" + designation + "\n" + salary + "\t" + age;
    }
}
