package bookstore.bookshop.item.dto;

import bookstore.bookshop.domain.CategoryItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ItemResponseDTO {
    private String name;
    private int price;
    private int stockQuantity;
    private List<CategoryItemDTO> categories = new ArrayList<>();
    public ItemResponseDTO(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void setCategories(List<CategoryItem> categoryItems) {
        for (CategoryItem categoryItem : categoryItems) {
            categories.add(new CategoryItemDTO(categoryItem));
        }
    }
}
