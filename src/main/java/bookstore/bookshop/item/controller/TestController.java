package bookstore.bookshop.item.controller;

import bookstore.bookshop.item.dto.ItemDTO;
import bookstore.bookshop.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ItemService itemService;

    @GetMapping("/search")
    public List<ItemDTO> search() {
        return itemService.search();
    }
}
