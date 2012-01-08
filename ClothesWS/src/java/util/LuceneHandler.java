/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import ejb.SearchBean;
import entities.Clothes;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;

/**
 *
 * @author psychok7
 */
public class LuceneHandler {

    private StandardAnalyzer analyzer;
    private Directory index;
    private int hitsPerPage = 10;
    private List<Clothes> clothes;
    private List<Clothes> clothes_result;

    public LuceneHandler() {
        clothes = new SearchBean().getAllClothes();
        init();
    }

    private void init() {
        // 0. Specify the analyzer for tokenizing text.
        //    The same analyzer should be used for indexing and searching
        analyzer = new StandardAnalyzer(Version.LUCENE_34);
        // 1. create the index
        index = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_34, analyzer);

        IndexWriter w = null;
        try {
            w = new IndexWriter(index, config);
        } catch (CorruptIndexException ex) {
            Logger.getLogger(LuceneHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LockObtainFailedException ex) {
            Logger.getLogger(LuceneHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LuceneHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Clothes c : clothes) {

            try {
                
                addDoc(w, c);

            } catch (IOException ex) {
                Logger.getLogger(LuceneHandler.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        try {
            w.close();
        } catch (CorruptIndexException ex) {
            Logger.getLogger(LuceneHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LuceneHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void addDoc(IndexWriter w, Clothes c) throws IOException {
        Document doc = new Document();
        doc.add(new Field("title", c.getModel(), Field.Store.YES, Field.Index.ANALYZED));
        doc.add(new Field("id", Integer.toString(c.getIdclothes()), Field.Store.YES, Field.Index.ANALYZED));
        doc.add(new Field("content", c.getModel() + " " + c.getCategory() + " " + c.getColor() + " " + c.getComposition() + " " + c.getSubcategory() + " " + c.getIdclothes() + " " + c.getPrice(), Field.Store.YES, Field.Index.ANALYZED));
        w.addDocument(doc);
    }

    public List<Clothes> searchLucene(String querystr) throws ParseException, IOException {

        // the "title" arg specifies the default field to use
        // when no field is explicitly specified in the query.
        Query q = new QueryParser(Version.LUCENE_34, "content", analyzer).parse(querystr);
        clothes_result = new ArrayList<Clothes>();

        // 3. search

        IndexSearcher searcher = new IndexSearcher(index, true);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        // 4. display results
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("title"));
            System.out.println((i + 1) + ". " + d.get("id"));

            for (Clothes c : clothes) {
                if (c.getIdclothes() == Integer.parseInt(d.get("id"))) 
                    clothes_result.add(c);
                
            }


        }


        // searcher can only be closed when there
        // is no need to access the documents any more. 
        searcher.close();

        return clothes_result;
    }
}
