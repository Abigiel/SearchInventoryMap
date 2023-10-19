package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchInventoryMap {

    static HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();

    public static void main(String[] args) {

        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv")); // insert reader to read file

            String input = buffReader.readLine();
            while ((input = buffReader.readLine()) != null) {
                String[] details = input.split("\\|"); // split using delimiter to create array
                int id = Integer.parseInt(details[0]);
                String name = details[1];
                float price = Float.parseFloat(details[2]);
                Product p = new Product(id, name, price); // use declared values to create product object


                while(name != null){              // use loop to add all values to HashMap
                    inventory.put(id, p);
                    break;
            }

            }


            buffReader.close();              // close BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {                                        // loop to search as many times as needed

            Scanner myScanner = new Scanner(System.in);
            System.out.println("What item # are you interested in?");       //prompt user for input

            int id = myScanner.nextInt();
            Product matchedProduct = inventory.get(id);                     //assign key used for search to variable
            if (matchedProduct == null) {                                   //condition for non existent key
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry a %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());


                Scanner scan = new Scanner(System.in);
                System.out.println("\nDo you want to search again?");              //prompt user to check if search should run again
                String answer = scan.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    continue;
                } else if (answer.equalsIgnoreCase("no")) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid response. Answer yes or no.");
                }

        }

    }
}

