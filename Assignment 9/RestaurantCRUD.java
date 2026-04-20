import java.util.*;

public class RestaurantCRUD {
    
    static class MenuItem {
        int id, resId;
        String name;
        double price;
        
        MenuItem(int id, String name, double price, int resId) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.resId = resId;
        }
    }
    
    static class Restaurant {
        int id;
        String name, address;
        
        Restaurant(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }
    
    static List<MenuItem> menuItems = new ArrayList<>();
    static List<Restaurant> restaurants = new ArrayList<>();
    
    public static void main(String[] args) {
        // Initialize database data
        initializeData();
        
        System.out.println("Connected to database\n");
        
        // 1. Select Menu Items where price <= 100
        System.out.println("Menu Items with Price <= 100:");
        List<MenuItem> result1 = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.price <= 100) {
                result1.add(item);
            }
        }
        printMenuItems(result1);
        
        // 2. Select Menu Items in "Cafe Java"
        System.out.println("\nMenu Items in Cafe Java:");
        List<MenuItem> result2 = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.resId == 1) { // Cafe Java has Id 1
                result2.add(item);
            }
        }
        printMenuItems(result2);
        
        // 3. Update price <= 100 to 200
        System.out.println("\nUpdating Records with Price <= 100 to 200...");
        int updated = 0;
        for (MenuItem item : menuItems) {
            if (item.price <= 100) {
                item.price = 200;
                updated++;
            }
        }
        System.out.println("Updated Records Count: " + updated);
        
        System.out.println("\nAfter Update:");
        printMenuItems(menuItems);
        
        // 4. Delete items starting with 'P'
        System.out.println("\nDeleting Items starting with 'P'...");
        int deleted = 0;
        Iterator<MenuItem> iterator = menuItems.iterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.name.startsWith("P")) {
                iterator.remove();
                deleted++;
            }
        }
        System.out.println("Deleted Records Count: " + deleted);
        
        System.out.println("\nAfter Deletion:");
        printMenuItems(menuItems);
    }
    
    static void initializeData() {
        // Initialize Restaurants
        restaurants.add(new Restaurant(1, "Cafe Java", "Pune"));
        restaurants.add(new Restaurant(2, "Food Hub", "Mumbai"));
        restaurants.add(new Restaurant(3, "Spice Villa", "Delhi"));
        restaurants.add(new Restaurant(4, "Tasty Bites", "Bangalore"));
        restaurants.add(new Restaurant(5, "Green Leaf", "Chennai"));
        restaurants.add(new Restaurant(6, "Urban Kitchen", "Hyderabad"));
        restaurants.add(new Restaurant(7, "Royal Dine", "Jaipur"));
        restaurants.add(new Restaurant(8, "Quick Eat", "Ahmedabad"));
        
        // Initialize Menu Items
        menuItems.add(new MenuItem(1, "Pasta", 80, 1));
        menuItems.add(new MenuItem(2, "Pizza", 120, 1));
        menuItems.add(new MenuItem(3, "Burger", 90, 2));
        menuItems.add(new MenuItem(4, "Pav Bhaji", 70, 3));
        menuItems.add(new MenuItem(5, "Paneer Tikka", 150, 4));
        menuItems.add(new MenuItem(6, "Paratha", 60, 5));
        menuItems.add(new MenuItem(7, "Pulao", 95, 6));
        menuItems.add(new MenuItem(8, "Noodles", 110, 7));
        menuItems.add(new MenuItem(9, "Pizza Small", 85, 1));
        menuItems.add(new MenuItem(10, "Pancake", 50, 8));
    }
    
    static void printMenuItems(List<MenuItem> items) {
        System.out.println("Id\t\tName\t\t\tPrice\t\tResId");
        System.out.println("----------------------------------------------");
        for (MenuItem item : items) {
            System.out.println(item.id + "\t\t" + item.name + "\t\t\t" + item.price + "\t\t" + item.resId);
        }
    }
}
