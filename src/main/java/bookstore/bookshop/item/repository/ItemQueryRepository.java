package bookstore.bookshop.item.repository;

import bookstore.bookshop.domain.item.Item;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static bookstore.bookshop.domain.QCategory.category;
import static bookstore.bookshop.domain.QCategoryItem.categoryItem;
import static bookstore.bookshop.domain.item.QItem.item;

@Repository
@RequiredArgsConstructor
public class ItemQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Item> search() {
        return queryFactory
                .selectFrom(item)
                .fetch();
    }

    public List<Item> searchWithCategory() {
        return queryFactory
                .selectFrom(item)
                .leftJoin(item.categoryItems, categoryItem).fetchJoin()
                .leftJoin(categoryItem.category, category).fetchJoin()
                .fetch();
    }
}
