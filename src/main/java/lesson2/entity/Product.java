package lesson2.entity;

import java.util.Set;

public class Product {

    private long id;
    private String name;
    private int articale;
    private double price;
    private Set<Categoria> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArticale() {
        return articale;
    }

    public void setArticale(int articale) {
        this.articale = articale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Categoria> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categoria> categories) {
        this.categories = categories;
    }
}
