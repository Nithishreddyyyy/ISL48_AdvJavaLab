package _10Shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Shop_Management implements ActionListener {
    static HashMap<Long, Integer> users = new HashMap<>();
    static ArrayList<Item> itemList = new ArrayList<>();

    JFrame inputFrame;
    JTextField userIdField, phoneField, itemIdField, itemNameField, quantityField, totalCostField;
    JButton calcBtn, printBtn;

    int userId;
    long phone;
    double total;

    public Shop_Management() {
        loginDialog();

        inputFrame = new JFrame("Shopping System");
        inputFrame.setSize(400, 400);
        inputFrame.setLayout(new GridLayout(8, 2));
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fields
        inputFrame.add(new JLabel("User ID:"));
        userIdField = new JTextField(String.valueOf(userId));
        userIdField.setEditable(false);
        inputFrame.add(userIdField);

        inputFrame.add(new JLabel("Phone Number:"));
        phoneField = new JTextField(String.valueOf(phone));
        phoneField.setEditable(false);
        inputFrame.add(phoneField);

        inputFrame.add(new JLabel("Item ID:"));
        itemIdField = new JTextField();
        inputFrame.add(itemIdField);

        inputFrame.add(new JLabel("Item Name:"));
        itemNameField = new JTextField();
        itemNameField.setEditable(false);
        inputFrame.add(itemNameField);

        inputFrame.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputFrame.add(quantityField);

        inputFrame.add(new JLabel("Total Cost:"));
        totalCostField = new JTextField();
        totalCostField.setEditable(false);
        inputFrame.add(totalCostField);

        // Buttons
        calcBtn = new JButton("Calculate");
        printBtn = new JButton("Print");

        inputFrame.add(calcBtn);
        inputFrame.add(printBtn);

        calcBtn.addActionListener(this);
        printBtn.addActionListener(this);

        inputFrame.setVisible(true);
    }

    private void loginDialog() {
        String user = "Amy", pass = "1234";
        String un = "", pw = "";

        while (!un.equals(user) || !pw.equals(pass)) {
            un = JOptionPane.showInputDialog(null, "Enter username:");
            if (!un.equals(user)) {
                JOptionPane.showMessageDialog(null, "Invalid username!");
                continue;
            }
            pw = JOptionPane.showInputDialog(null, "Enter password:");
            if (!pw.equals(pass)) {
                JOptionPane.showMessageDialog(null, "Invalid password!");
            }
        }

        try {
            phone = Long.parseLong(JOptionPane.showInputDialog(null, "Enter phone number:"));

            if (users.containsKey(phone)) {
                userId = users.get(phone);
                JOptionPane.showMessageDialog(null, "Welcome back! Your User ID: " + userId);
            } else {
                userId = Integer.parseInt(JOptionPane.showInputDialog(null, "New user. Enter new ID:"));
                users.put(phone, userId);
                JOptionPane.showMessageDialog(null, "New user added. Your User ID: " + userId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid phone number or ID!");
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcBtn) {
            String id = itemIdField.getText().trim();
            int qty;

            try {
                qty = Integer.parseInt(quantityField.getText().trim());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid quantity!");
                return;
            }

            Item item = itemList.stream()
                    .filter(i -> i.id.equals(id))
                    .findFirst()
                    .orElse(null);

            if (item == null) {
                JOptionPane.showMessageDialog(null, "Item ID not found!");
                return;
            }else{
                itemNameField.setText(item.name);
            }

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

            int discountPercent = Integer.parseInt(discounts[selected]);
            total = item.price * qty;
            total = total - (total * discountPercent / 100.0);

            totalCostField.setText(String.format("₹%.2f", total));
        }

        if (e.getSource() == printBtn) {
            JOptionPane.showMessageDialog(null,
                    "Purchase Summary:\n" +
                            "User ID: " + userId + "\n" +
                            "Phone: " + phone + "\n" +
                            "Item: " + itemNameField.getText() + "\n" +
                            "Quantity: " + quantityField.getText() + "\n" +
                            "Total: " + totalCostField.getText()
            );
        }
    }

    public static void main(String[] args) {
        // Preload
        users.put(1234567890L, 1);
        itemList.add(new Item("Bat", "1", 5000));
        itemList.add(new Item("Gloves", "2", 2000));
        itemList.add(new Item("Ball", "3", 600));

        new Shop_Management();
    }
}