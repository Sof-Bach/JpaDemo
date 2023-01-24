package cz.dcos.bachors.JpaDemo.repository;

import cz.dcos.bachors.JpaDemo.entity.Course;
import cz.dcos.bachors.JpaDemo.entity.CourseMaterial;
import cz.dcos.bachors.JpaDemo.entity.Student;
import cz.dcos.bachors.JpaDemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder().firstName("Stevo").lastName("Pekny").build();
        Course course = Course.builder().title("Aj").credit(4).teacher(teacher).build();
        courseRepository.save(course);
    }

    @Test
    public void pageAllCourses(){
        Pageable page = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findAll(page).getContent();
        long totalPages =  courseRepository.findAll(page).getTotalPages();
        long totalCourses = courseRepository.findAll(page).getTotalElements();

        System.out.println(courses);
        System.out.println(totalPages);
        System.out.println(totalCourses);
    }

    @Test
    public void sortAllCoursesByCredit(){
        Pageable sortByCredit = PageRequest.of(0, 5,
                Sort.by("credit").descending());

        List<Course> courses = courseRepository.findAll(sortByCredit).getContent();
        System.out.println(courses);
    }

    @Test
    public void findAllCoursesContaining(){
        Pageable page = PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("G",page).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder().firstName("Frantisek")
                .lastName("Mily").build();
        Student student = Student.builder().firstName("Martin").lastName("Tlsty")
                .email("martin.tlsty@gmail.com").build();
        Course course = Course.builder().title("Chem").credit(2).teacher(teacher).build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}