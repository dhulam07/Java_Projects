package Day01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookStoreSystem {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addBook(String title, int quantity) {
        inventory.put(title, quantity);
    }

    public void removeBook(String title) {
        inventory.remove(title);
    }

    public void updateQuantity(String title, int quantity) {
        if (inventory.containsKey(title)) {
            inventory.put(title, quantity);
        }
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("EmptyMap");
        }
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BookStoreSystem bookstore = new BookStoreSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Update quantity");
            System.out.println("4. Print inventory");
            System.out.println("5. Exit");
            System.out.println("Enter a number : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline left-over
                    bookstore.addBook(title, quantity);
                    break;
                case 2:
                    System.out.println("Enter book title:");
                    title = scanner.nextLine();
                    bookstore.removeBook(title);
                    break;
                case 3:
                    System.out.println("Enter book title:");
                    title = scanner.nextLine();
                    System.out.println("Enter new quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline left-over
                    bookstore.updateQuantity(title, quantity);
                    break;
                case 4:
                    bookstore.printInventory();
                    break;
                case 5:
                    System.exit(0);
                    scanner.close();
            }
        } 
    }
}

