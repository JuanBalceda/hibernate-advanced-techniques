package com.balceda.hibernate.demo;

import com.balceda.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            Student tempStudent = new Student("Juan", "Balceda", "juan@balceda.com");
            List<String> images = tempStudent.getImages();

            images.add("image1.jpg");
            images.add("image2.jpg");
            images.add("image3.jpg");
            images.add("image4.jpg");

            session.beginTransaction();

            System.out.println("Saving...");
            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
