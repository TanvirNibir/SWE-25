package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class MariaDbJpaConnection {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private MariaDbJpaConnection() {
    }

    public static EntityManager getInstance() {
        if (em == null) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}


