package org.example;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();

        Scanner getInput = new Scanner(System.in);

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

            if (option == 6) {
                System.out.println("Exiting system...");
                break;
            }

            switch (option) {
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
                    System.out.print("Enter product name to check: ");
                    productName = getInput.nextLine();
                    checkProduct(products,productName);
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
                    System.out.print("Enter product name to remove: ");
                    productName = getInput.nextLine();
                    removeProduct(products,productName);
                    break;
            }
        }
    }

    public static String viewInventory(HashMap<String, Integer> products) {
        System.out.println("Current Inventory: ");
        products.forEach((key, value) -> System.out.println(key + " - " + value + " pcs"));
        return "Showing Inventory";
    }

    public static String addProduct(HashMap<String, Integer> products, String productName, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity should be positive.");
        } else if (products.containsKey(productName)) {
            System.out.println("Product already exists, please use update option.");
        } else {
            products.put(productName, quantity);
            System.out.println("Product Added!");
        }
        return "Product Added!";
    }

    public static String updateProduct(HashMap<String, Integer> products, String productName, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity should be positive.");
        } else if (!products.containsKey(productName)) {
            System.out.println("Product does not exist.");
        } else {
            products.replace(productName, quantity);
            System.out.println("Product Updated!");
        }

        return "Product Updated!";
    }

    public static String removeProduct(HashMap<String, Integer> products, String productName) {
        if (!products.containsKey(productName)) {
            System.out.println("Product does not exist.");
        } else {
            products.remove(productName);
            System.out.println("Product removed.");
        }
        return "Product removed.";
    }

    public static String checkProduct(HashMap<String, Integer> products, String productName) {
        if (products.containsKey(productName)) {
            System.out.println(productName + " is in stock: "+products.get(productName));
        } else {
            System.out.println("Product is not in stock.");
        }
        return "Product is in stock.";
    }
}
