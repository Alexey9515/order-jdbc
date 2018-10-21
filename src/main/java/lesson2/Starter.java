package lesson2;

import lesson2.entity.Categoria;
import lesson2.entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Starter {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
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
        Thread.currentThread().interrupt();
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
