package bookstore.bookshop.domain.item;

import bookstore.bookshop.item.dto.RegistrationDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
@NoArgsConstructor
public class Album extends Item{

    private String artist;

    private String etc;

    public Album(RegistrationDTO dto) {
        super(dto.getItemName(), dto.getPrice(), dto.getStockQuantity());
        this.artist = dto.getArtist();
        this.etc = dto.getEtc();
    }
}