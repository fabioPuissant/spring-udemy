package be.udemy.get;

import be.udemy.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppGet {
    public static void main(String[] args) {
        theUdemyWay();
        theCourseBookWay();
    }

    private static void theCourseBookWay() {
        System.out.println("\n\n---- START COURSE BOOK WAY ----");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("udemy");
        EntityManager entityManager = factory.createEntityManager();

        try {
            var student = new Student("Testing-course-book", "Course-book-Student", "course.book@gmail.com");
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            var foundStudent = entityManager.find(Student.class, student.getId());
            System.out.format("#### Course book student: %s ####", foundStudent.toString());
        } catch (Exception exception){
            entityManager.getTransaction().rollback();
            exception.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
            System.out.println("---- END COURSE BOOK WAY ----");
        }
    }

    private static void theUdemyWay() {
        System.out.println("\n\n---- START UDEMY WAY ----");
        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            var student = new Student("Udemy", "Student", "udemy.student@gmail.com");
            session.getTransaction().begin();
            session.save(student);
            session.getTransaction().commit();
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            var found = session.get(Student.class, student.getId());
            session.getTransaction().commit();

            System.out.format("#### Course book student: %s ####", found.toString());

        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            sessionFactory.close();
            System.out.println("---- END UDEMY WAY ----");
        }
    }
}
