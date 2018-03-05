package com.ohuzenko.testShop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="goods")
public class Goods implements Serializable{

    @Id
    @Column(name="id_goods")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name_goods")
    private String nameGoods;

    @Column(name="description_goods")
    private String descriptionGoods;

    @Column(name="price_goods")
    private Double priceGoods;

    @Column(name="amount_goods")
    private Long amountGoods;

    public Goods() {
    }

    public Goods(String nameGoods, String descriptionGoods, Double priceGoods, Long amountGoods) {
        this.nameGoods = nameGoods;
        this.descriptionGoods = descriptionGoods;
        this.priceGoods = priceGoods;
        this.amountGoods = amountGoods;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_category")
    //@JsonIgnore
    private Categories category;
    public Categories getCategory() {
        return category;
    }
    public void setCategory(Categories category) {
        this.category = category;
    }


    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public String getDescriptionGoods() {
        return descriptionGoods;
    }

    public void setDescriptionGoods(String descriptionGoods) {
        this.descriptionGoods = descriptionGoods;
    }

    public Double getPriceGoods() {
        return priceGoods;
    }

    public void setPriceGoods(Double priceGoods) {
        this.priceGoods = priceGoods;
    }

    public Long getAmountGoods() {
        return amountGoods;
    }

    public void setAmountGoods(Long amountGoods) {
        this.amountGoods = amountGoods;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", nameGoods='" + nameGoods + '\'' +
                ", descriptionGoods='" + descriptionGoods + '\'' +
                ", priceGoods=" + priceGoods +
                ", amountGoods=" + amountGoods +
                ", category=" + category +
                '}';
    }
}
