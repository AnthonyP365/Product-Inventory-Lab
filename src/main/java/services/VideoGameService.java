package services;

import models.VideoGame;
import java.util.ArrayList;

public class VideoGameService {
//    Creates and manages video games
    private int nextId = 1;
    private ArrayList<VideoGame> inventory = new ArrayList<>();

    public VideoGame create(String name, String genre, int qty, float price) {
        VideoGame createdVideoGame = new VideoGame(name, nextId++, genre, qty, price);
        inventory.add(createdVideoGame);
        return createdVideoGame;
    }

    public VideoGame findVideoGame(int id) {
        for (VideoGame game : inventory) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    public VideoGame[] findAll() {
        VideoGame[] result = new VideoGame[inventory.size()];
        int i = 0;
        for (VideoGame game : inventory) {
            result[i] = game;
            i++;
        }
        return result;
    }

    public boolean delete(int id) {
        for (VideoGame game : inventory) {
            if (game.getId() == id) {
                inventory.remove(game);
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
        for (VideoGame videoGame : inventory) {
            result = "Product ID: " + videoGame.getId() + "\n" +
                    "Name: " + videoGame.getName() + "\n" +
                    "Genre: " + videoGame.getGenre() + "\n" +
                    "Quantity: " + videoGame.getQty() + "\n" +
                    "Price: " + videoGame.getPrice() + "\n";
        }
        return result;
    }
}
