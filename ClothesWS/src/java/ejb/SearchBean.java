/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.SearchDAO;
import entities.Clothes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.queryParser.ParseException;
import util.LuceneHandler;

/**
 *
 * @author psychok7
 */
public class SearchBean {

    public SearchBean() {
    }

    public List <Clothes> search(String pattern) {
        try {
            return new LuceneHandler().searchLucene(pattern);
        } catch (ParseException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Clothes> getAllClothes() {
        return new SearchDAO().getAllClothes();
    }
}
