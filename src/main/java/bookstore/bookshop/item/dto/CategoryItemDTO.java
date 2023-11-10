package bookstore.bookshop.item.dto;

import bookstore.bookshop.domain.CategoryItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryItemDTO {

    private String CategoryName;

    public CategoryItemDTO(CategoryItem categoryItem) {
        this.CategoryName = categoryItem.getCategory().getName();
    }
}
