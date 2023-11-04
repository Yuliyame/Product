import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExistOne() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenProductExistTwo() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenProductExistThree() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.AssertThrows (NotFoundException.class,
                () -> repo.remove(444)
        );
    }

}