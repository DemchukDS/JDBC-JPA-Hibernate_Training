package demchukDS.trainingForAston.crud.jpa_crud;

import demchukDS.trainingForAston.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Persist_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("postgres@localhost");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;

        try {
            transaction.begin();
            student = new Student("Demchuk", "Dmitriy", 9.4d);
            entityManager.persist(student);
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
        System.out.println(student);
    }
}
