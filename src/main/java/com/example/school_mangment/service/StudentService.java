package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Student;
import com.example.school_mangment.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return this.studentRepository.findAll();
    }
    public Student findById(Integer id){
        if(id==0)
            throw new IllegalStateException("this id student not found ");
        Optional<Student> stu = this.studentRepository.findById(id);
        if(stu!=null&& stu.get()!=null){
            return stu.get();
        }
        return null;
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.FindStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    public Student updateStudent (Student student){
        return this.studentRepository.save(student);
    }

}
