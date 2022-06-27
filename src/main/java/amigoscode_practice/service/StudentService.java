package amigoscode_practice.service;

import amigoscode_practice.models.Student;
import amigoscode_practice.repositories.StudentRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepositories studentRepositories;

    public StudentService(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }

    public List<Student> getStudents() {
        return studentRepositories.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepositories
                .findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepositories.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepositories.existsById(studentId);
        if (!exists){
            throw new IllegalStateException
                    ("student with id" + studentId + "does not exists");
        }
        studentRepositories.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepositories.findById(studentId)
                .orElseThrow(()->new IllegalStateException
                        ("student with id" + studentId  + "dost not exist"));

        if (name != null &&
                name.length() > 0 &&
        !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(),email)){

            Optional<Student> studentByEmail = studentRepositories.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email) ;
        }

    }
}
