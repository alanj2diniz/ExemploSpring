/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posjava.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alan
 */
public class HibernateUtil {
    
    private static final String DEFAULT_EM = "ExemploSpringPU";
    private static EntityManagerFactory factory = null;

    public static void initFactory() {
        initFactory(DEFAULT_EM);
    }

    public static void initFactory(String entityManagerName) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(entityManagerName);
        }
    }

    public static EntityManager getEntityManager() {
        return getEntityManager(DEFAULT_EM);
    }

    public static EntityManager getEntityManager(String entityManagerName) {
        if (factory == null) {
            initFactory(entityManagerName);
        }
        return factory.createEntityManager();
    }

    public static void destroy() {
        if (factory != null) {
            factory.close();
        }
    }
    
}