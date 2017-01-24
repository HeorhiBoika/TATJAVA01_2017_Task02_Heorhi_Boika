package com.company;

import java.util.Locale;

/**
 * Created by Heorhi_Boika on 1/20/2017.
 */
public class SportEquipment {
    private Category category;
    private String title;
    private int price;

    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category newCategory) {
        category = newCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int newPrice) {
        price = newPrice;
    }
}
