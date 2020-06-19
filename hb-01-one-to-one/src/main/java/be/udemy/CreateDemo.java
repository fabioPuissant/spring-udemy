package be.udemy;

import be.udemy.entity.Instructor;
import be.udemy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CreateDemo {
    public static void main(String[] args) {
        courseBookWay();
        udemyWay();
    }

    private static void courseBookWay() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("udemy");
        EntityManager entityManager = factory.createEntityManager();
        try {
            Instructor instructor = new Instructor("Brad", "Traversy", "brad@traversy-media.com");
            InstructorDetail instructorDetail = new InstructorDetail(
                    "https://www.traversy-media.com/youtube",
                    "Web development"
            );
            instructor.setInstructorDetail(instructorDetail);
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
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
            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail(
                    "https://www.luv2code.com/youtube",
                    "Luv 2 code"
            );
            instructor.setInstructorDetail(instructorDetail);
            session.getTransaction().begin();
            session.save(instructor);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
