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
    private List<Clothes> clothes;

    public PopulateOntology() {
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:old-clothes.owl");
        clothes = new SearchBean().getAllClothes();
        init();
        saveOWL();
    }

    private void init() {

        for (Clothes c : clothes) {
            if (c.getCategory().equalsIgnoreCase("tie")) {
                createClothes(c, false);
            }
            else { 
                createClothes(c,true);
             }
        }
    }

    private void createClothes(Clothes c, Boolean categoryHasSize) {

        OntClass subCategory = model.getOntClass(NamedSpace + c.getSubcategory().replaceAll(" ", "_"));
       
        OntClass color = model.getOntClass(NamedSpace + "Color");
        OntClass material = model.getOntClass(NamedSpace + "Material");
      
        Individual temp = model.createIndividual(NamedSpace + c.getModel().replace(" ", "_"),subCategory);
       
        Property hasColor = model.getProperty(NamedSpace + "hasColor");
        Property hasMaterial = model.getProperty(NamedSpace + "isMadeOf");
        
        Property ModelData = model.getProperty(NamedSpace + "Model_Data");      
        Property PriceData = model.getProperty(NamedSpace + "Price_Data");
        Property MaterialData = model.getProperty(NamedSpace + "Material_Data");
        Property ColourData = model.getProperty(NamedSpace + "Colour_Data");
        
        if (categoryHasSize){
            OntClass size = model.getOntClass(NamedSpace + "Size");
            Property hasSize = model.getProperty(NamedSpace + "hasSize");
            Property SizeData = model.getProperty(NamedSpace + "Size_Data");
            Individual indivSize = model.createIndividual(NamedSpace + c.getSize()+"", size);
            temp.addProperty(hasSize, indivSize);
            indivSize.addLiteral(SizeData, c.getSize());
        }
        
        Individual indivColor = model.createIndividual(NamedSpace + c.getColor().replace(" ","_"), color);
        Individual indivMaterial = model.createIndividual(NamedSpace + c.getComposition().replace(" ","_"), material);
                
        temp.addProperty(hasColor, indivColor);
        temp.addProperty(hasMaterial, indivMaterial);
                
        indivColor.addLiteral(ColourData, c.getColor());
        indivMaterial.addLiteral(MaterialData, c.getComposition());
        
        temp.addLiteral(PriceData, c.getPrice());
        temp.addLiteral(ModelData, c.getModel());

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
