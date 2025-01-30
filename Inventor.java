import java.util.HashMap;
import java.util.Map;

class Inventor {
    private Map<String, Integer> products;

    public Inventor() {
        products = new HashMap<>();
    }


    public void addProduct(String product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
        System.out.println(quantity + " units of " + product + " added to the inventory.");
    }

    
    public void removeProduct(String product, int quantity) {
        if (products.containsKey(product) && products.get(product) >= quantity) {
            products.put(product, products.get(product) - quantity);
            System.out.println(quantity + " units of " + product + " removed from the inventory.");
        } else {
            System.out.println("Insufficient stock or product not found.");
        }
    }

    
    public void checkLowInventory() {
        System.out.println("Products with low inventory (less than 5 units):");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " units");
            }
        }
    }

    public static void main(String[] args) {
        Inventor inventor = new Inventor();
        inventor.addProduct("Chawanprash 1 kg", 10);
        inventor.addProduct("Aashirvaad Aata", 2);
        inventor.addProduct("Rani Mustard Oil", 7);
        inventor.removeProduct("Daal", 1);
        inventor.checkLowInventory();
    }
}
