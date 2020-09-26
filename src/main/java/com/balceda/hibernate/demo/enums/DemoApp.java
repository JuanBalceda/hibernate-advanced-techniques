package com.balceda.hibernate.demo.enums;

import com.balceda.hibernate.demo.enums.entity.Student;
import com.balceda.hibernate.demo.enums.util.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public class DemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            Student tempStudent = new Student("Juan", "Balceda", "juan@balceda.com");
            tempStudent.setStatus(Status.ACTIVE);

            Student tempStudent2 = new Student("Ilenia", "Terrel", "ilenia@terrel.com");
            tempStudent2.setStatus(Status.INACTIVE);

            session.beginTransaction();

            System.out.println("Saving...");
            session.persist(tempStudent);
            session.persist(tempStudent2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            System.out.println("retrieving...");
            Student student = session.get(Student.class, 1L);

            System.out.println(student);

            Student student2 = session.get(Student.class, 2L);

            System.out.println(student2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}
