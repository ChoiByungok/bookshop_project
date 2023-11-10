package bookstore.bookshop.item.service;

import bookstore.bookshop.domain.Category;
import bookstore.bookshop.domain.CategoryItem;
import bookstore.bookshop.domain.item.Album;
import bookstore.bookshop.domain.item.Book;
import bookstore.bookshop.domain.item.Item;
import bookstore.bookshop.domain.item.Movie;
import bookstore.bookshop.item.dto.*;
import bookstore.bookshop.item.repository.CategoryItemRepository;
import bookstore.bookshop.item.repository.CategoryRepository;
import bookstore.bookshop.item.repository.ItemQueryRepository;
import bookstore.bookshop.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemQueryRepository itemQueryRepository;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryItemRepository categoryItemRepository;

    public List<ItemDTO> search() {
        return itemQueryRepository.search()
                .stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void registration(RegistrationDTO registrationDTO) {
        String type = registrationDTO.getType();
        String categoryName = registrationDTO.getCategoryName();
        String parentCategory = registrationDTO.getParentCategory();

        if (StringUtils.hasText(categoryName)) {
            if (type.equals("A")) {
                Album album = new Album(registrationDTO);
                itemRepository.save(album);
                Category parent = categoryRepository.findByName(parentCategory);
                CategoryItem categoryItem = new CategoryItem();
                Category category = getCategory(categoryName);
                if (parent != null) { // 상위 카테고리가 존재
                    categoryItem.setCategory(category);
                    categoryItem.setItem(album);
                    categoryItemRepository.save(categoryItem);

                    parent.addChildCategory(category);
                } else { //상위 카테고리가 존재하지 않음
                    categoryItem.setItem(album);
                    categoryItem.setCategory(category);
                    categoryItemRepository.save(categoryItem);
                }
            } else if (type.equals("B")) {
                Book book = new Book(registrationDTO);
                itemRepository.save(book);
                Category parent = categoryRepository.findByName(parentCategory);
                CategoryItem categoryItem = new CategoryItem();
                Category category = getCategory(categoryName);
                if (parent != null) {
                    categoryItem.setCategory(category);
                    categoryItem.setItem(book);
                    categoryItemRepository.save(categoryItem);

                    parent.addChildCategory(category);
                } else {
                    categoryItem.setItem(book);
                    categoryItem.setCategory(category);
                    categoryItemRepository.save(categoryItem);
                }
            } else if (type.equals("M")){
                Movie movie = new Movie(registrationDTO);
                itemRepository.save(movie);
                Category parent = categoryRepository.findByName(parentCategory);
                CategoryItem categoryItem = new CategoryItem();
                Category category = getCategory(categoryName);
                if (parent != null) {
                    categoryItem.setCategory(category);
                    categoryItem.setItem(movie);
                    categoryItemRepository.save(categoryItem);

                    parent.addChildCategory(category);
                } else {
                    categoryItem.setItem(movie);
                    categoryItem.setCategory(category);
                    categoryItemRepository.save(categoryItem);
                }
            }
        } else {
            if (type.equals("A")) {
                Album album = new Album(registrationDTO);
                itemRepository.save(album);
            } else if (type.equals("B")) {
                Book book = new Book(registrationDTO);
                itemRepository.save(book);
            } else if (type.equals("M")) {
                Movie movie = new Movie(registrationDTO);
                itemRepository.save(movie);
            }
        }
    }

    private Category getCategory(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        categoryRepository.save(category);
        return category;
    }

    public List<ItemResponseDTO> searchWithCategory() {
        List<Item> items = itemQueryRepository.searchWithCategory();
        List<ItemResponseDTO> responseDTOS = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Album) {
                AlbumResponseDTO albumResponseDTO = new AlbumResponseDTO((Album) item);
                responseDTOS.add(albumResponseDTO);
            } else if (item instanceof Book) {
                BookResponseDTO bookResponseDTO = new BookResponseDTO((Book) item);
                responseDTOS.add(bookResponseDTO);
            } else if (item instanceof Movie) {
                MovieResponseDTO movieResponseDTO = new MovieResponseDTO((Movie) item);
                responseDTOS.add(movieResponseDTO);
            }
        }
        return responseDTOS;
    }
}