package bookstore.bookshop.item.controller;

import bookstore.bookshop.item.dto.RegistrationDTO;
import bookstore.bookshop.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/set")
    public String registration(@RequestBody RegistrationDTO registrationDTO) {
        itemService.registration(registrationDTO);
        return "ok";
    }
}
