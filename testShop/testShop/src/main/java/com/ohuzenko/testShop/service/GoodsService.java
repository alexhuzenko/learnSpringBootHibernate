package com.ohuzenko.testShop.service;

import com.ohuzenko.testShop.model.Goods;
import com.ohuzenko.testShop.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    private GoodsRepository goodsRepository;

    @Autowired
    public GoodsService(GoodsRepository goodsRepository){
        this.goodsRepository = goodsRepository;
    }

    public Goods getById(String id) {
        return goodsRepository.getById(Long.valueOf(id));
    }

    public List<Goods> getAllGoods() {
        return goodsRepository.getAll();
    }

    public void persist(String categoryId, Goods goods) {
        goodsRepository.addToCatalog(Long.valueOf(categoryId), goods);
    }

    public void updateGoods(Goods goods) {
        goodsRepository.update(goods);
    }
}
