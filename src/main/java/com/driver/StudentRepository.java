package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> students = new HashMap<>();
    HashMap<String, Teacher> teachers = new HashMap<>();
    HashMap<String, List<String>> teacherStudents = new HashMap<>();

    //Add new Student
    public void addStudentInDB(Student student){
        students.put(student.getName(),student);
    }

    //Add new teacher
    public void addTeacherInDB(Teacher teacher){
        teachers.put(teacher.getName(),teacher);
    }

    //Pair an existing student teacher pair
    public void addStudentTeacherPairInDB(String studentName, String teacherName){
        boolean isTeacherExist = teacherStudents.containsKey(teacherName);
        List<String> teachStudents = new ArrayList<>();

        if(isTeacherExist){
            teachStudents = teacherStudents.get(teacherName);
            teachStudents.add(studentName);
            teacherStudents.put(teacherName,teachStudents);
        }else{
            teachStudents.add(studentName);
            teacherStudents.put(teacherName,teachStudents);
        }
    }

    //Get student by student name
    public Student getStudentByNameInDB(String studentName){
        for(Student student : students.values()){
            if(student.getName().equals(studentName)){
                return student;
            }
        }
        return null;
    }

    //Get teacher by teacher name
    public Teacher getTeacherByNameInDB(String teacherName){
        for(Teacher teacher : teachers.values()){
            if(teacher.getName().equals(teacherName)){
                return teacher;
            }
        }
        return null;
    }

    //Get students name list by teacher's name
    public List<String> getStudentsByTeacherNameInDB(String teacherName){

        for(String teacher : teacherStudents.keySet()){
            if(teacher.equals(teacherName)){
                return teacherStudents.get(teacherName);
            }
        }
        return null;
    }

    //Get All Students
    public List<String> getAllStudentsInDB(){
        List<String> allStudentsList = new ArrayList<>();

        for(String stud : students.keySet()){
            allStudentsList.add(stud);
        }
        return allStudentsList;
    }

    //Delete teacher by name
    public void deleteTeacherByNameInDB(String teacherName){
        List<String> studentsList = new ArrayList<>();
        studentsList = teacherStudents.get(teacherName);

        teachers.remove(teacherName);
        teacherStudents.remove(teacherName);

        for(String student: studentsList){
            students.remove(student);
        }
    }

    //Delete all teachers
    public void deleteAllTeachersInDB(){
        for(String teacher: teachers.keySet()){
            deleteTeacherByNameInDB(teacher);
        }
    }

}
