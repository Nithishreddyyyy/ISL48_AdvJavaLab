package LabPrac._6Telephone;
import java.lang.*;
import java.time.*;

public class MissedCall {
    LocalTime lt;
    String name;
    long number;

    public MissedCall(LocalTime lt, String name , long number){
        this.lt = lt;
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "MissedCall{" +
                "lt=" + lt +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
