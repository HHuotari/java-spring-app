package com.huotari.lopputyo.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private String teacher;
    public List<Student> courseStudents = new ArrayList<>();
    private static int idCounter=0;

    public Course(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
        this.id = idCounter++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void courseAddStudent(Student student) { //add new student to the course
        this.courseStudents.add(student);
    }

    public List<Student> getCourseStudents() { //list all students on the course
        return new ArrayList<>(this.courseStudents);
    }

    public void deleteStudent(Student student) {
        this.courseStudents.remove(student);
    }
    
}
