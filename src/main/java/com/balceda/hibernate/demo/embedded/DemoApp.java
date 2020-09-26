package com.balceda.hibernate.demo.embedded;

import com.balceda.hibernate.demo.embedded.entity.Address;
import com.balceda.hibernate.demo.embedded.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            Student tempStudent = new Student("Juan", "Balceda", "juan@balceda.com");

            Address homeAddress = new Address("Carrer Cartagena", "Barcelona", "08013");
            tempStudent.setHomeAddress(homeAddress);

            Address billingAddress = new Address("Av. Guipuzcua", "Barcelona", "08020");
            tempStudent.setBillingAddress(billingAddress);

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

            System.out.println(student);
            System.out.println(student.getHomeAddress());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
