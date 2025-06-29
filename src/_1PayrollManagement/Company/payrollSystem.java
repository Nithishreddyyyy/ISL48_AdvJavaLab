package _1PayrollManagement.Company;
import _1PayrollManagement.*;

import java.util.ArrayList;

public class payrollSystem {
    public static void main(String[] args) {

        ArrayList<Employee> emps = new ArrayList<>();
        emps.add( new FTEmployee("nithish","SDE",10000,25));
        emps.add( new PTEmployee("rahul","Graphics", 20 , 10, 500.0));
        emps.add(new intern("pratej","marketing intern",100,19));
        for (Employee E : emps){
            System.out.println(E.toString());
        }
    }
}
