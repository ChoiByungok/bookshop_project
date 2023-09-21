package bookstore.bookshop.item.service;

import bookstore.bookshop.item.dto.ItemDTO;
import bookstore.bookshop.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    public final ItemRepository itemRepository;

    public List<ItemDTO> search() {
        return itemRepository.search()
                .stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }
}
