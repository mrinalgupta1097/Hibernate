package com.hibernate.OneToManyExercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyExerciseDriver {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

////        creating employee
//        Employee employee1 = new Employee();
//        employee1.setPhoneNo("7011615825");
//        employee1.setName("Navin");
//        employee1.setCity("Bangalore");
//        employee1.setEmailId("navin@gmail.com");
//
////        create services
//        ServicesCards servicesCard1 = new ServicesCards();
//        servicesCard1.setCompany("cred");
//        servicesCard1.setService("credit cards bill payment");
//        servicesCard1.setEmployee(employee1);
//
//        ServicesCards servicesCard2 = new ServicesCards();
//        servicesCard2.setCompany("SBI");
//        servicesCard2.setService("Debit Card");
//        servicesCard2.setEmployee(employee1);
//
//        ServicesCards servicesCard3 = new ServicesCards();
//        servicesCard3.setCompany("HDFC");
//        servicesCard3.setService("Credit Card");
//        servicesCard3.setEmployee(employee1);
//
//        ServicesCards servicesCard4 = new ServicesCards();
//        servicesCard4.setCompany("Big Bazaar");
//        servicesCard4.setService("Shopping Card");
//        servicesCard4.setEmployee(employee1);
//
//        List<ServicesCards> listOfCards = new ArrayList<>();
//        listOfCards.add(servicesCard1);
//        listOfCards.add(servicesCard2);
//        listOfCards.add(servicesCard3);
//        listOfCards.add(servicesCard4);
//
//        employee1.setServicesCards(listOfCards);
//        get session object and begin transaction
        Session session = factory.openSession();
        session.beginTransaction();

////        save employee and service cards adn commit
//        session.save(employee1);
        session.getTransaction().commit();

//        fetch details
        Employee fetchedEmployee = session.get(Employee.class, 1);
        fetchedEmployee.getServicesCards()
                .stream()
                .filter(card -> card.getCompany().equals("SBI"))
                .forEach(card -> System.out.println(card.getService()));
//        close session and factory
        session.close();
        factory.close();
    }
}
