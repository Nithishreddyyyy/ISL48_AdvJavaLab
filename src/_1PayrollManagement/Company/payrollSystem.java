package LabPrac._1PayrollManagement.Company;
import LabPrac._1PayrollManagement.*;
public class payrollSystem {
    public static void main(String[] args) {
        Employee [] emp = new Employee[3];

        emp[0] = new FTEmployee("nithish","SDE",10000,25);
        emp[1] = new PTEmployee("rahul","Graphics", 20 , 10, 500.0);
        emp[2] = new intern("pratej","marketing intern",100,19);

        for (Employee E : emp){
            System.out.println(E.toString());
        }
    }
}
