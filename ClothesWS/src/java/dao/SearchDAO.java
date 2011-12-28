package dao;

import entities.Clothes;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.PersistanceDBManager;


public class SearchDAO {
    

        private PersistanceDBManager dbManager;

        public SearchDAO() {
                this.dbManager = new PersistanceDBManager();
        }
        
//        public User authenticate(String email,String password) {
//            User new_user=null; 
//            EntityManager em=this.dbManager.getConnectionUpdate();
//            
//            Query q = em.createQuery("select c from User c where c.email = :email and c.password = :password");
//            q.setParameter("email", email);
//            q.setParameter("password", password);
//            
//            try{
//                new_user = (User)q.getSingleResult(); 
//            }
//            catch (javax.persistence.NoResultException ex ){
//                ex.getMessage();
//            }
//                
//            em.close();
//           
//            return new_user;
//        }
//        
//        public boolean register (User new_user){
//            EntityManager em=this.dbManager.getConnectionUpdate();
//            EntityTransaction tx = em.getTransaction();
//            
//            tx.begin();
//            em.persist(new_user);
//            tx.commit();
//            
//            em.close();
//            
//            return true;
//        }
        
        public void test (){
            EntityManager em=this.dbManager.getConnectionUpdate();

            Query q = em.createQuery("select c from Clothes c where c.name = :name");
            q.setParameter("name", "Chino Jeans");
            
            Clothes test=(Clothes) q.getSingleResult();
            em.close();
            
            System.out.println("teste: "+test.getName());
            

        }
//        
//        public boolean edit (User new_user){
//            EntityManager em=this.dbManager.getConnectionUpdate();
//            EntityTransaction tx = em.getTransaction();
//            
//            tx.begin();
//            em.merge(new_user);
//            tx.commit();
//            
//            em.close();
//            
//            return true;
//        }
//        
//        public User getUserById(int id){
//            User new_user=null; 
//            EntityManager em=this.dbManager.getConnectionUpdate();
//            Query q = em.createQuery("select c from User c where c.iduser = :iduser");
//            q.setParameter("iduser", id);
//            
//            try{
//                new_user = (User)q.getSingleResult(); 
//            }
//            catch (javax.persistence.NoResultException ex ){
//                ex.getMessage();              
//            }
//                
//            em.close();
//            return new_user;
//        }
}