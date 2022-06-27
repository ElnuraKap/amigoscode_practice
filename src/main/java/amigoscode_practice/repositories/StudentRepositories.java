package amigoscode_practice.repositories;

import amigoscode_practice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepositories extends JpaRepository<Student,Long> {

    @Query("select s from Student s where s.email =  ?1")
    Optional<Student> findStudentByEmail(String email);
}
