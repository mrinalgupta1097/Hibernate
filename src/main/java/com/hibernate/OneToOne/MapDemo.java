package com.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

//        creating question
        Question question1 = new Question();
        question1.setQuestion("What is Java?");
        question1.setQuestionId(1212);

//        creating answer object
        Answer answer1 = new Answer();
        answer1.setAnswerId(343);
        answer1.setAnswer("Java is a object oriented programming language");
        answer1.setQuestion(question1);
        question1.setAnswer(answer1);

        //        creating question2
        Question question2 = new Question();
        question2.setQuestion("What is Collection Framework?");
        question2.setQuestionId(242);

//        creating answer2 object
        Answer answer2 = new Answer();
        answer2.setAnswerId(344);
        answer2.setAnswer("API to work with collection objects in Java");
        answer2.setQuestion(question2);
        question2.setAnswer(answer2);

//        Session open and begin transaction
        Session session = factory.openSession();
        session.beginTransaction();

//        save object and commit
        session.save(question1);
        session.save(question2);
        session.save(answer1);
        session.save(answer2);
        session.getTransaction().commit();
        
//        fetch object
        var questionTemp = session.get(Question.class, 242);
        System.out.println(questionTemp);
        System.out.println(questionTemp.getAnswer().getAnswer());

//        close session and factory
        session.close();
        factory.close();
    }
}
