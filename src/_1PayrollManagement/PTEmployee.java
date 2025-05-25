package LabPrac._1PayrollManagement;

public class PTEmployee extends Employee implements payable{
    int hoursWorked;
    double hourlyRate;
    public PTEmployee(String name , String designation , int age,int hoursWorked, double hourlyRate){
        super(name,designation,0,age);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculate(){
        return this.hoursWorked * this.hourlyRate;
    }
    @Override
    public String toString(){
        return "PTEmployee- "+super.toString() + "PTE Sal: " + calculate();
    }
}
