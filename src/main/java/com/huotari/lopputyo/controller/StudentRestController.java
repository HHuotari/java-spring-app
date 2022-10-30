package com.huotari.lopputyo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huotari.lopputyo.data.Student;
import com.huotari.lopputyo.service.StudentService;
import com.huotari.lopputyo.data.Course;

@RestController
public class StudentRestController {
    
    @Autowired
    StudentService sService;

    @GetMapping("students")
    public List<Student> getStudents(){  //find all students
        return sService.getAllStudents();
    }

    @PostMapping("addstudent")
    public Student addStudent(@RequestBody Student student ) { //add new student
        sService.addStudent(student);
        return student;
    }


    @GetMapping("courses")
    public List<Course> getCourses(){  //find all courses
        return sService.getAllCourses();
    }

    //http://localhost:8080/courses/id/+id
    @GetMapping("courses/id/{id}")
    public List<Course> getCourseById(@PathVariable int id){  //find course by id
        return sService.getCourseById(id);
    }

    //http://localhost:8080/students/id/+id
    @GetMapping("students/id/{id}")
    public List<Student> getStudentById(@PathVariable int id){  //find Student by id
        return sService.getStudentById(id);
    }

    @PostMapping("addcourse")
    public Course addCourse(@RequestBody Course course ) { //add new course
        sService.addCourse(course);
        return course;
    }

    //http://localhost:8080/students/name/+name
    @GetMapping("students/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return sService.getStudentByName(name);
    }

    //http://localhost:8080/courses/name/+name
    @GetMapping("courses/name/{name}")
    public List<Course> getCourseByName(@PathVariable String name) {
        return sService.getCourseByName(name);
    }

    //postman 
    @PostMapping("courseaddstudent") //add student to course
    public String CourseAddStudent(@RequestParam String course, @RequestParam String student) {
         sService.CourseNewStudent(course, student);
         return "Student added";
    }

    @DeleteMapping("coursedeletestudent") //delete student from course
    public String courseDeleteStudent(@RequestParam String courseName, @RequestParam String studentName) {
        sService.courseDeleteStudent(courseName, studentName);
        return "Student deleted";
    }

    @DeleteMapping("deletecourse")
    public String deleteCourse(@RequestParam String course) {
        sService.deleteCourse(course);
        return "Course deleted";
    }



}
