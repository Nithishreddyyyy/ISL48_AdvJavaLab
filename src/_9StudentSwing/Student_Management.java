package _9StudentSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Student_Management implements ActionListener {
    ArrayList<Student> students = new ArrayList<>();

    JFrame inputFrame, displayFrame;
    JTextField nameField, ageField, addressField, usnField;
    JComboBox<String> categoryField;
    JTextField sgpa1Field, sgpa2Field, sgpa3Field, sgpa4Field, cgpaField;
    JTextArea displayArea;
    JButton computeBtn, doneBtn, completeBtn;

    float cgpa;

    public Student_Management() {
        // Input Frame
        inputFrame = new JFrame("Student Details Input");
        inputFrame.setSize(400, 500);
        inputFrame.setLayout(new GridLayout(11, 2));
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputFrame.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputFrame.add(nameField);

        inputFrame.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputFrame.add(ageField);

        inputFrame.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputFrame.add(addressField);

        inputFrame.add(new JLabel("USN:"));
        usnField = new JTextField();
        inputFrame.add(usnField);

        inputFrame.add(new JLabel("SGPA 1:"));
        sgpa1Field = new JTextField();
        inputFrame.add(sgpa1Field);

        inputFrame.add(new JLabel("SGPA 2:"));
        sgpa2Field = new JTextField();
        inputFrame.add(sgpa2Field);

        inputFrame.add(new JLabel("SGPA 3:"));
        sgpa3Field = new JTextField();
        inputFrame.add(sgpa3Field);

        inputFrame.add(new JLabel("SGPA 4:"));
        sgpa4Field = new JTextField();
        inputFrame.add(sgpa4Field);

        inputFrame.add(new JLabel("Category:"));
        categoryField = new JComboBox<>(new String[]{"General", "OBC", "SC", "ST"});
        inputFrame.add(categoryField);

        inputFrame.add(new JLabel("CGPA:"));
        cgpaField = new JTextField();
        cgpaField.setEditable(false);
        inputFrame.add(cgpaField);

        computeBtn = new JButton("Compute");
        doneBtn = new JButton("Done");
        completeBtn = new JButton("Complete");

        inputFrame.add(computeBtn);
        inputFrame.add(doneBtn);
        inputFrame.add(completeBtn);

        computeBtn.addActionListener(this);
        doneBtn.addActionListener(this);
        completeBtn.addActionListener(this);

        // Initially disable "Done" button
        doneBtn.setEnabled(false);

        inputFrame.setVisible(true);

        // Display Frame
        displayFrame = new JFrame("Student Records");
        displayFrame.setSize(400, 400);
        displayArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(displayArea);
        displayFrame.add(scroll);
        displayFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == computeBtn) {
            try {
                float s1 = Float.parseFloat(sgpa1Field.getText());
                float s2 = Float.parseFloat(sgpa2Field.getText());
                float s3 = Float.parseFloat(sgpa3Field.getText());
                float s4 = Float.parseFloat(sgpa4Field.getText());

                if (s1 > 10 || s2 > 10 || s3 > 10 || s4 > 10) {
                    JOptionPane.showMessageDialog(null, "SGPA must be <= 10");
                    return;
                }

                cgpa = (s1 + s2 + s3 + s4) / 4;
                cgpaField.setText(String.format("%.2f", cgpa));

                computeBtn.setEnabled(false);
                doneBtn.setEnabled(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter valid SGPA values.");
            }
        } else if (e.getSource() == doneBtn) {
            try {
                String name = nameField.getText();
                String ageText = ageField.getText();
                String address = addressField.getText();
                String usn = usnField.getText();

                if (name.isEmpty() || ageText.isEmpty() || address.isEmpty() || usn.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                    return;
                }

                int age = Integer.parseInt(ageText);
                if (age < 18) {
                    JOptionPane.showMessageDialog(null, "Age must be at least 18");
                    return;
                }

                float s1 = Float.parseFloat(sgpa1Field.getText());
                float s2 = Float.parseFloat(sgpa2Field.getText());
                float s3 = Float.parseFloat(sgpa3Field.getText());
                float s4 = Float.parseFloat(sgpa4Field.getText());

                String category = (String) categoryField.getSelectedItem();

                Student s = new Student(name, usn, age, address, s1, s2, s3, s4, category);
                students.add(s);

                JOptionPane.showMessageDialog(null, "Student added successfully!");

                // Reset fields
                nameField.setText("");
                ageField.setText("");
                addressField.setText("");
                usnField.setText("");
                sgpa1Field.setText("");
                sgpa2Field.setText("");
                sgpa3Field.setText("");
                sgpa4Field.setText("");
                cgpaField.setText("");

                doneBtn.setEnabled(false);
                computeBtn.setEnabled(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please fill all fields correctly.");
            }
        } else if (e.getSource() == completeBtn) {
            displayArea.setText("");
            for (Student s : students) {
                displayArea.append(s + "\n");
            }
        }
    }

    public static void main(String[] args) {
        new Student_Management();
    }
}
