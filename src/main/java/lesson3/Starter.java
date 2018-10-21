package lesson3;

import lesson3.entity.Categoria;
import lesson3.entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Starter {

    private static final SessionFactory ourSessionFactory;
    private static final StandardServiceRegistry registry;
    static {
        try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            Map<String, String> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/internet_shop");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "root");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgresPlusDialect");
            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Product.class);
            Metadata metadata = sources.getMetadataBuilder().build();
            ourSessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        List<Product> from_product = session.createQuery("from Product").list();
        for (Product product : from_product) {
            printProduct(product);
        }
        session.close();

        session = getSession();
        List<Categoria> from_categoria_ = session.createQuery("from Categoria").list();
        for (Categoria categoria : from_categoria_) {
            printCategory("", categoria);
        }
        session.close();
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void printProduct(Product product) {
        System.out.println("******************************************************************");
        System.out.println(String.format("Наименование: %s\nЦена: %s\nАртикль: %s"
                , product.getName()
                , product.getPrice()
                , product.getArticale()));
        System.out.println("Категории:");
        for (Categoria categoria : product.getCategories()) {
            System.out.print("\t" + categoria.getName() + "\t");
        }
        System.out.println("");

        System.out.println("******************************************************************\n");
    }

    private static void printCategory(String prefix, Categoria categoria) {
        if (prefix.isEmpty() && categoria.getParentId() != null) {
            return;
        }
        System.out.println(prefix + "******************************************************************");
        System.out.println(String.format(prefix + "Наименование: %s\n" + prefix + "Системное наименование: %s"
                , categoria.getName()
                , categoria.getSystemName()));
        if (categoria.getCategories().size() > 0) {
            System.out.println(prefix + "Подкатегории: ");
            for (Categoria categoria1 : categoria.getCategories()) {
                printCategory(prefix + "\t\t", categoria1);
            }
        }

        System.out.println(prefix + "******************************************************************\n");
    }
}
