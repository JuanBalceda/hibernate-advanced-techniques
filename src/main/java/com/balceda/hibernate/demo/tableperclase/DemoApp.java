package com.balceda.hibernate.demo.tableperclase;

import com.balceda.hibernate.demo.tableperclase.entity.Student;
import com.balceda.hibernate.demo.tableperclase.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            Student student = new Student("Ilenia", "Terrel", "ilenia@terrel.com", "Java SE 15");
            Instructor instructor = new Instructor("Juan", "Balceda", "juan@balceda.com", 30000.00);

            session.beginTransaction();

            System.out.println("Saving...");
            session.persist(student);
            session.persist(instructor);

            session.getTransaction().commit();
            System.out.println("Done!");
        }


        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            System.out.println("retrieving...");
            Student student = session.get(Student.class, 1L);
            System.out.println(student);

            Instructor instructor = session.get(Instructor.class, 2L);
            System.out.println(instructor);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
