package java7_3.dao;

import datasource.MariaDbJpaConnection;
import entity.Currency;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CurrencyJpaDao {

    public List<Currency> findAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.createQuery("select c from Currency c", Currency.class)
                .getResultList();
    }

    public Currency find(String abbreviation) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.find(Currency.class, abbreviation);
    }

    public void persist(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }
}


