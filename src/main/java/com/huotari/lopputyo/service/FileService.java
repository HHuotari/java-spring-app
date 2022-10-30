package com.huotari.lopputyo.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.huotari.lopputyo.data.Course;
import com.huotari.lopputyo.data.Student;

@Service
public class FileService {
    
    public void writeCourse(List<Course> courses) { //courses to file

        try {
            FileWriter fileW = new FileWriter("C:\\temp\\courses.txt");

            for (Course course : courses) {
                fileW.write(course + " ");
            }
            fileW.close();
            System.out.println("writeCourse ok.");

        } catch (IOException e) {
            System.out.println("writeCourse error.");
            e.printStackTrace();
          }
        
    }


    public void writeStudent(List<Student> students) { //students to file

        try {
            FileWriter fileW = new FileWriter("C:\\temp\\students.txt");

            for (Student student : students) {
                fileW.write(student + " ");
            }
            fileW.close();
            System.out.println("writeStudent ok.");

        } catch (IOException e) {
            System.out.println("writeStudent error.");
            e.printStackTrace();
          }
        
    }

    public List<Student> readStudents() { //read students from file
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner("C:\\temp\\students.txt");

        while(scanner.hasNextLine()) {
            students.add(new Student(scanner.next()));
        }

        scanner.close();
        return students;
    }

    public List<Course> readCourses() { //read courses from file
        List<Course> courses = new ArrayList<>();
        Scanner scanner = new Scanner("C:\\temp\\courses.txt");

        while(scanner.hasNextLine()) {
            courses.add(new Course(scanner.next(), scanner.next()));
        }

        scanner.close();
        return courses;
    }
}
