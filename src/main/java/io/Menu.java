package io;

import models.ComicBook;
import models.VideoGame;
import services.ComicBookService;
import services.VideoGameService;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Menu {
    private static ComicBookService comics = new ComicBookService();
    private static VideoGameService games = new VideoGameService();

    public static void mainMenu() throws IOException {
        boolean end = false;
        while (!end) {
            String input = Console.userInput("\n** Main Menu **\n\n" +
                    "Please select from our options below:\n" +
                    "1: Comic Book Inventory\n" +
                    "2: Video Game Inventory\n" +
                    "3: Exit\n");

            switch (input) {
                case "1":
                    comicBookMenu();
                    break;
                case "2":
                    videoGameMenu();
                    break;
                case "3":
                    exit();
                    break;
                default:
                    Console.printErr("Invalid input! Please select 1 or 2.");
            }
        } // end of main while loop
    }

    public static void comicBookMenu() throws IOException {
        comics.loadJSON();
        boolean end = false;
        while (!end) {
            String input = Console.userInput("\n** Comic Book Inventory Services **\n\n" +
                    "Please select an option:\n" +
                    "1. Inventory Snapshot\n" +
                    "2. Save Inventory\n" +
                    "3. Update Products\n" +
                    "4. Add Products\n" +
                    "5. Delete Products\n" +
                    "6. Go Back\n" +
                    "7. Exit\n");

            switch (input) {
                case "1":
                    Console.printOut("\nInventory: " + comics.findAll().length + "\n" + comics.toString());
                    break;

                case "2":
                    comics.writeJSON();
                    break;

                case "3":
                    String update = Console.userInput("Input product ID of item to update:\n");
                    ComicBook comic = comics.findComicBook(parseInt(update));
                    String update2 = Console.userInput("Input parameter you would like to update:\n" +
                            "Name(n), Quantity(q), Price(p), any other button to Go Back\n");
                    if (update2.equals("n")) {
                        String newName = Console.userInput("Change name:\n");
                        comic.setName(newName);
                    } else if (update2.equals("q")) {
                        String newQty = Console.userInput("Change quantity:\n");
                        comic.setQty(parseInt(newQty));
                    } else if (update2.equals("p")) {
                        String newPrice = Console.userInput("Change price:\n");
                        comic.setPrice(parseFloat(newPrice));
                    } else {
                        Console.printErr("Invalid input! Try again.");
                    }
                    break;

                case "4":
                    String name = Console.userInput("Input name of comic to add:\n");
                    String quantity = Console.userInput("Input the quantity of this comic to add into inventory:\n");
                    String price = Console.userInput("Input the price of this comic:\n");
                    comics.create(name, parseInt(quantity), parseFloat(price));
                    Console.printOut("You've added " + quantity + " of comic " + name + " at a price of " + price + "\n");
                    break;

                case "5":
                    String delete = Console.userInput("Input product ID of item to be deleted:\n");
                    comics.delete(parseInt(delete));
                    break;

                case "6":
                    end = true;
                    break;

                case "7":
                    System.exit(0);
                    break;

                default:
                    Console.printErr("Invalid input! Try again");
            }
        }
    }

    public static void videoGameMenu() throws IOException {
        games.loadData();
        boolean end = false;
        while (!end) {
            String input = Console.userInput("\n** Video Game Inventory **\n\n" +
                    "Please select an option:\n" +
                    "1. Inventory Snapshot\n" +
                    "2. Save Inventory\n" +
                    "3. Update Products\n" +
                    "4. Add Products\n" +
                    "5. Delete Products\n" +
                    "6. Go Back\n" +
                    "7. Exit\n");

            switch (input) {
                case "1":
                    Console.printOut("\nInventory: " + games.findAll().length + "\n\n" + games.toString());
                    break;

                case "2":
                    games.writeData();
                    break;

                case "3":
                    String update = Console.userInput("Input product ID of item to update:\n");
                    VideoGame game = games.findVideoGame(parseInt(update));
                    String update2 = Console.userInput("Input parameter you would like to update:\n" +
                            "Name(n), Genre(g), Quantity(q), Price(p), any other button to Go Back\n");
                    if (update2.equals("n")) {
                        String newName = Console.userInput("Change name:\n");
                        game.setName(newName);
                    } else if (update2.equals("g")) {
                        String newGenre = Console.userInput("Change genre:\n");
                        game.setGenre(newGenre);
                    } else if (update2.equals("q")) {
                        String newQty = Console.userInput("Change quantity:\n");
                        game.setQty(parseInt(newQty));
                    } else if (update2.equals("p")) {
                        String newPrice = Console.userInput("Change price:\n");
                        game.setPrice(parseFloat(newPrice));
                    } else {
                        Console.printErr("Invalid input! Try again.");
                    }
                    break;

                case "4":
                    String name = Console.userInput("Input name of video game to add:\n");
                    String genre = Console.userInput("Input the genre of this video game:\n");
                    String quantity = Console.userInput("Input the quantity of this video game to add into inventory:\n");
                    String price = Console.userInput("Input the price of this video game:\n");
                    games.create(name, genre, parseInt(quantity), parseFloat(price));
                    Console.printOut("You've added " + quantity + " of video game " + name + " at a price of " + price + "\n");
                    break;

                case "5":
                    String delete = Console.userInput("Input product ID of item to be deleted:\n");
                    games.delete(parseInt(delete));
                    break;

                case "6":
                    end = true;
                    break;

                case "7":
                    System.exit(0);
                    break;

                default:
                    Console.printErr("Invalid input! Try again");
            }
        }
    }

    public static void exit() {
        Console.printOut("\nGood Bye");
        System.exit(0);
    }
}
