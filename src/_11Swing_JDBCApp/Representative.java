package _11Swing_JDBCApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Representative implements ActionListener {
    // JDBC
    Connection con;
    PreparedStatement repStmt, custStmt;
    Statement stmt;
    ResultSet rs;

    // UI Components
    JFrame inputFrame, displayFrame;
    JTextField repNoField, repNameField, stateField, commField, rateField;
    JTextField custNoField, custNameField, creditLimitField;
    JTextArea displayArea;
    JButton submitBtn, displayBtn;

    public Representative() {
        // Set up Input Frame
        inputFrame = new JFrame("Representative & Customer Entry");
        inputFrame.setSize(400, 500);
        inputFrame.setLayout(new GridLayout(9, 2));
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input Fields
        inputFrame.add(new JLabel("Rep No:"));
        repNoField = new JTextField();
        inputFrame.add(repNoField);

        inputFrame.add(new JLabel("Rep Name:"));
        repNameField = new JTextField();
        inputFrame.add(repNameField);

        inputFrame.add(new JLabel("State:"));
        stateField = new JTextField();
        inputFrame.add(stateField);

        inputFrame.add(new JLabel("Commission:"));
        commField = new JTextField();
        inputFrame.add(commField);

        inputFrame.add(new JLabel("Rate:"));
        rateField = new JTextField();
        inputFrame.add(rateField);

        inputFrame.add(new JLabel("Customer No:"));
        custNoField = new JTextField();
        inputFrame.add(custNoField);

        inputFrame.add(new JLabel("Customer Name:"));
        custNameField = new JTextField();
        inputFrame.add(custNameField);

        inputFrame.add(new JLabel("Credit Limit:"));
        creditLimitField = new JTextField();
        inputFrame.add(creditLimitField);

        // Buttons
        submitBtn = new JButton("Submit");
        displayBtn = new JButton("Display Reps (Credit > 15000)");
        submitBtn.addActionListener(this);
        displayBtn.addActionListener(this);

        inputFrame.add(submitBtn);
        inputFrame.add(displayBtn);
        inputFrame.setVisible(true);

        // Display Frame
        displayFrame = new JFrame("Representative Info");
        displayFrame.setSize(400, 400);
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);
        displayFrame.add(scroll);
        displayFrame.setVisible(false); // initially hidden

        // JDBC setup
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Clg", "root", "test1234");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DB Connection Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            insertData();
        } else if (e.getSource() == displayBtn) {
            displayReps();
        }
    }

    private void insertData() {
        try {
            int repNo = Integer.parseInt(repNoField.getText().trim());
            String repName = repNameField.getText().trim();
            String state = stateField.getText().trim();
            double commission = Double.parseDouble(commField.getText().trim());
            double rate = Double.parseDouble(rateField.getText().trim());

            int custNo = Integer.parseInt(custNoField.getText().trim());
            String custName = custNameField.getText().trim();
            double credit = Double.parseDouble(creditLimitField.getText().trim());

            // Insert into Rep table
            String repQuery = "INSERT INTO Rep VALUES (?, ?, ?, ?, ?)";
            repStmt = con.prepareStatement(repQuery);
            repStmt.setInt(1, repNo);
            repStmt.setString(2, repName);
            repStmt.setString(3, state);
            repStmt.setDouble(4, commission);
            repStmt.setDouble(5, rate);
            repStmt.executeUpdate();

            // Insert into Cust table
            String custQuery = "INSERT INTO Cust VALUES (?, ?, ?, ?, ?)";
            custStmt = con.prepareStatement(custQuery);
            custStmt.setInt(1, custNo);
            custStmt.setString(2, custName);
            custStmt.setString(3, state);
            custStmt.setDouble(4, credit);
            custStmt.setInt(5, repNo);
            custStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserted successfully!");

            // Clear fields
            repNoField.setText("");
            repNameField.setText("");
            stateField.setText("");
            commField.setText("");
            rateField.setText("");
            custNoField.setText("");
            custNameField.setText("");
            creditLimitField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Insert Error: " + ex.getMessage());
        }
    }

    private void displayReps() {
        try {
            displayArea.setText("");
            stmt = con.createStatement();
            String query = "SELECT * FROM Rep WHERE RepNo IN " +
                    "(SELECT RepNo FROM Cust WHERE cred > 15000)";
            rs = stmt.executeQuery(query);

            boolean found = false;
            while (rs.next()) {
                found = true;
                displayArea.append("Rep No: " + rs.getInt("RepNo") + "\n");
                displayArea.append("Rep Name: " + rs.getString("RepName") + "\n");
                displayArea.append("State: " + rs.getString("State") + "\n");
                displayArea.append("Commission: " + rs.getDouble("comm") + "\n");
                displayArea.append("Rate: " + rs.getDouble("Rate") + "\n");
                displayArea.append("--------------------------------------\n");
            }

            if (!found) {
                displayArea.setText("No representatives found with Credit Limit > 15000.");
            }

            displayFrame.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Display Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Representative();
    }
}
