package com.ohuzenko.testShop.service;

import com.ohuzenko.testShop.model.Categories;
import com.ohuzenko.testShop.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class CategoryService {

    private CategoriesRepository categoriesRepository;

    @Autowired
    public CategoryService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    public Categories getById(String id) {
        return categoriesRepository.getById(Long.valueOf(id));
    }

    public List<Categories> getAllCategories() {
        List<Categories> categoriesList = categoriesRepository.getAll();
        return categoriesList;
    }


    public void persist(Categories category) {
        checkParentCategoryIsValid(category);
        categoriesRepository.persist(category);
    }

    public Categories update(Categories category) {
        checkParentCategoryIsValid(category);
        return categoriesRepository.update(category);

    }

    private void checkParentCategoryIsValid(Categories category) {
        ofNullable(category.getParentCategoryId())
                .ifPresent(id -> Optional.ofNullable(categoriesRepository.getById(id))
                        .orElseThrow(
                                () -> new IllegalArgumentException("Category cannot be saved under non existing parent category"))
                );
    }

}
