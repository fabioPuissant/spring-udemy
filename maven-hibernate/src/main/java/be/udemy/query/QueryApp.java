package be.udemy.query;

import be.udemy.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Stream;

public class QueryApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            findAllStudentsUdemyWay(session);
            session = sessionFactory.getCurrentSession();
            findStudentWithDoeAsLastName(session);



        } finally {
           if(session != null){
               session.close();
           }
           if(sessionFactory != null){
               sessionFactory.close();
           }
        }
    }

    private static void findStudentWithDoeAsLastName(Session session) {

        session.getTransaction().begin();
        List<Student> student = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
        Stream.of(student).forEach(System.out::println);
        session.getTransaction().commit();

    }

    private static void findAllStudentsUdemyWay(Session session) {
        // begin transaction
        session.getTransaction().begin();

        // query the students
        List<Student> theStudents = session.createQuery("from Student")
                .getResultList();

        // display the Students
        Stream.of(theStudents).map((s)-> s.toString()+"\n").forEach(System.out::println);
        session.getTransaction().commit();
    }
}
