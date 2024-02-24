package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Iheb = new Student(
                    "Iheb Elazheri",
                    LocalDate.of(2000, Month.MARCH, 16),
                    "iheblazheri@gmail.com"

            );

            studentRepository.save(Iheb);
        };
    }
}