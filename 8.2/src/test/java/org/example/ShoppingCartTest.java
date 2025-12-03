package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ShoppingCart.
 */
class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("New cart should have zero items")
    void testEmptyCart() {
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Adding items should increase item count")
    void testAddItem() {
        cart.addItem("Apple", 1.0);
        assertEquals(1, cart.getItemCount());

        cart.addItem("Banana", 0.5);
        assertEquals(2, cart.getItemCount());

        cart.addItem("Orange", 0.75);
        assertEquals(3, cart.getItemCount());
    }

    @Test
    @DisplayName("Adding duplicate items should be allowed")
    void testAddDuplicateItems() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Apple", 1.0);
        assertEquals(2, cart.getItemCount());
        assertEquals(2.0, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Removing items should decrease item count")
    void testRemoveItem() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);

        cart.removeItem("Apple");
        assertEquals(2, cart.getItemCount());

        cart.removeItem("Banana");
        assertEquals(1, cart.getItemCount());
    }

    @Test
    @DisplayName("Removing non-existent item should not affect cart")
    void testRemoveNonExistentItem() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);

        cart.removeItem("Orange");
        assertEquals(2, cart.getItemCount());
        assertEquals(1.5, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Removing one of duplicate items should only remove one instance")
    void testRemoveDuplicateItem() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);

        cart.removeItem("Apple");
        assertEquals(2, cart.getItemCount());
        assertEquals(1.5, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Calculate total should sum all item prices")
    void testCalculateTotal() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);

        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Calculate total with decimal precision")
    void testCalculateTotalWithDecimals() {
        cart.addItem("Item1", 10.99);
        cart.addItem("Item2", 5.50);
        cart.addItem("Item3", 3.25);

        assertEquals(19.74, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Empty cart should have zero total")
    void testEmptyCartTotal() {
        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Removing all items should result in empty cart")
    void testRemoveAllItems() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);

        cart.removeItem("Apple");
        cart.removeItem("Banana");

        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Items with zero price should be handled correctly")
    void testZeroPriceItem() {
        cart.addItem("FreeItem", 0.0);
        assertEquals(1, cart.getItemCount());
        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Items with negative price should be handled")
    void testNegativePriceItem() {
        cart.addItem("DiscountItem", -1.0);
        assertEquals(1, cart.getItemCount());
        assertEquals(-1.0, cart.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("Complex scenario with multiple operations")
    void testComplexScenario() {
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);
        assertEquals(3, cart.getItemCount());
        assertEquals(2.25, cart.calculateTotal(), 0.01);

        cart.removeItem("Banana");
        assertEquals(2, cart.getItemCount());
        assertEquals(1.75, cart.calculateTotal(), 0.01);

        cart.addItem("Grape", 2.0);
        assertEquals(3, cart.getItemCount());
        assertEquals(3.75, cart.calculateTotal(), 0.01);
    }
}

