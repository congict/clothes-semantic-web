package code;

import ejb.SearchBean;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class Search {
    private String inputQuery="Semantic Search";
    private boolean searchMade=false;

    

    public String getInputQuery() {
        return inputQuery;
    }

    public void setInputQuery(String inputQuery) {        
        this.inputQuery = inputQuery;
        System.out.println(this.inputQuery);
        
    }

    public Boolean getSearchMade() {
        return searchMade;
    }

    public void setSearchMade(Boolean searchMade) {
        System.out.println(searchMade);
        this.searchMade = searchMade;
    }
    
    
    public String showInput(){
        return this.inputQuery;
    }
    
    public void searchMade(){
        System.out.println("Method Invoked");
        this.searchMade=true;
        //do someting
                new SearchBean().test();
    }
    
    
    
}
