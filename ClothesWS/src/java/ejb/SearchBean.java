/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.SearchDAO;
import entities.Clothes;
import java.util.List;

/**
 *
 * @author psychok7
 */
public class SearchBean {

    public SearchBean() {
    }

    public List<Clothes> search(String pattern) {
        return new SearchDAO().search(pattern);
    }
}
