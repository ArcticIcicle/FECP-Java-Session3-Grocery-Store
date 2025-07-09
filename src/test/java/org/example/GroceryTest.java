package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.example.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class GroceryTest {
    private HashMap<String, Integer> products;

    @BeforeEach
    void setUP(){
        products = new HashMap<>();
    }

    // Add
    @Test
    void shouldAddProductWithValidQuantity(){
        addProduct(products, "Banana", 30);
        assertEquals(30, products.get("Banana"));
    }
    // Add with Quantity of 0 or less
    @Test
    void shouldNotAddProductWithNonPositiveInteger(){
        String actual = addProduct(products, "Banana", 0);
        assertEquals("Quantity should be positive.", actual);
        String actualNegative = addProduct(products, "Banana", -5);
        assertEquals("Quantity should be positive.", actualNegative);
    }

    @Test
    void shouldBlockAddingOfExistingProduct(){
        addProduct(products, "Banana", 30);
        String actual = addProduct(products, "Banana", 20);
        assertEquals("Product already exists, please use update option.", actual);
    }

    // Check
    @Test
    void shouldCheckExistingProduct(){
        addProduct(products, "Milk", 20);
        String actual = checkProduct(products, "Milk");
        assertEquals("Product is in stock.", actual);
    }
    @Test
    void shouldFailWhenProductDoesNotExist(){
        addProduct(products, "Milk", 20);
        String actual = checkProduct(products, "Ice Cream");
        assertEquals("Product is not in stock.", actual);
    }

    // Update
    @Test
    void shouldUpdateStockWithValidQuantity(){
        addProduct(products, "Bread", 20);
        updateProduct(products, "Bread", 25);
        assertEquals(25, products.get("Bread"));
    }

    @Test
    void shouldNotUpdateStockWithNonNegativeInteger(){
        addProduct(products, "Bread", 20);
        String actual = updateProduct(products, "Bread", -5);
        assertEquals("Quantity should be positive.", actual);
    }

    @Test
    void shouldNotUpdateProductThatDoesNotExist(){
        String actual = updateProduct(products, "Tofu", 20);
        assertEquals("Product does not exist.", actual);
    }

    // Remove
    @Test
    void shouldRemoveProduct(){
        addProduct(products, "Eggs", 10);
        String actual = removeProduct(products, "Eggs");
        assertEquals("Product removed.", actual);
        assertFalse(products.containsKey("Eggs"));
    }

    @Test
    void shouldNotRemoveNonexistingProduct() {
        String actual = removeProduct(products, "Pizza");
        assertEquals("Product does not exist.", actual);
    }

}