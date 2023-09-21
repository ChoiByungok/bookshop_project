package bookstore.bookshop.service;

import bookstore.bookshop.domain.Category;
import bookstore.bookshop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class CategoryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void categoryTest() {
        Book book = new Book();
        book.setIsbn("1234");
        book.setPrice(10000);
        book.setAuthor("최병옥");
        book.setStockQuantity(100);
        book.setName("스프링");
        entityManager.persist(book);

        Book book1 = new Book();
        book1.setIsbn("1234");
        book1.setPrice(10000);
        book1.setAuthor("최병옥");
        book1.setStockQuantity(100);
        book1.setName("자바");
        entityManager.persist(book1);


        Category category = new Category();
        category.setName("Java");
        category.addItems(book1);
        entityManager.persist(category);


        Category category1 = new Category();
        category1.setName("Spring");
        category1.addItems(book);
        entityManager.persist(category1);

        category.addChildCategory(category1);


    }
}
