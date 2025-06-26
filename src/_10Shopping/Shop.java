package _10Shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Shop implements ActionListener {
    String user = "Amy";
    String pass = "1234";
    String un = "", pw = "";
    int id;
    JTextField useridField, phoneField, itemIdField, quantityField, itemNameField;
    JButton submitButton;
    double total = 0.0;

    static HashMap<Long, Integer> users = new HashMap<>();
    static ArrayList<Item> itemList = new ArrayList<>();

    public Shop() {
        // User login
        while (!un.equals(user) || !pw.equals(pass)) {
            un = JOptionPane.showInputDialog(null, "Enter username");
            if (!un.equals(user)) {
                JOptionPane.showMessageDialog(null, "Invalid username");
            } else {
                pw = JOptionPane.showInputDialog(null, "Enter password");
                if (!pw.equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Invalid password");
                }
            }
        }

        // Phone number and user ID
        long phone = Long.parseLong(JOptionPane.showInputDialog(null, "Enter phone number:"));
        if (users.containsKey(phone)) {
            id = users.get(phone);
            JOptionPane.showMessageDialog(null, "Welcome back! Your User ID: " + id);
        } else {
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "New user. Enter new ID:"));
            users.put(phone, id);
        }

        // GUI Form
        JFrame frame = new JFrame("Purchase Details");
        frame.setSize(350, 300);
        frame.setLayout(new GridLayout(6, 2));

        useridField = new JTextField(String.valueOf(id), 20);
        useridField.setEditable(false);

        phoneField = new JTextField(String.valueOf(phone), 20);
        phoneField.setEditable(false);

        itemIdField = new JTextField(20);
        quantityField = new JTextField(20);
        itemNameField = new JTextField(20);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        frame.add(new JLabel("User ID:"));
        frame.add(useridField);
        frame.add(new JLabel("Phone Number:"));
        frame.add(phoneField);
        frame.add(new JLabel("Item ID:"));
        frame.add(itemIdField);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityField);
        frame.add(new JLabel("Item Name:"));
        frame.add(itemNameField);
        frame.add(new JLabel(""));
        frame.add(submitButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredItemId = itemIdField.getText().trim();
        String enteredItemName = itemNameField.getText().trim();
        int quantity;

        try {
            quantity = Integer.parseInt(quantityField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid quantity entered!");
            return;
        }

        // Discount selection
        String[] discounts = {"5", "10", "15"};
        int selected = JOptionPane.showOptionDialog(
                null,
                "Select Discount (%)",
                "Discount Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                discounts,
                discounts[0]
        );

        // Find item
        Optional<Item> match = itemList.stream()
                .filter(item -> item.id.equals(enteredItemId))
                .findFirst();

        if (match.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Item ID not found!");
            return;
        }

        Item selectedItem = match.get();
        total = selectedItem.price * quantity;
        int discountValue = Integer.parseInt(discounts[selected]);
        total = total - (total * discountValue / 100.0);

        JOptionPane.showMessageDialog(null,
                "Purchase Summary:\n" +
                        "Item: " + selectedItem.name + "\n" +
                        "Quantity: " + quantity + "\n" +
                        "Total (after " + discountValue + "% discount): ₹" + total
        );
    }

    public static void main(String[] args) {
        // Preload users and items
        users.put(1234567890L, 1);
        itemList.add(new Item("Bat", "1", 5000));
        itemList.add(new Item("Gloves", "2", 2000));
        itemList.add(new Item("Ball", "3", 600));

        new Shop();
    }
}
