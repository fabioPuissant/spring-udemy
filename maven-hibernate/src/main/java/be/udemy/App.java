package be.udemy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            session.save(new Student("fabio",
                    "puissant",
                    "fabio.p@gmail.com"));
            session.save(new Student("john",
                    "doe",
                    "john.doe@gmail.com"));
            session.save(new Student("marry",
                    "Mc Donald",
                    "mc.marry@gmail.com"));
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            factory.close();
        }
    }
}
