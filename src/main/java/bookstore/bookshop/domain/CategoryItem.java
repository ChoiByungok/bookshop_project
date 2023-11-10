package bookstore.bookshop.domain;

import bookstore.bookshop.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "categoryItem_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public void setItem(Item item) {
        this.item = item;
        item.getCategoryItems().add(this);
    }

    public void setCategory(Category category) {
        this.category = category;
        category.getCategoryItems().add(this);
    }
}
