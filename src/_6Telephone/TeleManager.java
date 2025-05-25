package LabPrac._6Telephone;

import java.time.LocalTime;
import java.util.*;

public class TeleManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contact> contacts = Arrays.asList(
                new Contact("name1", 9380467390L),
                new Contact("name2", 9591895619L)
        );
        LinkedList<MissedCall> missedCalls = new LinkedList<>();

        while (true) {
            System.out.print("\n1. Add Missed Call\n2. List/Delete Missed Calls\n3. Exit\nChoice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter missed call number: ");
                    long num = sc.nextLong();
                    String name = contacts.stream()
                            .filter(c -> c.number == num)
                            .map(c -> c.name)
                            .findFirst()
                            .orElse("Private Caller");
                    if (missedCalls.size() >= 3) {
                        System.out.println("Removed: " + missedCalls.removeFirst());
                    }
                    missedCalls.add(new MissedCall(LocalTime.now(), name, num));
                    System.out.println("Missed Call Added!");

                case 2 :
                    sc.nextLine(); // consume newline
                    Iterator<MissedCall> it = missedCalls.iterator();
                    while (it.hasNext()) {
                        MissedCall mc = it.next();
                        System.out.println("Missed Call: " + mc);
                        System.out.print("Delete? (1 = yes): ");
                        if (sc.nextLine().equals("1")) it.remove();
                    }
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
