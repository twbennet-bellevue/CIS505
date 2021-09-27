/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_4;

import java.util.LinkedList;

public class ProductDB {
    
    /**
     * Method to input user actions to choose a series of products to create.
     * Includes the return of null if an invalid entry is entered.
     * @param code String
     * @return GenericQueue<Product>
     */
    public static GenericQueue<Product> getProducts(String code) {
        //basx
        if (code.equalsIgnoreCase("b")) {
            //create 5 new ball instances, set four fields with values and add them to the product generic queue named balls.
            GenericQueue<Product> balls = new GenericQueue<Product>();

            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow 2.0");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");
            

            Ball ball2 = new Ball();
            ball2.setCode("B200");
            ball2.setDescription("American Patriot 1.0");
            ball2.setPrice(154.95);
            ball2.setColor("White, Red, and Blue");

            Ball ball3 = new Ball();
            ball3.setCode("I100");
            ball3.setDescription("ISU");
            ball3.setPrice(124.95);
            ball3.setColor("Red and Black");

            Ball ball4 = new Ball();
            ball4.setCode("BN100");
            ball4.setDescription("Nebula");
            ball4.setPrice(144.95);
            ball4.setColor("Black and Purple");

            Ball ball5 = new Ball();
            ball5.setCode("B500");
            ball5.setDescription("Christmas Fiesta");
            ball5.setPrice(134.95);
            ball5.setColor("White, Red, and Green");

            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);
            return balls;

        } else if (code.equalsIgnoreCase("a")) {
            //create 3 new shoe instances, set all four data fields with values and add them to the queue named shoes
            GenericQueue<Product> bags = new GenericQueue<Product>();
            Bag bag1 = new Bag();
            bag1.setCode("B100");
            bag1.setDescription("Ultra-lightweight Silver/Red");
            bag1.setPrice(57.95);
            bag1.setBallType("Single");


            Bag bag2 = new Bag();
            bag2.setCode("B200");
            bag2.setDescription("Quantum Black/Blue Roller");
            bag2.setPrice(94.95);
            bag2.setBallType("Double");

            Bag bag3 = new Bag();
            bag3.setCode("B300");
            bag3.setDescription("Premium Leather Deluxe III");
            bag3.setPrice(120.95);
            bag3.setBallType("Triple");

            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);
            return bags;

        } else if (code.equalsIgnoreCase("s")) {
            //create 5 new shoe instances, set four fields with values and add them to a queue names shoes.
            GenericQueue<Product> shoes = new GenericQueue<Product>();

            Shoe shoe1 = new Shoe();
            shoe1.setCode("S100");
            shoe1.setDescription("Michael Jordans");
            shoe1.setPrice(95.95);
            shoe1.setSize(10);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S250");
            shoe2.setDescription("Nike Air");
            shoe2.setPrice(92.95);
            shoe2.setSize(12);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S325");
            shoe3.setDescription("Jumpin' Kicks");
            shoe3.setPrice(84.95);
            shoe3.setSize(13);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S420");
            shoe4.setDescription("Running Air Pros");
            shoe4.setPrice(152.95);
            shoe4.setSize(12);

            Shoe shoe5 = new Shoe();
            shoe5.setCode("S500");
            shoe5.setDescription("Brooks");
            shoe5.setPrice(150.95);
            shoe5.setSize(13);

            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);
            return shoes;

        } else if (code.equalsIgnoreCase("x")) {
            // return an empty product generic queue
            GenericQueue<Product> empty = new GenericQueue<Product>(); 
            return empty;
        }

        return null;
    }
}
