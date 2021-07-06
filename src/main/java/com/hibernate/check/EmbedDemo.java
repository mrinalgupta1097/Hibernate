package com.hibernate.check;

import com.hibernate.entity.Certificate;
import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Embeddable;

public class EmbedDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
//      Student1
        Student student1 = new Student();
        student1.setId(14134);
        student1.setName("Amit Kumar");
        student1.setCity("Chandigarh");

        Certificate certificate = new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 months");
        student1.setCertificate(certificate);

//      Student2
        Student student2 = new Student();
        student2.setId(14136);
        student2.setName("Messi");
        student2.setCity("Barcelona");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Java");
        certificate2.setDuration("3 months");

        student2.setCertificate(certificate2);

//        open session
        Session session = factory.openSession();
//        begin transaction
        session.beginTransaction();
        session.save(student1);
        session.save(student2);
//        commit transaction
        session.getTransaction().commit();
//        close session
        session.close();
        factory.close();
    }
}
