/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.ap.hibernate.Util;

import org.hibernate.Hibernate;
import org.hibernate.Session;  
import static org.hibernate.cfg.AvailableSettings.URL;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Levi
 */
public class AccPlanUtil {

  private static SessionFactory sessionFactory;
private static final String CONFIG_FILE = "accplan.cfg.xml";

private AccPlanUtil() { 
}

static { 
    Configuration cfg = new AnnotationConfiguration().configure(AccPlanUtil.class.getClassLoader().getResource(CONFIG_FILE));
    sessionFactory = cfg.buildSessionFactory();
}
 
public static SessionFactory getSessionFactory() {
    return sessionFactory;
} 
public static Session getSession() throws HibernateException {
    return AccPlanUtil.sessionFactory.openSession();
}
 
public void shutdown() {
    AccPlanUtil.sessionFactory.getCurrentSession().close();
    AccPlanUtil.sessionFactory.close();
}
}
