package com.luv2code.hibernate;

import com.luv2code.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // by default, hibernate will look for a file named "hibernate.cfg.xml"
                                                // in classpath (src-folder)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Student tempStudent = new Student("Fabio", "Puissant", "fabio.puissant@hotmail.com");

            // start transaction
            session.beginTransaction();

            // save the student
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();

        } finally {
            factory.close();
        }
    }
}
