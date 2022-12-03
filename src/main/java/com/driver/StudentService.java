package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudentInDB(Student student){
         studentRepository.addStudentInDB(student);
    }

    public void addTeacherInDB(Teacher teacher){
         studentRepository.addTeacherInDB(teacher);
    }

    public void addStudentTeacherPairInDB(String studentName, String teacherName){
        studentRepository.addStudentTeacherPairInDB(studentName,teacherName);
    }

    public Student getStudentByNameInDB(String studentName){
        return studentRepository.getStudentByNameInDB(studentName);
    }

    public Teacher getTeacherByNameInDB(String teacherName){
        return studentRepository.getTeacherByNameInDB(teacherName);
    }

    public List<String> getStudentsByTeacherNameInDB(String teacherName){
        return studentRepository.getStudentsByTeacherNameInDB(teacherName);
    }

    public List<String> getAllStudentsInDB(){
        return studentRepository.getAllStudentsInDB();
    }

    public void deleteTeacherByNameInDB(String teacherName){
        studentRepository.deleteTeacherByNameInDB(teacherName);
    }

    public void deleteAllTeachersInDB(){
       studentRepository.deleteAllTeachersInDB();
    }
}
