package cz.dcos.bachors.JpaDemo.repository;

import cz.dcos.bachors.JpaDemo.entity.Course;
import cz.dcos.bachors.JpaDemo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository materialRepository;


    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().title("AJ").credit(6).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.aj.sk").course(course).build();
        materialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = materialRepository.findAll();
        System.out.println(courseMaterials);
    }

}