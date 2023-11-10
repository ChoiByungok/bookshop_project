package bookstore.bookshop.item.dto;

import bookstore.bookshop.domain.item.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponseDTO extends ItemResponseDTO{
    private String author;
    private String isbn;
    public BookResponseDTO(Book item) {
        super(item.getName(), item.getPrice(), item.getStockQuantity());
        this.author = item.getAuthor();
        this.isbn = item.getIsbn();
        super.setCategories(item.getCategoryItems());
    }
}
