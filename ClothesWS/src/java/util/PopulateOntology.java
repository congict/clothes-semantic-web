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
        //saveOWL();
    }

    private void init() {
        createShoes("Patent_Leather_Oxford_Shoe","38","blue","cotton");
        createPants("Patent_Leather_Oxford_Shoe","38","blue","cotton","jeans");
        createTie("Wide_Check_Tie","blue","cotton");
    }

    private void createShoes(String indname,String dbsize,String dbcolor,String dbmaterial) {
        OntClass shoes = model.getOntClass(NamedSpace + "Shoes");
        OntClass size = model.getOntClass(NamedSpace + "Size");
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");

        Individual temp = model.createIndividual(NamedSpace + indname, shoes);

        Property hasSize = model.getProperty(NamedSpace + "hasSize");
        Property hasColor = model.getProperty(NamedSpace + "hasColor");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");

        temp.addProperty(hasSize, model.createIndividual(NamedSpace + dbsize, size));
        temp.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        temp.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));
   

        //       iterateStatement(temp, hasColor);
//
    }

    private void createPants(String indname,String dbsize,String dbcolor,String dbmaterial,String dbclass) {
        OntClass pants = model.getOntClass(NamedSpace + dbclass);
        OntClass size = model.getOntClass(NamedSpace + "Size");
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");

        Individual OrangeThreadJeans = model.createIndividual(NamedSpace + "Orange_Thread_Jeans", pants);

        Property hasSize = model.getProperty(NamedSpace + "hasSize");
        Property hasColor = model.getProperty(NamedSpace + "hasColor");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");

        OrangeThreadJeans.addProperty(hasSize, model.createIndividual(NamedSpace + dbsize, size));
        OrangeThreadJeans.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        OrangeThreadJeans.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));


    }

    private void createTie(String indname,String dbcolor,String dbmaterial) {
        OntClass tie = model.getOntClass(NamedSpace + "Tie");
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");
        Individual WideCheckTie = model.createIndividual(NamedSpace + indname, tie);
        Property hasColor = model.getProperty(NamedSpace + "hasColor");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");
        WideCheckTie.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        WideCheckTie.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));
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
