package bookstore.bookshop.item.dto;

import bookstore.bookshop.domain.item.Item;
import lombok.Data;

@Data
public class ItemDTO {

    private Long itemId;
    private String itemName;
    private Integer stockQuantity;

    public ItemDTO (Item item) {
        this.itemId = item.getId();
        this.itemName = item.getName();
        this.stockQuantity = item.getStockQuantity();
    }

}
