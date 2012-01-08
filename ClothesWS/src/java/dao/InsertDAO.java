package dao;

import entities.Clothes;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.PersistanceDBManager;

public class InsertDAO {

    private PersistanceDBManager dbManager;

    public InsertDAO() {
        this.dbManager = new PersistanceDBManager();
    }

    public boolean insertProduct(Clothes c) {
        EntityManager em = this.dbManager.getConnectionUpdate();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(c);
        tx.commit();

        em.close();
        return true;
    }
}
