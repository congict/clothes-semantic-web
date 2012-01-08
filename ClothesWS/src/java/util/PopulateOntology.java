/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import ejb.SearchBean;
import entities.Clothes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psychok7
 */
public class PopulateOntology {

    private String NamedSpace = "http://www.clothes.pt/ontologies/clothes.owl#";
    private OntModel model;
    private List <Clothes> clothes;

    public PopulateOntology() {
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:clothes.owl");
        clothes= new SearchBean().getAllClothes();
        init();
        saveOWL();
    }

    private void init() {
        
        for (Clothes c: clothes){
            if(c.getCategory().equalsIgnoreCase("pants"))
                createPants(c.getModel().replace(" ", "_"),Integer.toString(c.getSize()).replace(" ", "_"),c.getColor().replace(" ", "_"),c.getComposition().replace(" ", "_"),c.getSubcategory().replace(" ", "_"),c.getPrice());
            else if (c.getCategory().equalsIgnoreCase("shoes"))
                createShoes(c.getModel().replace(" ", "_"),Integer.toString(c.getSize()).replace(" ", "_"),c.getColor().replace(" ", "_"),c.getComposition().replace(" ", "_"),c.getSubcategory().replace(" ", "_"),c.getPrice());
            else if (c.getCategory().equalsIgnoreCase("tie"))
                createTie(c.getModel().replace(" ", "_"),c.getColor().replace(" ", "_"),c.getComposition().replace(" ", "_"),c.getSubcategory().replace(" ", "_"),c.getPrice());
        }
    }

    private void createShoes(String indname,String dbsize,String dbcolor,String dbmaterial,String dbclass,float dbprice) {
        System.out.println("dbclass: "+dbclass);
        OntClass shoes = model.getOntClass(NamedSpace + dbclass);
        OntClass size = model.getOntClass(NamedSpace + "Size");
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");

        Individual temp = model.createIndividual(NamedSpace + indname, shoes);

        Property hasSize = model.getProperty(NamedSpace + "hasSize");
        Property hasColor = model.getProperty(NamedSpace + "hasColor");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");
        
        Property SizeData = model.getProperty(NamedSpace + "Size_Data");
        Property PriceData = model.getProperty(NamedSpace + "Price_Data");
        Property MaterialData = model.getProperty(NamedSpace + "Material_Data");
        Property ColourData = model.getProperty(NamedSpace + "Colour_Data");
        

        temp.addProperty(hasSize, model.createIndividual(NamedSpace + dbsize, size));
        temp.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        temp.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));
        
        temp.addLiteral(SizeData, dbsize);
        temp.addLiteral(ColourData, dbcolor);
        temp.addLiteral(MaterialData, dbmaterial);
        temp.addLiteral(PriceData,dbprice);
        
        
   

        //       iterateStatement(temp, hasColor);
//
    }

    private void createPants(String indname,String dbsize,String dbcolor,String dbmaterial,String dbclass,float dbprice) {
        System.out.println("dbclass: "+dbclass);
        OntClass pants = model.getOntClass(NamedSpace + dbclass);
        OntClass size = model.getOntClass(NamedSpace + "Size");
        OntClass color = model.getOntClass(NamedSpace + "Colour");
        OntClass material = model.getOntClass(NamedSpace + "Material");

        Individual temp = model.createIndividual(NamedSpace + indname, pants);

        Property hasSize = model.getProperty(NamedSpace + "hasSize");
        Property hasColor = model.getProperty(NamedSpace + "hasColour");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");

        Property SizeData = model.getProperty(NamedSpace + "Size_Data");
        Property PriceData = model.getProperty(NamedSpace + "Price_Data");
        Property MaterialData = model.getProperty(NamedSpace + "Material_Data");
        Property ColourData = model.getProperty(NamedSpace + "Colour_Data");
        

        temp.addProperty(hasSize, model.createIndividual(NamedSpace + dbsize, size));
        temp.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        temp.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));
        
        temp.addLiteral(SizeData, dbsize);
        temp.addLiteral(ColourData, dbcolor);
        temp.addLiteral(MaterialData, dbmaterial);
        temp.addLiteral(PriceData,dbprice);


    }

    private void createTie(String indname,String dbcolor,String dbmaterial,String dbclass,float dbprice) {
        System.out.println("dbclass: "+dbclass);
        OntClass tie = model.getOntClass(NamedSpace + dbclass);
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");
        Individual temp = model.createIndividual(NamedSpace + indname, tie);
        Property hasColor = model.getProperty(NamedSpace + "hasColour");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");
        temp.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        temp.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));

        Property PriceData = model.getProperty(NamedSpace + "Price_Data");
        Property MaterialData = model.getProperty(NamedSpace + "Material_Data");
        Property ColourData = model.getProperty(NamedSpace + "Colour_Data");

        temp.addProperty(hasColor, model.createIndividual(NamedSpace + dbcolor, color));
        temp.addProperty(hasMaterial, model.createIndividual(NamedSpace + dbmaterial, material));
        
        temp.addLiteral(ColourData, dbcolor);
        temp.addLiteral(MaterialData, dbmaterial);
        temp.addLiteral(PriceData,dbprice);
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
