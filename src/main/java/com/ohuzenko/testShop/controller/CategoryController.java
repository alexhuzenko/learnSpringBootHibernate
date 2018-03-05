package com.ohuzenko.testShop.controller;

import com.ohuzenko.testShop.model.Categories;
import com.ohuzenko.testShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping(value="/")
    public List<Categories> getAll() {return categoryService.getAllCategories();}

    @GetMapping(value="/{id}")
    public Categories getById(@PathVariable String id){
        return categoryService.getById(id);
    }

    @PostMapping(value="/save")
    public void handleCategory(@RequestBody Categories category) {
        categoryService.persist(category);
    }

    @PostMapping(value="/update")
    public Categories updateCategory(@RequestBody Categories category){
        return categoryService.update(category);
    }
}
