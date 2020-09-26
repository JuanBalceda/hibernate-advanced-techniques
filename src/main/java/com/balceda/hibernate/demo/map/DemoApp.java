package com.balceda.hibernate.demo.map;

import com.balceda.hibernate.demo.map.entity.Student;
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
            Map<String, String> images = tempStudent.getImages();

            images.put("image1.jpg", "Image 1");
            images.put("image2.jpg", "Image 2");
            images.put("image3.jpg", "Image 3");

            session.beginTransaction();

            System.out.println("Saving...");
            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
