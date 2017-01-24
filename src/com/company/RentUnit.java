package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heorhi_Boika on 1/20/2017.
 */
public class RentUnit {
    private HashMap<SportEquipment, Integer> units;

    public RentUnit() {
        units = new HashMap<>();
    }

    public boolean takeUnion(Shop shop, int count, String category, String title, int price) {
        if (shop.rentUnit(count, category, title, price)) {
            units.put(new SportEquipment(new Category(category), title, price), count);
            return true;
        } else {
            System.out.println("This thing not found in the shop or no enough goods int the shop");
        }
        return false;
    }

    public void goodsInRent() {
        System.out.println("Goods in rent");
        System.out.println("Category " + " Title " + " Price " + " Count ");
        for (Map.Entry<SportEquipment, Integer> entry : units.entrySet()) {
            System.out.println(entry.getKey().getCategory().toString() + " /" + entry.getKey().getTitle() + " /"
                    + entry.getKey().getPrice() + " /" + entry.getValue());
        }
    }
}
