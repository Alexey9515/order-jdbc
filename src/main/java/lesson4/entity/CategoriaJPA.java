package lesson4.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoriaJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_parent")
    private Long parentId;

    @Column
    private String name;

    @Column(name = "system_name")
    private String systemName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "id_category"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<ProductJpa> products;

    @OneToMany
    @JoinColumn(name = "id_parent")
    private Set<CategoriaJPA> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Set<ProductJpa> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductJpa> products) {
        this.products = products;
    }

    public Set<CategoriaJPA> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriaJPA> categories) {
        this.categories = categories;
    }
}
