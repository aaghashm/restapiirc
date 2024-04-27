package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;
    private int subjectCredits;
    private int creditsObtained;
    private int semester;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectCredits() {
        return subjectCredits;
    }

    public void setSubjectCredits(int subjectCredits) {
        this.subjectCredits = subjectCredits;
    }

    public int getCreditsObtained() {
        return creditsObtained;
    }

    public void setCreditsObtained(int creditsObtained) {
        this.creditsObtained = creditsObtained;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Subject(Long id, String subjectName, int subjectCredits, int creditsObtained, int semester,
            String department) {
        this.id = id;
        this.subjectName = subjectName;
        this.subjectCredits = subjectCredits;
        this.creditsObtained = creditsObtained;
        this.semester = semester;
        this.department = department;
    }

    public Subject() {
    }

}
