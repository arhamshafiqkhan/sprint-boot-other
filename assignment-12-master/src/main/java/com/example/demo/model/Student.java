package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Student {
    @Column(name="STUDENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="NAME")
    private String name;
    @Column(name="ROLLNO")
    private int rollNo;
    @Column(name="AGE")
    private int age;

    public Student() {
    }

    public Student(int id, String name, int rollNo, int age) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                '}';
    }
}
