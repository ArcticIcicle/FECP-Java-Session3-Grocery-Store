package org.example;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();

        Scanner getInput = new Scanner (System.in);

        while (true) {
            System.out.println("--- Grocery Inventory Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            String optionString = getInput.nextLine();
            int option = Integer.parseInt(optionString);

            if ( option == 6 ) { // Check if the input matches the desired input (case-insensitive)
                System.out.println("Exiting system...");
                break; // Exit the loop
            }

            switch(option){
                case 1: // View Inventory
                    viewInventory(products);
                    break;
                case 2: // Add Product
                    System.out.print("Enter product name: ");
                    String productName = getInput.nextLine();
                    int quantity = 0;
                    System.out.print("Enter quantity: ");
                    String quantityString = getInput.nextLine();
                    quantity = Integer.parseInt(quantityString);
                    addProduct(products, productName, quantity);
                    System.out.print("\n");
                    break;
                case 3: // Check Product

                    break;
                case 4: // Update Stock
                    System.out.print("Enter product name to update: ");
                    productName = getInput.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    quantityString = getInput.nextLine();
                    quantity = Integer.parseInt(quantityString);
                    updateProduct(products, productName, quantity);
                    System.out.print("\n");
                    break;
                case 5: // Remove Product
                    break;
            }
        }
        //System.out.println(pizzas.isEmpty());
        //System.out.println(quantities.isEmpty());

    }
    public static void viewInventory(HashMap<String, Integer> products){
        System.out.println("Current Inventory: ");
        products.forEach((key, value) -> System.out.println(key +" - "+ value +" pcs"));
    }
    public static String addProduct(HashMap<String, Integer> products, String productName, int quantity)
    {
        if (quantity < 0){
            System.out.println("Quantity cannot be negative.");
        }else if (products.containsKey(productName)) {
            System.out.println("Product already exists, please use update option.");
        }
        else{
            products.put(productName, quantity);
            System.out.println("Product Added!");
        }
        return "Product Added!";
    }
    public static String updateProduct (HashMap<String, Integer> products, String productName, int quantity){
        if (quantity < 0){
            System.out.println("Quantity cannot be negative.");
        }else if (!products.containsKey(productName)) {
            System.out.println("Product does not exist.");
        }
        else{
            products.replace(productName, quantity);
            System.out.println("Product Updated!");
        }

        return "Product Updated!";
    }
}
