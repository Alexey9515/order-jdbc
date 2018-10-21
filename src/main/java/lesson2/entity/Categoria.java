package lesson2.entity;

import java.util.Set;

public class Categoria {

    private Long id;
    private Long parentId;
    private String name;
    private String systemName;
    private Set<Product> products;
    private Set<Categoria> categories;

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Categoria> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categoria> categories) {
        this.categories = categories;
    }
}
