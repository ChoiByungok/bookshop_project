package bookstore.bookshop.item.service;

import bookstore.bookshop.domain.Category;
import bookstore.bookshop.domain.item.Album;
import bookstore.bookshop.domain.item.Book;
import bookstore.bookshop.domain.item.Movie;
import bookstore.bookshop.item.dto.*;
import bookstore.bookshop.item.repository.CategoryRepository;
import bookstore.bookshop.item.repository.ItemQueryRepository;
import bookstore.bookshop.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemQueryRepository itemQueryRepository;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public List<ItemDTO> search() {
        return itemQueryRepository.search()
                .stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }

    public void registration(RegistrationDTO registrationDTO) {
        String type = registrationDTO.getType();
        String categoryName = registrationDTO.getCategoryName();

        if (type.equals("A")) {
            Album album = new Album(registrationDTO);
            itemRepository.save(album);
            Category category = categoryRepository.findByName(categoryName);
            if (category != null) {
                category.addItems(album);
                if (category.getParent() != null) {
                    Category parent = category.getParent();
                    parent.addChildCategory(category);
                }
            } else {
                Category cate = new Category();
                cate.setName(categoryName);
                cate.addItems(album);
                categoryRepository.save(cate);
            }
        } else if (type.equals("B")) {
            Book book = new Book(registrationDTO);
            itemRepository.save(book);
            Category category = categoryRepository.findByName(categoryName);
            if (category != null) {
                category.addItems(book);
                if (category.getParent() != null) {
                    Category parent = category.getParent();
                    parent.addChildCategory(category);
                }
            } else {
                Category cate = new Category();
                cate.setName(categoryName);
                cate.addItems(book);
                categoryRepository.save(cate);
            }
        } else {
            Movie movie = new Movie(registrationDTO);
            itemRepository.save(movie);

            Category category = categoryRepository.findByName(categoryName);
            if (category != null) {
                category.addItems(movie);
                if (category.getParent() != null) {
                    Category parent = category.getParent();
                    parent.addChildCategory(category);
                }
            } else {
                Category cate = new Category();
                cate.setName(categoryName);
                cate.addItems(movie);
                categoryRepository.save(cate);
            }
        }
    }
}