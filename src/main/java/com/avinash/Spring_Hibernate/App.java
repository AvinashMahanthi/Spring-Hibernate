package com.avinash.Spring_Hibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class App 
{
    public static void main( String[] args )
    {
    	Laptop laptop = new Laptop();
    	laptop.setLid(103);
    	laptop.setLname("Dell");
    	
    	
    	Student s = new Student();
    	s.setName("Vivek");
    	s.setRollno(1244);
    	s.setMarks(999);
    	s.getLaptop().add(laptop);
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(s);
        tx.commit();
        session.close();
  
//      Student s1 = session1.get(Student.class, 1240);
//      System.out.println(s1.getName());
        
//        Session session2 = sf.openSession();
//        Transaction tx1 = session2.beginTransaction();
//        Student se = session2.get(Student.class, 1240);
//        System.out.println(se.getName());
//        tx1.commit();
//        session2.close();
//        session2.save(s);
//        Collection<Laptop> laps = s1.getLaps();
        
        
//        session.save(laptop);
//        session2.save(s);
        
        
        
//        sf.close();
        
    }
}
