package com.project2.group14.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "wishlists")
public class Wishlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlistID;
    private Integer userID;
    private String wishlistName;

    public Integer getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(Integer wishlistsID) {
        this.wishlistID = wishlistsID;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlists wishlists = (Wishlists) o;
        return Objects.equals(wishlistID, wishlists.wishlistID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishlistID);
    }

    @Override
    public String toString() {
        return "Wishlists{" +
                "wishlistID=" + wishlistID +
                ", userID=" + userID +
                ", wishlistName='" + wishlistName + '\'' +
                '}';
    }
}
