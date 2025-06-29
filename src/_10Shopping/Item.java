package _10Shopping;

public class Item {
    String name, id;
    int price;

    public Item(String name, String id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemName: " + name + ", ItemId: " + id + ", ItemPrice: " + price;
    }
}
