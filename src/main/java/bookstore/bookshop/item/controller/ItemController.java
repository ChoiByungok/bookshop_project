package bookstore.bookshop.item.controller;

import bookstore.bookshop.item.dto.ItemResponseDTO;
import bookstore.bookshop.item.dto.RegistrationDTO;
import bookstore.bookshop.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/set")
    public String registration(@RequestBody RegistrationDTO registrationDTO) {
        itemService.registration(registrationDTO);
        return "ok";
    }

    @GetMapping("/item/search")
    public List<ItemResponseDTO> search() {
        return itemService.searchWithCategory();
    }
}
