package bookstore.bookshop.domain.item;

import bookstore.bookshop.item.dto.RegistrationDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
public class Movie extends Item{

    private String director;

    private String actor;

    public Movie(RegistrationDTO dto) {
        super(dto.getItemName(), dto.getPrice(), dto.getStockQuantity());
        this.director = dto.getDirector();
        this.actor = dto.getActor();
    }
}
