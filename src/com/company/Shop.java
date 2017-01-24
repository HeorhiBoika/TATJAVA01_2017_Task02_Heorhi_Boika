package com.company;

import java.io.*;
import java.util.*;

/**
 * Created by Heorhi_Boika on 1/20/2017.
 */
public class Shop {
    private Map<SportEquipment, Integer> goods;
    private ArrayList<String> goodsFromFile;

    public Shop() {
        goodsFromFile = new ArrayList<>();
        goods = new HashMap<SportEquipment, Integer>();
    }

    public void readFromFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            goodsFromFile.add(s);
        }
    }

    public void splitString() {
        String[] string;
        String[][] stringGoods = new String[goodsFromFile.size()][4];
        for (int i = 0; i < goodsFromFile.size(); i++) {
            string = goodsFromFile.get(i).split(",");
            for (int j = 0; j < 4; j++) {
                stringGoods[i][j] = string[j].trim();
            }
        }

        for (int i = 0; i < stringGoods.length; i++) {

            goods.put(new SportEquipment(new Category(stringGoods[i][0]), stringGoods[i][1],
                    Integer.parseInt(stringGoods[i][2])), Integer.parseInt(stringGoods[i][3]));
        }

    }

    public void goodsInShop() {
        System.out.println("Goods in shop");
        System.out.println("Category " + " Title " + " Price " + " Count ");
        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
            System.out.println(entry.getKey().getCategory().toString() + " /" + entry.getKey().getTitle() + " /"
                    + entry.getKey().getPrice() + " /" + entry.getValue());
        }
        System.out.println("---------------");
    }

    public boolean rentUnit(int count, String category, String title, int price) {
        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
            if ((category.equals(entry.getKey().getCategory().toString())) & (title.equals(entry.getKey().getTitle()))
                    & (price == entry.getKey().getPrice())) {
                if (count <= entry.getValue()) {
                    entry.setValue(entry.getValue() - count);
                    return true;
                }
            }
        }
        return false;
    }
}
