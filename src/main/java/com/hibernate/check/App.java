package com.hibernate.check;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class App {

//    get session
    static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    static Session session = factory.openSession();

    public static void saveObject(Student student){
//        begin transaction
        session.beginTransaction();
//        save object
        session.save(student);
//        commit and close transaction
        session.getTransaction().commit();

    }

    public static void saveAddressObject(Address address){
        //        begin transaction
        session.beginTransaction();
        //        save object
        session.save(address);
        //        commit
        session.getTransaction().commit();

    }
    public static void main(String[] args) throws IOException {
        System.out.println("started");


//        creating student
        Student student = new Student();
        student.setId(103);
        student.setName("Barry");
        student.setCity("LA");
        System.out.println(student);

//        creating address
        Address address = new Address();
        address.setCity("DELHI");
        address.setStreet("street1");
        address.setDate(new Date());
        address.setOpen(true);
        address.setX(1234.23);
//        reading stream
        FileInputStream fis = new FileInputStream("src/main/resources/pic.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);


        saveObject(student);
        saveAddressObject(address);
        session.close();
        System.out.println("done!");


    }
}
