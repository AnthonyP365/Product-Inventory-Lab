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
        for (int i = 0; i < inventory.size(); i++) {
            result[i] = inventory.get(i);
        }
        return result;
    }

    public boolean delete(int id) {
        for (VideoGame game : inventory) {
            if (game.getId() == id && id < inventory.size()) {
                inventory.remove(id);
                return true;
            } else if (game.getId() == id && id == inventory.size()) {
                inventory.remove(inventory.size()-1);
                return true;
            }
        }
        return false;
    }
}
