package cz.dcos.bachors.JpaDemo.repository;

import cz.dcos.bachors.JpaDemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
