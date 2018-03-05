package com.ohuzenko.testShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
public class Categories implements Serializable{


    @Id
    @Column(name="id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name_category")
    private String nameCategory;
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Column(name="parent_category_id")
    private Long parentCategoryId;
    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }


    @Column(name="description_category")
    private String descriptionCategory;
    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }


    @OneToMany( mappedBy = "category",
    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
    private List<Goods> goods;
    public List<Goods> getGoods() {
        return goods;
    }
    public void setGoods(List<Goods> goods){
        this.goods = goods;
    }

    //Bi-directional Link
    public Goods add(Goods tempGoods) {
        if(goods == null) {goods = new ArrayList<>();}
        goods.add(tempGoods);
        tempGoods.setCategory(this);
        return tempGoods;
    }

    public Categories() { }

    public Categories(String nameCategory, Long parentCategoryId, String descriptionCategory) {

        this.nameCategory = nameCategory;
        this.parentCategoryId = parentCategoryId;
        this.descriptionCategory = descriptionCategory;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                ", parentCategoryId=" + parentCategoryId +
                ", descriptionCategory='" + descriptionCategory + '\'' +
                ", goods=" + goods +
                '}';
    }
}
