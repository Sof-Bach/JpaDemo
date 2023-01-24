package cz.dcos.bachors.JpaDemo.entity.repository;

import cz.dcos.bachors.JpaDemo.entity.Guardian;
import cz.dcos.bachors.JpaDemo.entity.Student;
import cz.dcos.bachors.JpaDemo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder().
                email("fuz@gmail.com").
                firstName("Fuz").
                lastName("Tucny").
                build();
        studentRepository.save(student);
    }

    @Test
    public void printStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("Tlst Fuzaty","tlst@gmail.com","0904504656");

        Student student = Student.builder().
                email("Fuz.Tucny1@gmail.com").
                firstName("Fuz").
                lastName("Tucny").
                guardian(guardian).build();
        studentRepository.save(student);
        printStudents();
    }

    @Test
    public void printStudentsByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Fuz");
        System.out.println(students);
    }

    @Test
    public void printStudentsByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("u");
        System.out.println(students);
    }

    @Test
    public void printStudentsByGuardian(){
        List<Student> students = studentRepository.findByGuardianName("Tlst");
        System.out.println(students);
    }

    @Test
    public void printStudentsByFirstNameAndLastName(){
        List<Student> students = studentRepository.findByFirstNameAndLastName("Fuz", "Tucny");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmail(){
        Student student = studentRepository.getStudentByEmail("Fuz.Tucny@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmail(){
        String firstName = studentRepository.getStudentFirstNameByEmail("Fuz.Tucny@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printStudentbyEmailNative(){
        Student student = studentRepository.getStudentByEmailNative("Fuz.Tucny@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentbyEmailNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailNativeNamedParam("Fuz.Tucny@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudenNametbyEmail(){
        studentRepository.updateStudentNameByEmail("Tuc","Fuz.Tucny@gmail.com");
    }
}