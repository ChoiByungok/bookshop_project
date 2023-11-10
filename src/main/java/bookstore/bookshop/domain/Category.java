package bookstore.bookshop.domain;

import bookstore.bookshop.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    public List<CategoryItem> categoryItems = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();




    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

//    public void addItems(Item item) {
//        this.items.add(item);
//        item.setCategories(child);
//    }

}
