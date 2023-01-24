package cz.dcos.bachors.JpaDemo.repository;

import cz.dcos.bachors.JpaDemo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
