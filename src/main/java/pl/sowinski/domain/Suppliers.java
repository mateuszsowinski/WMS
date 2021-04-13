package pl.sowinski.domain;

public class Suppliers {
    private int id;
    private String name;

    public Suppliers(String name) {
        this.name = name;
    }

    public Suppliers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
