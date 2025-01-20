package demchukDS.trainingForAston.jpa_crud;

import demchukDS.trainingForAston.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Remove_ex {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("postgres@localhost");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        Student student = null;

        try{
            transaction.begin();

            student = em.find(Student.class, 4);
            em.remove(student);

            transaction.commit();
        }
        catch(Exception e){
            if (transaction!=null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (em!=null) {
                em.close();
                emf.close();
            }
        }
    }
}
