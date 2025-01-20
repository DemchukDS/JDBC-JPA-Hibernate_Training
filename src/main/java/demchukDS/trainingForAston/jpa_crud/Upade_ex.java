package demchukDS.trainingForAston.jpa_crud;

import demchukDS.trainingForAston.entity.Student;
import jakarta.persistence.*;

public class Upade_ex {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("postgres@localhost");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        Student student = null;

        try{
            transaction.begin();

            student = em.find(Student.class, 6);
            student.setAvgGrade(8.2);

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
