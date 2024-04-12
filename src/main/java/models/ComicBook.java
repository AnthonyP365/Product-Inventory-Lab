package models;

public class ComicBook {
//    The comic book object
    private String name;
    private int id;
    private int qty;
    private float price;

    public ComicBook() {}

    public ComicBook(int id, String name, int qty, float price) {
        this.name = name;
        this.id = id;
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
