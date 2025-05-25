package LabPrac._1PayrollManagement;

public class FTEmployee extends Employee implements payable{
    public FTEmployee(String name , String designation , double monthlySalary, int age){
        super(name, designation, monthlySalary, age);
    }
    @Override
    public double calculate(){
        return this.salary;
    }
    @Override
    public String toString(){
        return "Full Time employee\n" + super.toString() + "Monthly Sal: " + calculate();
    }
}
