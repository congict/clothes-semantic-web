/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        saveOWL();
    }

    private void init() {
        createShoes();
        // createPants();
    }

    private void createShoes() {
        OntClass shoes = model.getOntClass(NamedSpace + "Shoes");
        OntClass size = model.getOntClass(NamedSpace + "Size");
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");


        Individual PatentLeatherOxford = model.createIndividual(NamedSpace + "Patent_Leather_Oxford", shoes);

        Property hasSize = model.getProperty(NamedSpace + "hasSize");
        Property hasColor = model.getProperty(NamedSpace + "hasColor");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");

        PatentLeatherOxford.addProperty(hasSize, model.createIndividual(NamedSpace + "38", size));
        PatentLeatherOxford.addProperty(hasColor, model.createIndividual(NamedSpace + "blue", color));
        PatentLeatherOxford.addProperty(hasMaterial, model.createIndividual(NamedSpace + "cotton", material));

        iterateStatement(PatentLeatherOxford, hasColor);
//
    }

    private void createPants() {
    }

    
    
    private void iterateStatement(Individual ind, Property prop) {
        StmtIterator x = ind.listProperties(prop);

        while (x.hasNext()) {
            System.out.println("teste" + x.next());
        }
    }

    private void saveOWL() {
        try {
            model.write(new FileOutputStream(new File("clothes.owl")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PopulateOntology.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new PopulateOntology();
    }
}
