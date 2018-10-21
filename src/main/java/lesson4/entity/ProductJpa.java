package lesson4.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private int articale;
    @Column
    private double price;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set<CategoriaJPA> categories;

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

    public Set<CategoriaJPA> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriaJPA> categories) {
        this.categories = categories;
    }
}
