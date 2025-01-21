package demchukDS.trainingForAston.relationships.one_to_one;

import demchukDS.trainingForAston.relationships.one_to_one.entity.Passport;
import demchukDS.trainingForAston.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("postgres@localhost");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//              ***PERSIST***
//            Student student1 = new Student("Alesya", "Kobruseva", 9.1d);
//            Passport passport1 = new Passport("kobruseva.alesya@gmail.com",168, "brown");
//
//            student1.setPassport(passport1);
//            entityManager.persist(student1);

//              ***FIND***
//            Passport passport = entityManager.find(Passport.class, 2);
//            System.out.println(passport);
//            System.out.println(student1);

//              ***REMOVE***
//            Passport passport = entityManager.find(Passport.class, 3);
//            entityManager.remove(passport);



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
