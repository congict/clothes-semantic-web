package util;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import dao.SearchDAO;
import entities.Clothes;
import java.util.ArrayList;
import java.util.Iterator;

public class SparqlHandler {

    private OntModel model;
    private String NamedSpace = "http://www.clothes.pt/ontologies/clothes.owl#";
    private ArrayList<Clothes> searchResults = new ArrayList<Clothes>();
    private ArrayList<Clothes> suggestionsResults = new ArrayList<Clothes>();

    public SparqlHandler() {
         // Create an empty in-memory model and populate it from the graph
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:clothes.owl");
        this.search("small shoes for man");
        
    }
    
    
     public void search(String pattern) {
        pattern.trim();

        if (pattern.equalsIgnoreCase("big shoes")) {
            System.out.println("in big Shoes !!!");
            this.searchResults = bigShoes();
            this.suggestionsResults = bigPants();
        }
        
        else if (pattern.equalsIgnoreCase("big pants for woman")) {
            this.searchResults = bigPantsForWoman();
            this.suggestionsResults = bigPantsForMan();
        }

        else if (pattern.equalsIgnoreCase("big pants for man")) {
            this.searchResults = bigPantsForMan();
            this.suggestionsResults = bigShoes();
        }

        else if (pattern.equalsIgnoreCase("small shoes for man")) {
            this.searchResults = smallShoesForMan();
            this.suggestionsResults = bigPantsForMan();
        }
        else if (pattern.equalsIgnoreCase("small shoes")) {
            this.searchResults = smallShoes();
            this.suggestionsResults = smallPants();
        }

    }

    private ArrayList<Clothes> bigPants() {
        Query query = null;
        String stringQuery =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data > 42) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:Pants . "
                + "  }";

        query = QueryFactory.create(stringQuery);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;

    }

    
    private ArrayList<Clothes> smallPants() {
        Query query = null;
        String stringQuery =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data < 40) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:Pants . "
                + "  }";

        query = QueryFactory.create(stringQuery);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;

    }
    
    private ArrayList<Clothes> bigShoes() {
        System.out.println("Someting : ");
        Query query = null;
        String stringQuery =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data > 42) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:Shoes . "
                + "  }";

        query = QueryFactory.create(stringQuery);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;

    }

    private ArrayList<Clothes> smallShoes() {
        Query query = null;
        String bigShoes =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data < 40) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:Shoes . "
                + "  }";

        query = QueryFactory.create(bigShoes);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;
    }

    private ArrayList<Clothes> bigPantsForWoman() {
        Query query = null;
        String stringQuery =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data > 42) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:WomensJeans . "
                + "  }";

        query = QueryFactory.create(stringQuery);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;
    }

    private ArrayList<Clothes> bigPantsForMan() {
        Query query = null;
        String stringQuery =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data < 42) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:MensJeans . "
                + "  }";

        query = QueryFactory.create(stringQuery);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;
    }

    private ArrayList<Clothes> smallShoesForMan() {
        Query query = null;
        String stringQuery =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
                + "SELECT ?clothes ?size ?data ?id "
                + " WHERE {"
                + " ?clothes c:SQL_ID_DATA ?id . "
                + " ?clothes c:hasSize ?size . "
                + " ?size rdf:type c:Size . "
                + " ?size c:Size_Data ?data . "
                + " FILTER(?data < 40) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:WensJeans . "
                + "  }";

        query = QueryFactory.create(stringQuery);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        ArrayList<Clothes> sendResults = sendResults(results);
        qe.close();
        return sendResults;
    }

    public ArrayList<Clothes> sendResults(ResultSet results) {
        ArrayList<Clothes> clothes = new ArrayList<Clothes>();
        while (results.hasNext()) {
            QuerySolution nextSolution = results.nextSolution();
            Iterator<String> varNames = nextSolution.varNames();
            RDFNode data = nextSolution.get("id");
            if (data.isLiteral()) {
                System.out.println("ID " + data.asLiteral().getString());
                int id = Integer.parseInt(data.asLiteral().getString());
                clothes.add(new SearchDAO().searchByID(id));
            }
        }
        for (Clothes c : clothes){
            System.out.println(c.getModel() + " !!!");
        }
        return clothes;
    }

    public ArrayList<Clothes> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<Clothes> searchResults) {
        this.searchResults = searchResults;
    }

    public ArrayList<Clothes> getSuggestionsResults() {
        return suggestionsResults;
    }

    public void setSuggestionsResults(ArrayList<Clothes> suggestionsResults) {
        this.suggestionsResults = suggestionsResults;
    }

    
    
    public String getNamedSpace() {
        return NamedSpace;
    }

    public void setNamedSpace(String NamedSpace) {
        this.NamedSpace = NamedSpace;
    }

    public OntModel getModel() {
        return model;
    }

    public void setModel(OntModel model) {
        this.model = model;
    }

    public ArrayList<Clothes> getSearchReults() {
        return searchResults;
    }

    public void setSearchReults(ArrayList<Clothes> searchReults) {
        this.searchResults = searchReults;
    }

    public static void main(String args[]) {
        SparqlHandler sparqlHandler = new SparqlHandler();
    }
}
// Output query results	
//ResultSetFormatter.out(System.out, results, query);
//            while (varNames.hasNext()) {
//                String next = varNames.next();
//                System.out.println("data:  " + data.toString());
//
//            }
//            if (data.isURIResource()) {
//                StmtIterator listProperties = data.asResource().listProperties();
//
//                ArrayList<String> array = new ArrayList<String>();
//                while (listProperties.hasNext()) {
//                    Triple asTriple = listProperties.nextStatement().asTriple();
//
//                    if (asTriple.getObject().isLiteral()) {
//                        array.add(asTriple.getObject().getLiteral().getValue().toString());
//                        System.out.println(asTriple.getObject().getLiteral().getValue().toString());
//                    } else {
//                        array.add(asTriple.getObject().getLocalName());
//                        System.out.println(asTriple.getObject().getLocalName());
//                    }
//
//
//                }
//
//                Clothes clothes = new Clothes();
//                clothes.setSubcategory(array.get(0));
//                clothes.setColor(array.get(1));
//                clothes.setComposition(array.get(2));
//                clothes.setPrice(Float.parseFloat(array.get(3)));
//                clothes.setModel(array.get(4));
//
//                //System.out.println(clothes.getSubcategory());
//
//
//
//
//
//
//
//            }
//    System.out.println();
//System.out.println(model_data.toString());
//            StmtIterator listProperties = nextSolution.get("clothes").asResource().listProperties();
//            while (listProperties.hasNext()) {
//                Statement nextStatement = listProperties.nextStatement();
//                System.out.println(nextStatement);
//
//            }

