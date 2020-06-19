package be.udemy;

import be.udemy.entity.Instructor;
import be.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class DeleteDemo {
    public static void main(String[] args) {
        courseBookWay();
        udemyWay();
    }

    private static void courseBookWay() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("udemy");
        EntityManager entityManager = factory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            TypedQuery<Instructor> instructorTypedQuery = entityManager
                    .createQuery(
                            "select i from Instructor as i WHERE LOWER(i.firstName) = :firstname",
                            Instructor.class);
            instructorTypedQuery.setParameter("firstname", "brad");
            Instructor foundBrad = instructorTypedQuery.getSingleResult();
            entityManager.remove(foundBrad);
            entityManager.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
            factory.close();
        }
    }

    private static void udemyWay() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.getTransaction().begin();
            Instructor instructor = session.createQuery("from Instructor i WHERE lower(i.firstName) = 'chad'",
                    Instructor.class).getSingleResult();
            session.delete(instructor);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
