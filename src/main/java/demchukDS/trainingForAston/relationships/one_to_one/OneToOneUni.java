package demchukDS.trainingForAston.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("postgres@localhost");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//              ***PERSIST***
//            Student student1 = new Student("Julia", "Gordeyko", 7.9d);
//            Passport passport1 = new Passport("julia.gordeyka@gmail.com", 175, "brown");
//            student1.setPassport(passport1);

//            entityManager.persist(student1);

//              ***FIND***
//            Student student = entityManager.find(Student.class, 3);
//            System.out.println(student);
//            System.out.println(student.getPassport());

//              ***REMOVE***
//            entityManager.remove(entityManager.find(Student.class, 5));

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
