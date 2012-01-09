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
import util.SparqlHandler;

/**
 *
 * @author psychok7
 */
public class SearchBean {

    private ArrayList<Clothes> suggestions = new ArrayList<Clothes>();

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
    
    
    public ArrayList<Clothes> searchSparql(String pattern) {
        SparqlHandler sh = new SparqlHandler();
        sh.search(pattern);
        
        this.suggestions = sh.getSuggestionsResults();
        return sh.getSearchResults();
    }

    public ArrayList<Clothes> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(ArrayList<Clothes> suggestions) {
        this.suggestions = suggestions;
    }
    
    public List<Clothes> getAllClothes() {
        return new SearchDAO().getAllClothes();
    }
}
