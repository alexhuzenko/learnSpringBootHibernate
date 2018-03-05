package com.ohuzenko.testShop.repository;

import com.ohuzenko.testShop.model.Categories;
import com.ohuzenko.testShop.model.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() { return sessionFactory.getCurrentSession();}


    public List<Goods> getAll() {
        //noinspection unchecked
        @SuppressWarnings("unchecked") List<Goods> goods = (List<Goods>)getSession()
                .createQuery("from Goods").getResultList();
        return goods;
    }

    public Goods getById(Long id) {
        return getSession().get(Goods.class, id);
    }

    public void addToCatalog(Long categoryId, Goods goods) {
        checkCategory(categoryId, goods).save(goods);
    }

    public void update(Goods goods) {
        checkCategory(goods.getCategory().getId(), goods).update(goods);
    }

    private Session checkCategory(Long categoryId, Goods goods) {
        Session session = getSession();
        Optional.ofNullable(session.get(Categories.class, categoryId))
                .map(p -> p.add(goods))
                .orElseThrow(() ->
                        new IllegalArgumentException("Cannot add goods to non existent category: "
                                + categoryId.toString()));
        return session;
    }

}
