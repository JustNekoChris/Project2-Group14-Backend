package com.project2.group14.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    private String name;
    private Double price;
    private String link;
    private String image_link;
    private Integer amount_wanted;
    private Integer amount_bought;
    private String description;
    private Boolean bought;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public Integer getAmount_wanted() {
        return amount_wanted;
    }

    public void setAmount_wanted(Integer amount_wanted) {
        this.amount_wanted = amount_wanted;
    }

    public Integer getAmount_bought() {
        return amount_bought;
    }

    public void setAmount_bought(Integer amount_bought) {
        this.amount_bought = amount_bought;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(productID, products.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }

    @Override
    public String toString() {
        return "products{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", link='" + link + '\'' +
                ", image_link='" + image_link + '\'' +
                ", amount_wanted=" + amount_wanted +
                ", amount_bought=" + amount_bought +
                ", description='" + description + '\'' +
                ", bought=" + bought +
                '}';
    }
}
