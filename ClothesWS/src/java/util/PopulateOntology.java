/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psychok7
 */
public class PopulateOntology {

    private String NamedSpace = "http://www.clothes.pt/ontologies/clothes.owl#";
    private OntModel model;

    public PopulateOntology() {
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:clothes.owl");
        init();
    }
    private void init(){
        createShoes();
       // createPants();
    }

    private void createShoes() {
        OntClass shoes = model.getOntClass(NamedSpace+"Shoes");
        Individual shoe0 = model.createIndividual(NamedSpace + "shoe0", shoes);
        Property hasSize =  model.getProperty(NamedSpace+"Size");
        Property hasColour =  model.getProperty(NamedSpace+"Colour");

      //  Restriction anonR = model.createRestriction( hasSize );
      //  anonR.asCardinalityRestriction().setCardinality(1);
        
        
        
        shoe0.addLiteral(hasSize, "45");
        shoe0.addLiteral(hasColour, "blacknigga");
        try {
            model.write(new FileOutputStream(new File("clothes.owl")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PopulateOntology.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("teste: " + shoe0.getPropertyValue(hasSize));
    }

    private void createPants() {
        OntClass pants = model.getOntClass("Pants");
        
        for (Iterator i = pants.listSubClasses(); i.hasNext(); ) {
            OntClass c = (OntClass) i.next();
            System.out.println("teste"+ c.getURI() );
        }
        
//        Individual shoe0 = model.createIndividual(NamedSpace + "shoe0", pants);
//        Property hasSize = model.getProperty("Size");
//        Property hasColour = model.getProperty("Colour");
//        shoe0.addLiteral(hasSize, "45");
//        shoe0.addLiteral(hasColour, "blacknigga");
//
//
//
//        System.out.println("teste: " + shoe0.getPropertyValue(hasSize));
    }

    public static void main(String args[]) {
        new PopulateOntology();
    }
}
