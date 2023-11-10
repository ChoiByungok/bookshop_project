package bookstore.bookshop.item.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegistrationDTO {
    String type;
    String itemName;
    Integer price;
    Integer stockQuantity;
    String parentCategory;
    String categoryName;
    String artist;
    String etc;
    String author;
    String isbn;
    String actor;
    String director;
}