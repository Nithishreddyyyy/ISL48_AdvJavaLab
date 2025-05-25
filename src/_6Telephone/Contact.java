package LabPrac._6Telephone;
import java.time.*;

public class Contact {
    String name;
    long number;
    public Contact(String name, long number){
        this.name = name;
        this.number = number;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
