import java.util.Arrays;
import java.util.Comparator;

class Search {

    // Linear Search
    static Product linearSearch(Product[] products, int key) {
        for (Product p : products) {
            if (p.productId == key)
                return p;
        }
        return null;
    }

    // Binary Search
    static Product binarySearch(Product[] products, int key) {

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == key)
                return products[mid];
            else if (products[mid].productId < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}