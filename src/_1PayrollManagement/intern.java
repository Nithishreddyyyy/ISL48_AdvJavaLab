package LabPrac._1PayrollManagement;

public class intern extends Employee implements payable{
    public intern(String name , String designation , double Stipend, int age){
        super(name,designation,Stipend,age);
    }

    @Override
    public double calculate(){
        return this.salary;
    }
    @Override
    public String toString(){
        return "Intern- " + super.toString() + "Stipend: " + calculate();
    }
}
