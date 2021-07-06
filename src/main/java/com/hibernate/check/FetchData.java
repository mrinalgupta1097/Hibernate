package com.hibernate.check;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.openSession();

//        get student with student id using load method(throws object not found exception if not found)
        /*
        Load() method returns a proxy(which is object with ID) but without initializing other properties
        which are lazily initialized, so if needed properties can be fetched later as per demand.
        But the properties row does not exist in db, it will throw an ObjectNotFoundException.
         */
        Student student = session.load(Student.class, 103);
        System.out.println(student);

//        get address using get method(returns null if not found)
        /*
            Get() method always hit the database, returns a fully initialized object(never returns a proxy)
            and returns null if object not found.
            But once fetched the object is stored in the cache memory of session object and database will
            not be hit for second retrieval
         */
        Address address = session.get(Address.class,1);
        System.out.println(address.getStreet());


        session.close();
        factory.close();
    }



}
