package com.collegemanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String id;

    private String name;
    private String rollNo;
    private String className;
    private String phone;

    // Mongo stores only reference ID
    private String userId;

    public Student() {}

    public Student(String name, String rollNo, String className, String phone, String userId) {
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.phone = phone;
        this.userId = userId;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public String getClassName() { return className; }
    public String getPhone() { return phone; }
    public String getUserId() { return userId; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public void setClassName(String className) { this.className = className; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setUserId(String userId) { this.userId = userId; }
}
