package ru.netology.maven.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    ShopRepository shop = new ShopRepository();
    Product product1 = new Product(1, "Хлеб", 100);
    Product product2 = new Product(2, "Молоко", 80);
    Product product3 = new Product(3, "Яйца", 120);
    Product product4 = new Product(4, "Колбаса", 500);
    Product product5 = new Product(5, "Рыба", 350);

    @BeforeEach
    public void setup() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.add(product5);
    }

    @Test
    public void shouldAddProductTest() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProductTest() {
        Product newProduct = new Product(6, "Крупа", 75);
        shop.add(newProduct);

        Product[] expected = {product1, product2, product3, product4, product5, newProduct};
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowsAddProductTest() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.save(5);
        });
    }

    @Test
    public void shouldFindByIdTest() {
        int id = 5;
        Product expected = product5;
        Product actual = shop.findById(id);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFRemoveProductTest() {
        shop.remove(product3.getId());

        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

