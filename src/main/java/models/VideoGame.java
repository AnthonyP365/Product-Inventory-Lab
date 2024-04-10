package models;

public class VideoGame {
//    The video game object
    private String name;
    private int id;
    private String genre;
    private float price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
