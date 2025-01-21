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

public class OneToManyUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("postgres@localhost");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//                  ***PERSIST***
            University university = new University("Harvard", Date.valueOf("1636-10-28"));

            Student student1 = new Student("Dmitriy", "Demchuk", 9.8d);
            Student student2 = new Student("Vladislav", "Kobrusev", 9.4d);

            Passport passport1 = new Passport("demchuk.btg@gmail.com", 198, EyeColor.GREEN);
            Passport passport2 = new Passport("kobrusev_va@gmail.com", 185, EyeColor.GREEN);

            student1.setPassport(passport1);
            student2.setPassport(passport2);
            university.addStudentToUniversity(student1);
            university.addStudentToUniversity(student2);

            entityManager.persist(university);

//                  ***FIND***
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//            System.out.println(university.getStudents());

//                  ***REMOVE***
//            Student student = entityManager.find(Student.class, 13);
//            entityManager.remove(student);
//            University university = entityManager.find(University.class, 6);
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
