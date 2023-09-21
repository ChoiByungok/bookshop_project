package bookstore.bookshop.item.repository;

import bookstore.bookshop.domain.item.Item;
import bookstore.bookshop.domain.item.QItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static bookstore.bookshop.domain.item.QItem.item;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final JPAQueryFactory queryFactory;

    public List<Item> search() {
        return queryFactory
                .selectFrom(item)
                .fetch();
    }
}