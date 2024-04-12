package services;

import models.ComicBook;
import models.VideoGame;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoGameService {
//    Creates and manages video games
    private int nextId = 1;
    private ArrayList<VideoGame> inventory = new ArrayList<>();

    public VideoGame create(String name, String genre, int qty, float price) {
        VideoGame createdVideoGame = new VideoGame(nextId++, name, genre, qty, price);
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

    public void writeData() throws IOException {
        String csvFile = "/Users/anthony/Documents/Projects/Product-Inventory-Lab/src/main/java/utils/videogames.csv";
        FileWriter writer = new FileWriter(csvFile);
//        Save the nextId value, so it can be read back in when loading the data.
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));

        for (VideoGame game : inventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(game.getId()));
            list.add(game.getName());
            list.add(game.getGenre());
            list.add(String.valueOf(game.getQty()));
            list.add(String.valueOf(game.getPrice()));

            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }

    public void loadData() {
        String csvFile = "/Users/anthony/Documents/Projects/Product-Inventory-Lab/src/main/java/utils/videogames.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            Begin setting the state of the service by reading in the first line which should equal the nextId value.
            nextId = Integer.parseInt(br.readLine());

            while ((line = br.readLine()) != null) {
                String[] games = line.split(csvSplitBy);

//                For every line read in from the CSV file, the program will split the string values by a ','.
//                Then parsed into the proper data type if necessary.
                int id = Integer.parseInt(games[0]);
                String name = games[1];
                String genre = games[2];
                int qty = Integer.parseInt(games[3]);
                float price = Float.parseFloat(games[4]);

//                Create a new item using the CSV data to set the initial state and add it to the inventory.
                inventory.add(new VideoGame(id, name, genre, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (inventory.isEmpty()) {
            return "Inventory is Empty";
        }
        for (VideoGame videoGame : inventory) {
            result += "Product ID: " + videoGame.getId() + "\n" +
                    "Name: " + videoGame.getName() + "\n" +
                    "Genre: " + videoGame.getGenre() + "\n" +
                    "Quantity: " + videoGame.getQty() + "\n" +
                    "Price: " + videoGame.getPrice() + "\n\n";
        }
        return result;
    }
}
