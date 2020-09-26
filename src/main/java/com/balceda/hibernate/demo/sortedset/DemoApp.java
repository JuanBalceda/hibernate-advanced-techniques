package com.balceda.hibernate.demo.sortedset;

import com.balceda.hibernate.demo.sortedset.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class DemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            Student tempStudent = new Student("Juan", "Balceda", "juan@balceda.com");
            Set<String> images = tempStudent.getImages();

            images.add("image1.jpg");
            images.add("image2.jpg");
            images.add("image3.jpg");
            images.add("image4.jpg");
            images.add("image4.jpg"); // Duplicate filtered by HashSet
            images.add("image5.jpg");
            images.add("image5.jpg"); // Duplicate filtered by HashSet


            session.beginTransaction();

            System.out.println("Saving...");
            session.persist(tempStudent);

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

            System.out.println(student.getImages());
            System.out.println("Done!");
        }
    }
}
