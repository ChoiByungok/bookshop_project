package bookstore.bookshop.item.dto;

import bookstore.bookshop.domain.item.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponseDTO extends ItemResponseDTO{
    private String director;
    private String actor;

    public MovieResponseDTO(Movie item) {
        super(item.getName(), item.getPrice(), item.getStockQuantity());
        this.director = item.getDirector();
        this.actor = item.getActor();
        super.setCategories(item.getCategoryItems());
    }
}
