package bookstore.bookshop.domain.item;

import bookstore.bookshop.item.dto.RegistrationDTO;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@NoArgsConstructor
@Getter
@Setter
public class Book extends Item{

    private String author;

    private String isbn;

    public Book(RegistrationDTO bookDTO) {
        super(bookDTO.getItemName(), bookDTO.getPrice(), bookDTO.getStockQuantity());
        author = bookDTO.getAuthor();
        isbn = bookDTO.getIsbn();
    }

}
