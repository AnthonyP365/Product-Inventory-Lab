package models;

public class ComicBook {
//    The comic book object
    private String name;
    private int id;
    private float price;

    public ComicBook() {}

    public ComicBook(String name, int id, float price) {
        this.name = name;
        this.id = id;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
