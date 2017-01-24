package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Shop shop = new Shop();
        RentUnit rentUnit = new RentUnit();
        String path = "C:\\Users\\Heorhi_Boika\\IdeaProjects\\Task_2.0\\Input.txt";
        boolean checkReadFile = true;
        boolean checkNumberFormat = true;
        try {
            shop.readFromFile(path);
        } catch (IOException e) {
            System.out.println("Erro, file not found");
            checkReadFile = false;
        }
        if (checkReadFile) {
            shop.splitString();
            shop.goodsInShop();
            int count, price, totalCount = 0;
            String category, title;
            Scanner scanner = new Scanner(System.in);
            System.out.println("You can enter 3 different goods");
            String begin = "";
            try {
                while ((!begin.equals("finish")) & (totalCount != 3)) {
                    System.out.println("Enter 0 < Count < " + (4 - totalCount) + ", totalCount = " + totalCount
                            + " < 4, you can take " + (3 - totalCount) + " things");
                    count = 0;
                    count = scanner.nextInt();
                    if ((count <= 0) | (count > 3 - totalCount)) {
                        continue;
                    }
                    System.out.println("Category");
                    category = " ";
                    category = scanner.next();
                    System.out.println("title");
                    title = " ";
                    title = scanner.next();
                    System.out.println("price");
                    price = 0;
                    price = scanner.nextInt();
                    if (rentUnit.takeUnion(shop, count, category, title, price)) {
                        totalCount += count;
                    }
                    System.out.println("Enter 'any symbol' to continue or 'finish' for the end");
                    begin = scanner.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, price and count positive integer number");
                checkNumberFormat = false;
            } catch (InputMismatchException e) {
                System.out.println("Error, price and count positive integer number");
                checkNumberFormat = false;
            }
            if (checkNumberFormat) {
                shop.goodsInShop();
                rentUnit.goodsInRent();
            }
        }
    }
}
