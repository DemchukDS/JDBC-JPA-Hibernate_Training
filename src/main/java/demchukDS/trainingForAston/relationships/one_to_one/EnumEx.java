package demchukDS.trainingForAston.relationships.one_to_one;

import demchukDS.trainingForAston.relationships.one_to_many.entity.Passport;
import demchukDS.trainingForAston.relationships.one_to_many.entity.Student;
import demchukDS.trainingForAston.relationships.one_to_many.src.EyeColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EnumEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("postgres@localhost");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Student student = new Student("Dmitriy", "Demchuk", 9.8d);
            Passport passport = new Passport("demchuk.btg@gmail.com", 198, EyeColor.GREEN);

            student.setPassport(passport);
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
    }
}
