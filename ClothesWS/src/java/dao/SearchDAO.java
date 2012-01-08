package dao;

import entities.Clothes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Hibernate;
import util.PersistanceDBManager;

public class SearchDAO {

    private PersistanceDBManager dbManager;

    public SearchDAO() {
        this.dbManager = new PersistanceDBManager();
    }

    public List<Clothes> search(String pattern) {

        EntityManager em = this.dbManager.getConnectionUpdate();
        Query qry = null;
        List<Clothes> list = null;

        try {
            String query = "select u from Clothes u where u.model LIKE '%";
            query += pattern;
            query += "%'";
            qry = em.createQuery(query);
            list = qry.getResultList();


        } finally {
            em.close();
        }


        Hibernate.initialize(list);



        return list;

    }
}