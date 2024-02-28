package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String studentName;
    private LocalDate studentDob;
    private String studentEmail;

    @Transient // this is not a column in the database
    private Integer studentAge;

    Student(String studentName, LocalDate studentDob, String studentEmail) {
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.studentEmail = studentEmail;
    }

    public Integer getStudentAge() {
        if (this.studentDob != null) {
            return Period.between(this.studentDob, LocalDate.now()).getYears();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentDob=" + studentDob +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentAge=" + getStudentAge() +
                '}';
    }
}