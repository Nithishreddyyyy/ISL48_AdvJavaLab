package _6Telephone;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
class Manager {
    public static void main(String[] args) {
        ArrayList<Contact> cl = new ArrayList<>();
        cl.add(new Contact("name1", 9380467390L));
        cl.add(new Contact("name2", 9591895619L));

        ArrayList<MissedCall> mc = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter a choice: ");
            System.out.println("1. Add Missed Call");
            System.out.println("2. List and Delete Missed Calls");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the missed call number:");
                    long miss_ca = Long.parseLong(sc.nextLine());

                    String name = "Private Caller";
                    for (Contact c : cl) {
                        if (c.number == miss_ca) {
                            name = c.name;
                            break;
                        }
                    }

                    if (mc.size() >= 3) {
                        MissedCall removed = mc.remove(0);
                        System.out.println("Removed oldest missed call: " + removed);
                    }
                    mc.add(new MissedCall(LocalTime.now(), name, miss_ca));
                    System.out.println("Missed Call Added!");
                    break;

                case 2:
                    ArrayList<MissedCall> delCall = new ArrayList<>();
                    for (MissedCall v : mc) {
                        System.out.println("Missed Call: " + v);
                        System.out.print("Do you want to delete this missed call? (1 to delete, any other key to keep): ");
                        String input = sc.nextLine();
                        if (input.equals("1")) {
                            delCall.add(v);
                        }
                    }
                    mc.removeAll(delCall);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

