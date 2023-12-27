import java.util.ArrayList;
import java.util.Comparator;

public class ProductManager {
    private static ArrayList<Product> list = new ArrayList<>();

    public ProductManager(ArrayList<Product> list) {
        ProductManager.list = list;
    }

    public ProductManager() {
    }
    public void addProduct(Product product) {
        list.add(product);
    }
    public boolean modifyProductByID(String id, String newId, String newName, double newPrice) {
        for (Product product : list) {
            if (product.getId().equals(id)) {
                product.setId(newId);
                product.setName(newName);
                product.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }
    public boolean removeProductByID(String id) {
        for (Product product : list) {
            if (product.getId().equals(id)) {
                list.remove(product);
                return true;
            }
        }return false;
    }

    public void displayProduct() {
        System.out.println("Product list: ");
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    public Product searchByName(String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                return product;
            }
        }return null;
    }

    public void sortByPriceAsc() {
        list.sort(Comparator.comparingDouble(Product::getPrice));
    }
    public void sortByPriceDes() {
        list.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
    }
}
