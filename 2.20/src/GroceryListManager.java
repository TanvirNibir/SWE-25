import java.util.*;

public class GroceryListManager {
  private ArrayList<String> groceryList = new ArrayList<>();
  private HashMap<String, Double> itemCost = new HashMap<>();
  private HashMap<String, String> itemCategory = new HashMap<>();
  private HashMap<String, Integer> itemQuantity = new HashMap<>();

  // Task 1: Add item (basic)
  public void addItem(String item) {
    if (item == null || item.trim().isEmpty()) {
      System.out.println("Error: Item cannot be empty.");
      return;
    }
    item = item.trim();
    if (!groceryList.contains(item)) {
      groceryList.add(item);
      System.out.println("Added: " + item);
    } else {
      System.out.println("Item '" + item + "' is already in the list.");
    }
  }

  // Task 1: Remove item
  public void removeItem(String item) {
    if (item == null || item.trim().isEmpty()) {
      System.out.println("Error: Item cannot be empty.");
      return;
    }
    item = item.trim();
    if (groceryList.remove(item)) {
      itemCost.remove(item);
      itemCategory.remove(item);
      itemQuantity.remove(item);
      System.out.println("Removed: " + item);
    } else {
      System.out.println("Item '" + item + "' not found in the list.");
    }
  }

  // Task 1: Display list
  public void displayList() {
    if (groceryList.isEmpty()) {
      System.out.println("Grocery List is empty.");
      return;
    }
    System.out.println("Grocery List:");
    for (int i = 0; i < groceryList.size(); i++) {
      System.out.println((i + 1) + ". " + groceryList.get(i));
    }
  }

  // Task 1: Check if item exists
  public boolean checkItem(String item) {
    if (item == null || item.trim().isEmpty()) {
      return false;
    }
    return groceryList.contains(item.trim());
  }

  // Task 2: Add item with cost
  public void addItem(String item, double cost) {
    if (item == null || item.trim().isEmpty()) {
      System.out.println("Error: Item cannot be empty.");
      return;
    }
    if (cost < 0) {
      System.out.println("Error: Cost cannot be negative.");
      return;
    }
    item = item.trim();
    addItem(item);
    if (groceryList.contains(item)) {
      itemCost.put(item, cost);
    }
  }

  // Task 2: Calculate total cost (with quantity)
  public double calculateTotalCost() {
    double total = 0.0;
    for (String item : groceryList) {
      Double cost = itemCost.get(item);
      Integer qty = itemQuantity.get(item);
      if (cost != null && qty != null && qty > 0) {
        total += cost * qty;
      }
    }
    return total;
  }

  // Task 3: Add item with cost and category
  public void addItem(String item, double cost, String category) {
    if (category == null || category.trim().isEmpty()) {
      System.out.println("Error: Category cannot be empty.");
      return;
    }
    category = category.trim();
    addItem(item, cost);
    if (groceryList.contains(item.trim())) {
      itemCategory.put(item.trim(), category);
    }
  }

  // Task 3: Display items by category
  public void displayByCategory(String category) {
    if (category == null || category.trim().isEmpty()) {
      System.out.println("Error: Category cannot be empty.");
      return;
    }
    category = category.trim();
    boolean found = false;
    System.out.println("Items in category '" + category + "':");
    for (String item : groceryList) {
      String cat = itemCategory.get(item);
      if (category.equalsIgnoreCase(cat)) {
        System.out.println("- " + item);
        found = true;
      }
    }
    if (!found) {
      System.out.println("No items found in this category.");
    }
  }

  // Task 4: Add item with cost, category, and quantity
  public void addItem(String item, double cost, String category, int quantity) {
    if (quantity < 0) {
      System.out.println("Error: Quantity cannot be negative.");
      return;
    }
    addItem(item, cost, category);
    if (groceryList.contains(item.trim())) {
      itemQuantity.put(item.trim(), quantity);
    }
  }

  // Task 4: Update quantity
  public void updateQuantity(String item, int newQuantity) {
    if (item == null || item.trim().isEmpty()) {
      System.out.println("Error: Item cannot be empty.");
      return;
    }
    if (newQuantity < 0) {
      System.out.println("Error: Quantity cannot be negative.");
      return;
    }
    item = item.trim();
    if (groceryList.contains(item)) {
      itemQuantity.put(item, newQuantity);
      System.out.println("Updated quantity of '" + item + "' to " + newQuantity);
    } else {
      System.out.println("Item '" + item + "' not found.");
    }
  }

  // Task 4: Display items with positive quantity
  public void displayAvailableItems() {
    System.out.println("Available Items (with quantity > 0):");
    boolean found = false;
    for (String item : groceryList) {
      Integer qty = itemQuantity.get(item);
      if (qty != null && qty > 0) {
        Double cost = itemCost.get(item);
        String costStr = (cost != null) ? String.format("$%.2f", cost) : "N/A";
        System.out.println("- " + item + " (Qty: " + qty + ", Cost: " + costStr + ")");
        found = true;
      }
    }
    if (!found) {
      System.out.println("No items with positive quantity.");
    }
  }

  // Task 5: Tester in main method
  public static void main(String[] args) {
    GroceryListManager manager = new GroceryListManager();

    System.out.println("=== Task 1: Basic Operations ===");
    manager.addItem("Apples");
    manager.addItem("Milk");
    manager.addItem("Bread");
    manager.displayList();

    System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

    System.out.println("\nRemoving \"Milk\" from the list...");
    manager.removeItem("Milk");
    manager.displayList();

    System.out.println("\n=== Task 2: Total Cost Calculation ===");
    manager.addItem("Apples", 1.50);
    manager.addItem("Bread", 2.00);
    System.out.printf("Total cost: $%.2f\n", manager.calculateTotalCost());

    System.out.println("\n=== Task 3: Categorizing Items ===");
    manager.addItem("Banana", 0.75, "Fruits");
    manager.addItem("Cheese", 3.50, "Dairy");
    manager.addItem("Croissant", 1.80, "Bakery");

    manager.displayByCategory("Fruits");
    manager.displayByCategory("Dairy");
    manager.displayByCategory("Snacks");

    System.out.println("\n=== Task 4: Quantity Tracking ===");
    manager.addItem("Apples", 1.50, "Fruits", 3);
    manager.addItem("Milk", 2.20, "Dairy", 2);
    manager.addItem("Bread", 2.00, "Bakery", 1);

    manager.displayAvailableItems();

    System.out.println("\nUpdating quantity of 'Apples' to 5...");
    manager.updateQuantity("Apples", 5);
    manager.displayAvailableItems();

    System.out.println("\n=== Final Total Cost (with updated quantities) ===");
    System.out.printf("Total cost: $%.2f\n", manager.calculateTotalCost());
  }
}