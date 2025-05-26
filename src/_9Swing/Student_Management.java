package _9Swing;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Student_Management implements ActionListener {
    ArrayList<Student> arr = new ArrayList<Student>();
    static JFrame frm, frm1;

    JLabel name1, age1, addr1, usn1, category1, details, sgp1, sgp2, sgp3, sgp4, cgp1;
    JTextField name, usn, address, age, sgpa1, sgpa2, sgpa3, sgpa4, category, cgp;
    JButton compute, done, complete;
    JTextArea jt;
    float cgpa;

    public Student_Management() {
        frm = new JFrame("Enter details");
        frm1 = new JFrame("Display details");

        name1 = new JLabel("Enter name");
        age1 = new JLabel("Enter age");
        addr1 = new JLabel("Enter address");
        usn1 = new JLabel("Enter usn");
        category1 = new JLabel("Enter category");
        details = new JLabel("Collection of Students");

        jt = new JTextArea(100, 100);
        name = new JTextField(20);
        age = new JTextField(20);
        address = new JTextField(20);
        usn = new JTextField(20);
        category = new JTextField(20);

        sgp1 = new JLabel("Enter SGPA1");
        sgpa1 = new JTextField(10);
        sgp2 = new JLabel("Enter SGPA2");
        sgpa2 = new JTextField(10);
        sgp3 = new JLabel("Enter SGPA3");
        sgpa3 = new JTextField(10);
        sgp4 = new JLabel("Enter SGPA1");
        sgpa4 = new JTextField(10);

        cgp1 = new JLabel("CGPA Computed");
        cgp = new JTextField(10);

        compute = new JButton("Compute CGPA");
        done = new JButton("Add to collection");
        complete = new JButton("Place in TextArea");

        frm.add(name1); frm.add(name);
        frm.add(age1); frm.add(age);
        frm.add(addr1); frm.add(address);
        frm.add(usn1); frm.add(usn);
        frm.add(sgp1); frm.add(sgpa1);
        frm.add(sgp2); frm.add(sgpa2);
        frm.add(sgp3); frm.add(sgpa3);
        frm.add(sgp4); frm.add(sgpa4);
        frm.add(cgp1); frm.add(cgp);
        frm.add(category1); frm.add(category);
        frm.add(compute); frm.add(done); frm.add(complete);

        done.setVisible(false);
        complete.setVisible(false);

        frm1.add(details);
        frm1.add(jt);

        compute.addActionListener(this);
        done.addActionListener(this);
        complete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == compute) {
            float t1 = Float.parseFloat(sgpa1.getText());
            float t2 = Float.parseFloat(sgpa2.getText());
            float t3 = Float.parseFloat(sgpa3.getText());
            float t4 = Float.parseFloat(sgpa4.getText());

            if (t1 > 10.0f || t2 > 10.0f || t3 > 10.0f || t4 > 10.0f)
                JOptionPane.showMessageDialog(null, "Enter correct SGPA values");
            else {
                cgpa = (t1 + t2 + t3 + t4) / 4;
                cgp.setText("CGPA is:" + cgpa);
            }

            done.setVisible(true);
            complete.setVisible(true);
        }
        else if (ae.getSource() == done) {
            String n = name.getText();
            String a = address.getText();
            String u = usn.getText();
            String c = category.getText();

            float t1 = Float.parseFloat(sgpa1.getText());
            float t2 = Float.parseFloat(sgpa2.getText());
            float t3 = Float.parseFloat(sgpa3.getText());
            float t4 = Float.parseFloat(sgpa4.getText());

            int x = Integer.parseInt(age.getText());

            if (x < 18)
                JOptionPane.showMessageDialog(null, "Enter correct age");
            else {
                Student temp = new Student(n, u, x, a, t1, t2, t3, t4, c);
                arr.add(temp);
            }
        }
        else if (ae.getSource() == complete) {
            jt.setText("");
            for (Student stud : arr) {
                jt.append(stud + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Student_Management obj = new Student_Management();
        frm.setVisible(true);
        frm.setSize(300, 400);
        frm.setLayout(new GridLayout(6, 1));

        frm1.setVisible(true);
        frm1.setSize(300, 400);
    }
}
