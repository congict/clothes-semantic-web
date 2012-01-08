package code;

import ejb.SearchBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entities.Clothes;
import java.util.List;

@ManagedBean
@RequestScoped
public class Search {
    private String inputQuery="Semantic Search";
    private List<Clothes> clothes;
    private boolean searchMade=false;


    public String getInputQuery() {
        return inputQuery;
    }

    public void setInputQuery(String inputQuery) {        
        this.inputQuery = inputQuery;
        System.out.println(this.inputQuery);
        
    }

    public boolean getSearchMade() {
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
        this.searchMade=true;
        //do someting
        this.clothes=new SearchBean().search(inputQuery);
        
        for (Clothes c : this.clothes)
            System.out.println(c.toString());
            
    }

    /**
     * @return the clothes
     */
    public List<Clothes> getClothes() {
        return clothes;
    }

    /**
     * @param clothes the clothes to set
     */
    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }
    
    
    
}
