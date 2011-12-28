/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.SearchDAO;


/**
 *
 * @author psychok7
 */
public class SearchBean {

    
    public SearchBean() {
    }
    
//    public boolean authenticate(String email, String password) {
//        this.user = new UserDAO().authenticate(email, password);
//        if (this.user != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void test(){
        new SearchDAO().test();
    }

    
    
}
