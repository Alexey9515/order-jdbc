package lesson4;

import lesson4.entity.CategoriaJPA;
import lesson4.entity.ProductJpa;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Environment;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashMap;
import java.util.Map;

public class Starter {

    @PersistenceContext
    private static final EntityManagerFactory entityManagerFactory;

    static {
        Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/internet_shop");
        settings.put(Environment.USER, "postgres");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgresPlusDialect");
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-name", settings);

//        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-name");

    }

    public static EntityManager getEntityManager() throws HibernateException {
        return entityManagerFactory.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductJpa> cq = cb.createQuery(ProductJpa.class);
        CriteriaQuery<ProductJpa> all = cq.select(cq.from(ProductJpa.class));
        TypedQuery<ProductJpa> allQuery = em.createQuery(all);
        for (ProductJpa product : allQuery.getResultList()) {
            printProduct(product);
        }
        em.close();
        entityManagerFactory.close();
    }

    private static void printProduct(ProductJpa product) {
        System.out.println("******************************************************************");
        System.out.println(String.format("Наименование: %s\nЦена: %s\nАртикль: %s"
                , product.getName()
                , product.getPrice()
                , product.getArticale()));
        System.out.println("Категории:");
        for (CategoriaJPA categoriaJPA : product.getCategories()) {
            System.out.print("\t" + categoriaJPA.getName() + "\t");
        }
        System.out.println("");

        System.out.println("******************************************************************\n");
    }

    private static void printCategory(String prefix, CategoriaJPA categoriaJPA) {
        if (prefix.isEmpty() && categoriaJPA.getParentId() != null) {
            return;
        }
        System.out.println(prefix + "******************************************************************");
        System.out.println(String.format(prefix + "Наименование: %s\n" + prefix + "Системное наименование: %s"
                , categoriaJPA.getName()
                , categoriaJPA.getSystemName()));
        if (categoriaJPA.getCategories().size() > 0) {
            System.out.println(prefix + "Подкатегории: ");
            for (CategoriaJPA categoriaJPA1 : categoriaJPA.getCategories()) {
                printCategory(prefix + "\t\t", categoriaJPA1);
            }
        }

        System.out.println(prefix + "******************************************************************\n");
    }
}
