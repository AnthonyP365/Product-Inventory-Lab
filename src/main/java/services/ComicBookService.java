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
        for (int i = 0; i < inventory.size(); i++) {
            result[i] = inventory.get(i);
        }
        return result;
    }

    public boolean delete(int id) {
        for (ComicBook comic : inventory) {
            if (comic.getId() == id && id < inventory.size()) {
                inventory.remove(id);
                return true;
            } else if (comic.getId() == id && id == inventory.size()) {
                inventory.remove(inventory.size()-1);
                return true;
            }
        }
        return false;
    }
}
