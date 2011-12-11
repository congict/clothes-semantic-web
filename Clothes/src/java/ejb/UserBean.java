/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.UserDAO;
import util.User;

/**
 *
 * @author psychok7
 */
public class UserBean {
    private User user;
    
    public UserBean() {
    }
    
    public boolean authenticate(String email, String password) {
        this.user = new UserDAO().authenticate(email, password);
        if (this.user != null) {
            return true;
        } else {
            return false;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
