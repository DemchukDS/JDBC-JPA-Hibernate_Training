package demchukDS.trainingForAston.relationships.one_to_many;

import demchukDS.trainingForAston.relationships.one_to_many.entity.Passport;
import demchukDS.trainingForAston.relationships.one_to_many.entity.Student;
import demchukDS.trainingForAston.relationships.one_to_many.entity.University;
import demchukDS.trainingForAston.relationships.one_to_many.src.EyeColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class OneToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("postgres@localhost");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//                  ***PERSIST***
//            University university1 = new University("Harvard", Date.valueOf("1956-10-28"));
//            University university2 = new University("Oxford", Date.valueOf("1812-06-20"));
//
//            Student student1 = new Student("Dmitriy", "Demchuk", 9.8);
//            Student student2 = new Student("Viktoria", "Demchuk", 9.1);
//            Student student3 = new Student("Vladislav", "Kobrusev", 8.3);
//            Student student4 = new Student("Alesya", "Kobruseva", 6.9);
//            Student student5 = new Student("Aleksandr", "Shkroba", 7.8);
//            Student student6 = new Student("Elena", "Gordeyko", 8.4);
//            Student student7 = new Student("Kirill", "Kondratiuk", 6.9);
//            Student student8 = new Student("Margarita", "Kondratiuk", 7.8);
//
//            Passport passport1 = new Passport("111111@gmail.com", 198, EyeColor.GREEN);
//            Passport passport2 = new Passport("222222@gmail.com", 170, EyeColor.BLUE);
//            Passport passport3 = new Passport("333333@gmail.com", 180, EyeColor.GREEN);
//            Passport passport4 = new Passport("444444@gmail.com", 168, EyeColor.BROWN);
//            Passport passport5 = new Passport("555555@gmail.com", 187, EyeColor.BROWN);
//            Passport passport6 = new Passport("666666@gmail.com", 172, EyeColor.BROWN);
//            Passport passport7 = new Passport("777777@gmail.com", 188, EyeColor.YELLOW);
//            Passport passport8 = new Passport("888888@gmail.com", 165, EyeColor.BLUE);
//
//            student1.setPassport(passport1);
//            student2.setPassport(passport2);
//            student3.setPassport(passport3);
//            student4.setPassport(passport4);
//            student5.setPassport(passport5);
//            student6.setPassport(passport6);
//            student7.setPassport(passport7);
//            student8.setPassport(passport8);
//
//            university1.addStudentToUniversity(student1);
//            university1.addStudentToUniversity(student5);
//            university1.addStudentToUniversity(student7);
//            university2.addStudentToUniversity(student2);
//            university2.addStudentToUniversity(student3);
//            university2.addStudentToUniversity(student4);
//            university2.addStudentToUniversity(student8);
//            university2.addStudentToUniversity(student6);
//
//            entityManager.persist(university1);
//            entityManager.persist(university2);
//
//                  ***FIND***
            University university = entityManager.find(University.class, 2);
            System.out.println(university);
            System.out.println(university.getStudents());

//                  ***REMOVE***
//            Student student = entityManager.find(Student.class, 2);
//            entityManager.remove(student);
//            University university = entityManager.find(University.class, 2);
//            entityManager.remove(university);



            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
