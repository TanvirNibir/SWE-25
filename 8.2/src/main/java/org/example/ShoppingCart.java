package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart manages items in a shopping cart.
 * Supports adding items, removing items, and calculating total cost.
 */
public class ShoppingCart {

    private static class CartItem {
        private final String name;
        private final double price;

        CartItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        String getName() {
            return name;
        }

        double getPrice() {
            return price;
        }
    }

    private final List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the shopping cart.
     * 
     * @param name the name of the item
     * @param price the price of the item
     * @throws IllegalArgumentException if name is null
     */
    public void addItem(String name, double price) {
        if (name == null) {
            throw new IllegalArgumentException("Item name cannot be null");
        }
        items.add(new CartItem(name, price));
    }

    /**
     * Removes the first occurrence of an item with the given name from the cart.
     * 
     * @param name the name of the item to remove
     */
    public void removeItem(String name) {
        if (name == null) {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            if (name.equals(items.get(i).getName())) {
                items.remove(i);
                return;
            }
        }
    }

    /**
     * Calculates the total cost of all items in the cart.
     * 
     * @return the total cost of all items
     */
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    /**
     * Returns the number of items in the cart.
     * 
     * @return the number of items in the cart
     */
    public int getItemCount() {
        return items.size();
    }
}

