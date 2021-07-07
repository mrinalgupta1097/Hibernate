package com.hibernate.OneToMany;

import com.hibernate.OneToOne.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

////        creating question
//        QuestionOneToMany question1 = new QuestionOneToMany();
//        question1.setQuestion("What is Java?");
//        question1.setQuestionId(1212);
//
////        creating answer objects
//        AnswerOneToMany answer1 = new AnswerOneToMany();
//        answer1.setAnswerId(341);
//        answer1.setAnswer("Java is a object oriented programming language");
//        answer1.setQuestion(question1);
//
//
//        AnswerOneToMany answer2 = new AnswerOneToMany();
//        answer2.setAnswerId(342);
//        answer2.setAnswer("Majorly used to make web applications.");
//        answer2.setQuestion(question1);
//
//        AnswerOneToMany answer3 = new AnswerOneToMany();
//        answer3.setAnswerId(343);
//        answer3.setAnswer("Spring Framework is used to make web applications. ");
//        answer3.setQuestion(question1);
//
//        List<AnswerOneToMany> answerOneToManyList = new ArrayList<>();
//        answerOneToManyList.add(answer1);
//        answerOneToManyList.add(answer2);
//        answerOneToManyList.add(answer3);
//
//
//        question1.setAnswerList(answerOneToManyList);


//        Session open and begin transaction
        Session session = factory.openSession();
        session.beginTransaction();

////        save object and commit
//        session.save(question1);
//        session.save(answer1);
//        session.save(answer2);
//        session.save(answer3);

        QuestionOneToMany questionOneToMany = session.get(QuestionOneToMany.class, 1212);
        System.out.println(questionOneToMany.getQuestion());

        questionOneToMany.getAnswerList().stream().forEach(answer -> System.out.println(answer.getAnswer()));
        session.getTransaction().commit();
        
////        fetch object
//        var questionTemp = session.get(QuestionOneToMany.class, 242);
//        System.out.println(questionTemp);
//        System.out.println(questionTemp.getAnswer().getAnswer());

//        close session and factory
        session.close();
        factory.close();
    }
}
