package com.brisis.springdatajpa.repository;

import com.brisis.springdatajpa.entity.Guardian;
import com.brisis.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ben@gmail.com")
                .firstName("Ben")
                .lastName("Mudzinga")
//                .guardianEmail("tina@gmail.com")
//                .guardianName("Tina Mudzinga")
//                .guardianMobile("123456670707")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("muche@gmail.com")
                .name("Muche Map")
                .mobile("0189282922")
                .build();

        Student student = Student.builder()
                .firstName("Vic")
                .lastName("Mudzi")
                .emailId("vic@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("List of Students = "+ students);
    }

    @Test
    public void findStudentsByFirstName(){
        List<Student> students = studentRepository.findByFirstName("ben");
        System.out.println("Students = " + students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("b");
        System.out.println("Students = " + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Tina Mudzi");
        System.out.println("Students = " + students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("ben@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("ben@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void getStudentByEmailAddressFirstNameOnly(){
        String student = studentRepository.getStudentByEmailAddressFirstNameOnly("ben@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Brisis", "ben@gmail.com");
    }

}