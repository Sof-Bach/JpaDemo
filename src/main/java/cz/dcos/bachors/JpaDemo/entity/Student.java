package cz.dcos.bachors.JpaDemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = {
        @UniqueConstraint(name = "email_unique", columnNames = {"email"})
})
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;

    private String firstName;
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
}
