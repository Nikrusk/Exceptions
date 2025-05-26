import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(11, "Product1", 500);
    Product product2 = new Product(22, "Product 2", 80_000);
    Product product3 = new Product(33, "Product 3", 40_000);
    Product product4 = new Product(44, "Product 4", 20_000);
    Product product5 = new Product(55, "Product 5", 100);
    Product product6 = new Product(66, "Product 6", 9500);

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
    }


    @Test
    public void shouldAddProduct() {
        Product newProduct = new Product(77, "New Product", 5000);
        repo.add(newProduct);

        Product[] expected = {product1, product2, product3, product4, product5, product6, newProduct};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(15);
        });
    }
}
