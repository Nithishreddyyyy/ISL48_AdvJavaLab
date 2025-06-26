package _9StudentSwing;

public class Student {
    public String name, usn, address, category;
    public int age;
    public float sgpa_1, sgpa_2, sgpa_3, sgpa_4;

    public Student(String name, String usn, int age, String address, float sgpa_1, float sgpa_2, float sgpa_3, float sgpa_4, String category) {
        this.name = name;
        this.usn = usn;
        this.age = age;
        this.address = address;
        this.sgpa_1 = sgpa_1;
        this.sgpa_2 = sgpa_2;
        this.sgpa_3 = sgpa_3;
        this.sgpa_4 = sgpa_4;
        this.category = category;
    }

    public float computeCGPA() {
        return (sgpa_1 + sgpa_2 + sgpa_3 + sgpa_4) / 4;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", usn='" + usn + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", age=" + age +
                ", sgpa_1=" + sgpa_1 +
                ", sgpa_2=" + sgpa_2 +
                ", sgpa_3=" + sgpa_3 +
                ", sgpa_4=" + sgpa_4 +
                '}';
    }
}