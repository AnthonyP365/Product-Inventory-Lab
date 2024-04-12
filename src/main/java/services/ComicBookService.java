package services;

import models.ComicBook;
import java.util.ArrayList;

public class ComicBookService {
//    Creates and manages comic books
    private int nextId = 1;
    private ArrayList<ComicBook> inventory = new ArrayList<>();

    public ComicBook create(String name, int qty, float price) {
        ComicBook createdComicBook = new ComicBook(name, nextId++, qty, price);
        inventory.add(createdComicBook);
        return createdComicBook;
    }

    public ComicBook findComicBook(int id) {
        for (ComicBook comic : inventory) {
            if (comic.getId() == id) {
                return comic;
            }
        }
        return null;
    }

    public ComicBook[] findAll() {
        ComicBook[] result = new ComicBook[inventory.size()];
        int i = 0;
        for (ComicBook comic : inventory) {
            result[i] = comic;
            i++;
        }
        return result;
    }

    public boolean delete(int id) {
        for (ComicBook comic : inventory) {
            if (comic.getId() == id) {
                inventory.remove(comic);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        if (inventory.isEmpty()) {
            return "Inventory is Empty";
        }
        for (ComicBook comic : inventory) {
            result = "Product ID: " + comic.getId() + "\n" +
                    "Name: " + comic.getName() + "\n" +
                    "Quantity: " + comic.getQty() + "\n" +
                    "Price: " + comic.getPrice() + "\n";
        }
        return result;
    }
}
