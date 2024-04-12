package models;

public class VideoGame {
//    The video game object
    private String name;
    private int id;
    private String genre;
    private int qty;
    private float price;

    public VideoGame() {}

    public VideoGame(int id, String name, String genre, int qty, float price) {
        this.name = name;
        this.id = id;
        this.genre = genre;
        this.qty = qty;
        this.price = price;
    }

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

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
