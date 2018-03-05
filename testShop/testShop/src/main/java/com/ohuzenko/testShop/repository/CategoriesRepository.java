package com.ohuzenko.testShop.repository;

import com.ohuzenko.testShop.model.Categories;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoriesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() { return sessionFactory.getCurrentSession();}

    @SuppressWarnings("unchecked")
    public List<Categories> getAll() {

        List<Categories> categoriesList = (List<Categories>)getSession()
                .createQuery("from Categories")
                .getResultList();

        return categoriesList;
    }

    public Categories getById(Long id) {
        Categories category =  getSession().get(Categories.class, id);
        return category;
    }

    public Categories persist(Categories category) {
        getSession().save(category);
        return category;
    }

    public Categories update(Categories category) {
        getSession().update(category);
        return category;
    }

}
