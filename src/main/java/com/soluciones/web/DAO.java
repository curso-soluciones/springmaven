package com.soluciones.web;



import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
public class DAO {
    

private static final ThreadLocal t1 = new ThreadLocal();
//private static final SessionFactory sessionFactory =new AnnotationConfiguration().configure().buildSessionFactory();
private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml").buildSessionFactory();
   public DAO() {  }
                    
    public static Session getSession() {
          Session session = (Session) DAO.t1.get();
           if (session == null) {
             session = sessionFactory.openSession();
            DAO.t1.set(session);
                  }
         return session;
        }
    
    protected  void begin() {
       getSession().beginTransaction();
    }
    
    protected   void commit() {
       getSession().getTransaction().commit();
    }
    
    protected  void rollback() {
       try {
         
           getSession().getTransaction().rollback();
           getSession().close();
            

             }catch(HibernateException e){   }
            DAO.t1.set(null);
            }

     public static void close() {
      getSession().close();
     DAO.t1.set(null);
     }

}