package services;

import io.Console;
import models.ComicBook;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComicBookService {
//    Creates and manages comic books
    private int nextId = 1;
    private ArrayList<ComicBook> inventory = new ArrayList<>();

    public ComicBook create(String name, int qty, float price) {
        ComicBook createdComicBook = new ComicBook(nextId++, name, qty, price);
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

    public void writeData() throws IOException {
        String csvFile = "/Users/anthony/Documents/Projects/Product-Inventory-Lab/src/main/java/utils/comicbooks.csv";
        FileWriter writer = new FileWriter(csvFile);
//        Save the nextId value, so it can be read back in when loading the data.
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));

        for (ComicBook comic : inventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(comic.getId()));
            list.add(comic.getName());
            list.add(String.valueOf(comic.getQty()));
            list.add(String.valueOf(comic.getPrice()));

            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }

    public void loadData() {
        String csvFile = "/Users/anthony/Documents/Projects/Product-Inventory-Lab/src/main/java/utils/comicbooks.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            Begin setting the state of the service by reading in the first line which should equal the nextId value.
            nextId = Integer.parseInt(br.readLine());

            while ((line = br.readLine()) != null) {
                String[] comics = line.split(csvSplitBy);

//                For every line read in from the CSV file, the program will split the string values by a ','.
//                Then parsed into the proper data type if necessary.
                int id = Integer.parseInt(comics[0]);
                String name = comics[1];
                int qty = Integer.parseInt(comics[2]);
                float price = Float.parseFloat(comics[3]);

//                Create a new item using the CSV data to set the initial state and add it to the inventory.
                inventory.add(new ComicBook(id, name, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            Console.printErr("Error parsing data!");
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (inventory.isEmpty()) {
            return "Inventory is Empty";
        }
        for (ComicBook comic : inventory) {
            result += "Product ID: " + comic.getId() + "\n" +
                    "Name: " + comic.getName() + "\n" +
                    "Quantity: " + comic.getQty() + "\n" +
                    "Price: " + comic.getPrice() + "\n";
        }
        return result;
    }
}
