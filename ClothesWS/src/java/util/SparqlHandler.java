package util;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Triple;
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
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import dao.SearchDAO;
import entities.Clothes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SparqlHandler {

    OntModel model;
    public String NamedSpace = "http://www.clothes.pt/ontologies/clothes.owl#";
    public ArrayList<Clothes> searchReults = new ArrayList<Clothes>();

    public SparqlHandler() {
        //search(null);
    }

    public void search(String pattern) {

        // Create an empty in-memory model and populate it from the graph
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:clothes.owl");

        
        if (pattern.equalsIgnoreCase("big shoes")){
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
                + " FILTER(?data > 42) . "
                + " ?clothes rdf:type ?type . "
                + " ?type rdfs:subClassOf* c:Shoes . "
                + "  }";

            query = QueryFactory.create(bigShoes);
              // Execute the query and obtain results
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet results = qe.execSelect();
            this.searchReults=sendResults(results);
            qe.close();
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







        // Important - free up resources used running the query
        

    }
    
    public ArrayList<Clothes> sendResults(ResultSet results){
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
        return clothes;
    }

    public static void main(String args[]) {
        SparqlHandler sparqlHandler = new SparqlHandler();
    }
}
