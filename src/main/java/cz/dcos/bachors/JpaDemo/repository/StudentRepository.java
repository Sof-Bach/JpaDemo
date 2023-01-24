package cz.dcos.bachors.JpaDemo.repository;

import cz.dcos.bachors.JpaDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String letter);
    public List<Student> findByGuardianName(String name);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmail(String email);

    //JPQL
    @Query("select s.firstName from Student s where s.email = ?1")
    String getStudentFirstNameByEmail(String email);

    //Native
    @Query(value = "SELECT * FROM tbl_student s where s.email = ?1", nativeQuery = true)
    Student getStudentByEmailNative(String email);

    //Native named param
    @Query(value = "SELECT * FROM tbl_student s where s.email = :email", nativeQuery = true)
    Student getStudentByEmailNativeNamedParam(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student set first_name = ?1 where email =?2", nativeQuery = true)
    int updateStudentNameByEmail(String firstName, String email);
}
