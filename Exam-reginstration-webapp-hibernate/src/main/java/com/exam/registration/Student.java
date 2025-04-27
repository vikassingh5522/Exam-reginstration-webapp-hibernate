package com.exam.registration;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "exam_name")
    private String examName;

    public Student() {}

    public Student(String name, String email, String examName) {
        this.name = name;
        this.email = email;
        this.examName = examName;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }
}