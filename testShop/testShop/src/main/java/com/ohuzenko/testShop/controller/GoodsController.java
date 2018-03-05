package com.ohuzenko.testShop.controller;

import com.ohuzenko.testShop.model.Goods;
import com.ohuzenko.testShop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService){
        this.goodsService = goodsService;
    }

    @GetMapping(value="/")
    public List<Goods> getAll() {return goodsService.getAllGoods();}

    @GetMapping(value="/{id}")
    public Goods getById(@PathVariable String id){
        return goodsService.getById(id);
    }

    @PostMapping(value="/saveincategory/{categoryId}")
    public void persist(@PathVariable String categoryId, @RequestBody Goods goods) {
        goodsService.persist(categoryId, goods);
    }

    @PostMapping(value="/update")
    public void update(@RequestBody Goods goods) {
        goodsService.updateGoods(goods);
    }

}
