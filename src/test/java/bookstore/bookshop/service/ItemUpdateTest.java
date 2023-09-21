package bookstore.bookshop.service;

import bookstore.bookshop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void updateTest() {
        Book book = entityManager.find(Book.class, 33L);
        book.setName("dirtyChecking");

    }
}
