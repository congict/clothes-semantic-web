/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 *
 * @author psychok7
 */
public class PopulateOntology {

    public PopulateOntology() {
    }

    private void init() {
        Model model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
        model.read("file:movieontology.owl");

    }
}
