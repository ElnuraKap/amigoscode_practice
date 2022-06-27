package amigoscode_practice.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @SequenceGenerator(
            name = "students_sequence",
            sequenceName = "students_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_sequence"
    )
    private Long id;

    private String name;

    private String email;

    private LocalDate dob;

    @Transient
    private Integer  age;


    public Student() {
    }

    public Student(
            Long id,
            String name,
            String email,
            LocalDate dod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dod;
    }

    public Student(
            String name,
            String email,
            LocalDate dod) {
        this.name = name;
        this.email = email;
        this.dob = dod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dod) {
        this.dob = dod;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears() ;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dod=" + dob +
                ", age=" + age +
                '}';
    }
}
