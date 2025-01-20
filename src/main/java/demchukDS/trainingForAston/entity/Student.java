package demchukDS.trainingForAston.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "avg_grade")
    private Double avgGrade;

    @Transient
    private LocalDateTime createDate;

    public Student(String name, String surname, double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
        createDate = LocalDateTime.now();
    }
    public Student() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public double getAvgGrade() {
        return avgGrade;
    }
    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", createDate=" + createDate +
                "}";
    }
}
