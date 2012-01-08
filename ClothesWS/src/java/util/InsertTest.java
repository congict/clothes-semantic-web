package util;

import dao.InsertDAO;
import entities.Clothes;

public class InsertTest {

    public static void main(String args[]) {
        Clothes c1 = new Clothes();
        c1.setGenre(true);
        c1.setCategory("pants");
        c1.setSubcategory("classicJeans");
        c1.setModel("Faded Chino Jeans");
        c1.setColor("dark blue");
        c1.setSize(38); //42
        c1.setComposition("cotton");
        c1.setImage("http://static.zara.net/photos//2011/I/0/2/p/6599/300/407/6599300407_1_1_4.jpg");
        c1.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c1);


        Clothes c2 = new Clothes();
        c2.setGenre(true);
        c2.setCategory("pants");
        c2.setSubcategory("regularFitJeans");
        c2.setModel("Regular Stretch Jeans");
        c2.setColor("light grey");
        c2.setSize(40); //42 44 48
        c2.setComposition("cotton");
        c2.setImage("http://static.zara.net/photos//2011/I/0/2/p/5575/330/811/5575330811_1_1_4.jpg");
        c2.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c2);


        Clothes c3 = new Clothes();
        c3.setGenre(true);
        c3.setCategory("pants");
        c3.setSubcategory("slimFitJeans");
        c3.setModel("Coloured Stretch Trousers");
        c3.setColor("mustard");
        c3.setSize(38);
        c3.setComposition("cotton");
        c3.setImage("http://static.zara.net/photos//2011/I/0/2/p/5575/344/305/5575344305_1_1_3.jpg");
        c3.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c3);

        Clothes c4 = new Clothes();
        c4.setGenre(true);
        c4.setCategory("pants");
        c4.setSubcategory("looseFitJeans");
        c4.setModel("Jeans");
        c4.setColor("dark blue");
        c4.setSize(48);
        c4.setComposition("cotton");
        c4.setImage("http://static.zara.net/photos//2011/I/0/2/p/2627/305/407/2627305407_1_1_4.jpg");
        c4.setPrice(Float.valueOf("25.99"));
        new InsertDAO().insertProduct(c4);


        Clothes c5 = new Clothes();
        c5.setGenre(false);
        c5.setCategory("pants");
        c5.setSubcategory("bootCutJeans");
        c5.setModel("Skinny Jeans");
        c5.setColor("blue");
        c5.setSize(40);
        c5.setComposition("cotton");
        c5.setImage("http://static.zara.net/photos//2011/I/0/1/p/6042/243/400/6042243400_1_1_4.jpg");
        c5.setPrice(Float.valueOf("22.99"));
        new InsertDAO().insertProduct(c5);

        Clothes c6 = new Clothes();
        c6.setGenre(false);
        c6.setCategory("pants");
        c6.setSubcategory("skinnyJeans");
        c6.setModel("Slim Jeans");
        c6.setColor("blue");
        c6.setSize(44);
        c6.setComposition("cotton");
        c6.setImage("http://static.zara.net/photos//2011/I/0/1/p/6514/240/400/6514240400_1_1_3.jpg");
        c6.setPrice(Float.valueOf("22.99"));
        new InsertDAO().insertProduct(c6);

        Clothes c7 = new Clothes();
        c7.setGenre(true);
        c7.setCategory("pants");
        c7.setSubcategory("slimFitJeans");
        c7.setModel("Coloured Skinny Jeans");
        c7.setColor("black");
        c7.setSize(38);
        c7.setComposition("cotton");
        c7.setImage("http://static.zara.net/photos//2011/I/0/2/p/3481/301/800/3481301800_1_1_3.jpg");
        c7.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c7);


        Clothes c8 = new Clothes();
        c8.setGenre(true);
        c8.setCategory("pants");
        c8.setSubcategory("slimFitJeans");
        c8.setModel("Fantasy Skinny Jeans");
        c8.setColor("dark blue");
        c8.setSize(40);
        c8.setComposition("cotton");
        c8.setImage("http://static.zara.net/photos//2011/I/0/2/p/6855/301/407/6855301407_1_1_3.jpg");
        c8.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c8);


        Clothes c9 = new Clothes();
        c9.setGenre(true);
        c9.setCategory("shoes");
        c9.setSubcategory("casualShoes");
        c9.setModel("Leather Sport Blucher");
        c9.setColor("black");
        c9.setSize(42);
        c9.setComposition("cow leather");
        c9.setImage("http://static.zara.net/photos//2011/I/1/2/p/5061/002/040/5061002040_1_1_3.jpg");
        c9.setPrice(Float.valueOf("29.99"));
        new InsertDAO().insertProduct(c9);


        Clothes c10 = new Clothes();
        c10.setGenre(true);
        c10.setCategory("shoes");
        c10.setSubcategory("casualShoes");
        c10.setModel("Leather Desert Boot");
        c10.setColor("lead");
        c10.setSize(44);
        c10.setComposition("cow leather");
        c10.setImage("http://static.zara.net/photos//2011/I/1/2/p/5066/002/005/5066002005_1_1_3.jpg");
        c10.setPrice(Float.valueOf("29.99"));
        new InsertDAO().insertProduct(c10);


        Clothes c11 = new Clothes();
        c11.setGenre(true);
        c11.setCategory("shoes");
        c11.setSubcategory("casualShoes");
        c11.setModel("Soft Oxford Shoe");
        c11.setColor("grey");
        c11.setSize(45);
        c11.setComposition("cow leather");
        c11.setImage("http://static.zara.net/photos//2011/I/1/2/p/5408/002/004/5408002004_1_1_3.jpg");
        c11.setPrice(Float.valueOf("39.99"));
        new InsertDAO().insertProduct(c11);


        Clothes c12 = new Clothes();
        c12.setGenre(true);
        c12.setCategory("shoes");
        c12.setSubcategory("casualShoes");
        c12.setModel("Herringbone Shoe");
        c12.setColor("grey");
        c12.setSize(45);
        c12.setComposition("polyester");
        c12.setImage("http://static.zara.net/photos//2011/I/1/2/p/5614/002/004/5614002004_1_1_3.jpg");
        c12.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c12);

        Clothes c13 = new Clothes();
        c13.setGenre(true);
        c13.setCategory("shoes");
        c13.setSubcategory("eveningShoes");
        c13.setModel("Edged Oxford Shoe");
        c13.setColor("black");
        c13.setSize(40);
        c13.setComposition("cow leather");
        c13.setImage("http://static.zara.net/photos//2011/I/1/2/p/5368/002/040/5368002040_1_1_3.jpg");
        c13.setPrice(Float.valueOf("39.99"));
        new InsertDAO().insertProduct(c13);

        Clothes c14 = new Clothes();
        c14.setGenre(false);
        c14.setCategory("shoes");
        c14.setSubcategory("wedgesShoes");
        c14.setModel("Zip-Up Wedge Ankle Boot");
        c14.setColor("grey");
        c14.setSize(36);
        c14.setComposition("cow leather");
        c14.setImage("http://static.zara.net/photos//2011/I/1/1/p/6108/001/004/6108001004_1_1_3.jpg");
        c14.setPrice(Float.valueOf("29.99"));
        new InsertDAO().insertProduct(c14);


        Clothes c15 = new Clothes();
        c15.setGenre(false);
        c15.setCategory("shoes");
        c15.setSubcategory("wedgesShoes");
        c15.setModel("Crepe Wedge");
        c15.setColor("copper");
        c15.setSize(38);
        c15.setComposition("cow leather");
        c15.setImage("http://static.zara.net/photos//2011/I/1/1/p/6354/001/027/6354001027_1_1_3.jpg");
        c15.setPrice(Float.valueOf("17.99"));
        new InsertDAO().insertProduct(c15);

        Clothes c16 = new Clothes();
        c16.setGenre(false);
        c16.setCategory("shoes");
        c16.setSubcategory("flatShoes");
        c16.setModel("Party Ballerina");
        c16.setColor("gold");
        c16.setSize(36);
        c16.setComposition("cotton");
        c16.setImage("http://static.zara.net/photos//2011/I/1/1/p/6253/001/091/6253001091_1_1_3.jpg");
        c16.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c16);

        Clothes c17 = new Clothes();
        c17.setGenre(false);
        c17.setCategory("shoes");
        c17.setSubcategory("flatShoes");
        c17.setModel("Flat Studded Court Shoe");
        c17.setColor("red");
        c17.setSize(39);
        c17.setComposition("goat skin");
        c17.setImage("http://static.zara.net/photos//2011/I/1/1/p/6256/001/020/6256001020_1_1_3.jpg");
        c17.setPrice(Float.valueOf("17.99"));
        new InsertDAO().insertProduct(c17);
        
        Clothes c18 = new Clothes();
        c18.setGenre(false);
        c18.setCategory("shoes");
        c18.setSubcategory("flatShoes");
        c18.setModel("Flat Furry Court Shoe");
        c18.setColor("two-tone");
        c18.setSize(36);
        c18.setComposition("cow leather");
        c18.setImage("http://static.zara.net/photos//2011/I/1/1/p/6266/001/202/6266001202_1_1_3.jpg");
        c18.setPrice(Float.valueOf("19.99"));
        new InsertDAO().insertProduct(c18);
        
        Clothes c19 = new Clothes();
        c19.setGenre(true);
        c19.setCategory("tie");
        c19.setSubcategory("classicTie");
        c19.setModel("Wide Check Tie");
        c19.setColor("brown");
        //c19.setSize(36);
        c19.setComposition("wool");
        c19.setImage("http://static.zara.net/photos//2011/I/0/2/p/6150/305/700/6150305700_1_1_3.jpg");
        c19.setPrice(Float.valueOf("9.99"));
        new InsertDAO().insertProduct(c19);
        
        
        Clothes c20 = new Clothes();
        c20.setGenre(true);
        c20.setCategory("tie");
        c20.setSubcategory("classicTie");
        c20.setModel("False Plain Tie");
        c20.setColor("grey");
        //c19.setSize(36);
        c20.setComposition("wool");
        c20.setImage("http://static.zara.net/photos//2011/I/0/2/p/0972/315/802/0972315802_1_1_3.jpg");
        c20.setPrice(Float.valueOf("9.99"));
        new InsertDAO().insertProduct(c20);
        
        
        Clothes c21 = new Clothes();
        c21.setGenre(true);
        c21.setCategory("tie");
        c21.setSubcategory("thinTie");
        c21.setModel("Structured Tie");
        c21.setColor("marron");
        //c19.setSize(36);
        c21.setComposition("silk");
        c21.setImage("http://static.zara.net/photos//2011/I/0/2/p/2253/306/605/2253306605_1_1_3.jpg");
        c21.setPrice(Float.valueOf("9.99"));
        new InsertDAO().insertProduct(c21);
        
    }
}
