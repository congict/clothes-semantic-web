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

    public List<Clothes> getAllClothes() {
        EntityManager em = this.dbManager.getConnectionUpdate();
        Query q = em.createQuery("from Clothes");
        List<Clothes> list = q.getResultList();

        em.close();

        Hibernate.initialize(list);

        return list;
    }

    

    
    
    public Clothes searchByID(int id) {

        EntityManager em = this.dbManager.getConnectionUpdate();
        Clothes c = em.find(Clothes.class, id);
        em.close();
        return c;
        

    }
    
//    public List<Clothes> search(String pattern) {
//
//        EntityManager em = this.dbManager.getConnectionUpdate();
//        Query qry = null;
//        List<Clothes> list = null;
//        
//
//        try {
//            String query = "select u from Clothes u where u.model LIKE '%";
//            query += pattern;
//            query += "%'";
//            qry = em.createQuery(query);
//            list = (List<Clothes>) qry.getResultList();
//
//
//        } finally {
//            em.close();
//        }
//
//
//        Hibernate.initialize(list);
//
//
//
//        return list;
//
//    }
}