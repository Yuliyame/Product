import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 30_000);
        Product product2 = new Product(2, "Телефон", 30_000);
        Product product3 = new Product(3, "Телефон", 30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        assertArrayEquals(expected, actual);
    }

}