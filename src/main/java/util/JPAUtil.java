package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("GestaoEventos");

    private JPAUtil() {
    }

    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    public static void closeFactory() {
        if (EMF.isOpen())
            EMF.close();
    }
}
