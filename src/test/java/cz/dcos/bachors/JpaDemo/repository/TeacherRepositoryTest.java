package cz.dcos.bachors.JpaDemo.repository;

import cz.dcos.bachors.JpaDemo.entity.Course;
import cz.dcos.bachors.JpaDemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseGeo = Course.builder().title("Geo").credit(3).build();
        Course courseSk = Course.builder().title("Sk").credit(6).build();
        //Teacher teacher = Teacher.builder().firstName("Milan").lastName("Slovak").courses(List.of(courseGeo,courseSk)).build();
        //teacherRepository.save(teacher);

    }
}