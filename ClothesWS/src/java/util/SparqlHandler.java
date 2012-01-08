package util;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SparqlHandler {

    OntModel model;

    public SparqlHandler() {
        search(null);
    }

    public void search(String pattern) {

        // Create an empty in-memory model and populate it from the graph
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:clothes.owl");

        Query query = null;
        String bigShoes =
                "PREFIX c: <http://www.clothes.pt/ontologies/clothes.owl#> "
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd:	<http://www.w3.org/2001/XMLSchema#>"
                
                + "SELECT ?d"
                + "WHERE {"                
                + "    ?clothes c:Size_Data ?d . }";
 
        //        + "     }";
        
         query = QueryFactory.create(bigShoes);
        
       
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();

        // Output query results	
        //ResultSetFormatter.out(System.out, results, query);
        while (results.hasNext()){
            QuerySolution nextSolution = results.nextSolution();
            System.out.println(nextSolution.toString());
        }
        

        // Important - free up resources used running the query
        qe.close();

    }
    
    
    public static void main(String args[]) {
        new SparqlHandler();
    }
}
