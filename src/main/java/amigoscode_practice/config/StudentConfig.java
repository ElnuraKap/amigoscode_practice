package amigoscode_practice.config;

import amigoscode_practice.models.Student;
import amigoscode_practice.repositories.StudentRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.DECEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepositories studentRepositories){
        return args -> {

            Student bob = new Student(
                    1L,
                    "Bob",
                    "bob@gmail",
                    LocalDate.of(2000, DECEMBER, 23)
            );

            Student alex = new Student(
                    1L,
                    "Alex",
                    "alex@gmail",
                    LocalDate.of(2004, DECEMBER, 23)
            );
            studentRepositories.saveAll(List.of( alex,bob)
            );
        };
    }
}
