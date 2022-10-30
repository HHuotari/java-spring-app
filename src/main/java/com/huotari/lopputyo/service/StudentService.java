package com.huotari.lopputyo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.huotari.lopputyo.data.Student;
import com.huotari.lopputyo.data.Course;


@Service
public class StudentService {
    
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    
    public StudentService() {
        students.add(new Student("Tommi"));
        students.add(new Student("Jarkko"));
        students.add(new Student("Reima"));
        
        Course course1 = new Course("Cpp", "Kari");
        Course course2= new Course("Tietokannat", "Jukka");

        course1.courseStudents.add(students.get(0));
        course1.courseStudents.add(students.get(1));

        course2.courseStudents.add(students.get(1));
        course2.courseStudents.add(students.get(2));

        courses.add(course1);
        courses.add(course2);    
    }
    

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }
        
    public List<Student> getStudentById(int id){
        List<Student> found = new ArrayList<>();
        for (Student student : students) {
            if(student.getId() == id) {
                found.add(student);
            }
        }
        return found;
    }

    public void addCourse(Course course){ //add a new course
        courses.add(course);
    }

    public List<Course> getAllCourses(){ //find all courses
        return courses;
    }

    public void CourseNewStudent(String courseName, String studentName) { //add student to course

        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                for(Student student : students) {
                    if (student.getName().equals(studentName)) {
                        course.courseAddStudent(student);
                    }
                }
            }
        }
    }

    public void courseDeleteStudent(String courseName, String studentName) { //delete student from a course
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                for (Student student : students) {
                    if (student.getName().equals(studentName)) {
                        course.deleteStudent(student);
                    }
                }
            }
        }
    }

    public void deleteCourse(String courseName) { 
        for (Course course : courses) {
            if(course.getName().equals(courseName)){
                int id = course.getId();
                courses.remove(id);
            }
        }
    }

    public List<Course> getCourseById(int id){ // find course by id
        List<Course> found = new ArrayList<>();
        for (Course course : courses) {
            if(course.getId() == id) {
                found.add(course);
            }
        }
        return found;
    }

    public List<Course> getCourseByName(String name){

        List<Course> found = new ArrayList<>();
        
        for (Course course : courses) {
            if(course.getName().equals(name)) {
                found.add(course);
            }
        }
        return found;
    }

    public List<Student> getStudentByName(String name){

        List<Student> found = new ArrayList<>();
        
        for (Student Student : students) {
            if(Student.getName().equals(name)) {
                found.add(Student);
            }
        }
        return found;
    }
 
}
