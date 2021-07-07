package com.hibernate.OneToOneExercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DriverClass {
    public static void main(String[] args) {
//        Get session Factory Object
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

//        create a customer object
        Customer customer1 = new Customer();
        customer1.setAadharId(1001);
        customer1.setName("Aman Pandey");
        customer1.setCity("New Delhi");

//        create account object
        Account account1 = new Account();
        account1.setAccountNo(1001);
        account1.setBalance(1000.30);
        account1.setAccountType("savings");
        account1.setCustomer(customer1);
        customer1.setAccount(account1);

        //        Get session object
        Session session = factory.openSession();

//        open transaction and save object of both customer and account type
        session.beginTransaction();
        session.save(account1);
        session.save(customer1);


//        commit and close session and factory
        session.getTransaction().commit();
        session.close();
        factory.close();

    }
}
