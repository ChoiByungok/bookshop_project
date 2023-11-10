package bookstore.bookshop.item.dto;

import bookstore.bookshop.domain.item.Album;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumResponseDTO extends ItemResponseDTO{
    private String artist;
    private String etc;

    public AlbumResponseDTO(Album item) {
        super(item.getName(), item.getPrice(), item.getStockQuantity());
        this.artist = item.getArtist();
        this.etc = item.getEtc();
        super.setCategories(item.getCategoryItems());
    }
}
