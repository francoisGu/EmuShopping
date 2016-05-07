package com.litaos.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by litaoshen on 9/09/2015.
 */
public class MySessionFactory {
    @Autowired
    private static final SessionFactory mySessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
//            configuration.configure();
            File file = new File("/Users/litaoshen/Google Drive/UniversityOfMelbourne/Software_Architecture/Assignments/code/EmuShopping/src/main/resources/hibernate.cfg.xml");
            configuration.configure(file);
//            configuration.configure("hibernate.cdf.xml");
//            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            mySessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return mySessionFactory.openSession();
    }

}
