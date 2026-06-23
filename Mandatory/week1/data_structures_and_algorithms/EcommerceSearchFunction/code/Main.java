public class Main {

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mobile", "Electronics"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Watch", "Accessories")
        };

        int key = 103;

        System.out.println("Linear Search:");
        Product result1 = Search.linearSearch(products, key);

        if (result1 != null)
            System.out.println("Found: [" + result1.productId + "] "
                    + result1.productName + " - " + result1.category);

        System.out.println("\nBinary Search:");
        Product result2 = Search.binarySearch(products, key);

        if (result2 != null)
            System.out.println("Found: [" + result2.productId + "] "
                    + result2.productName + " - " + result2.category);
    }
}