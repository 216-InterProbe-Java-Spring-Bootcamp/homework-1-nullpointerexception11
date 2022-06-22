package dao;

import base.BaseDao;
import entity.Product;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDao extends BaseDao {

    public List<Product> findAll() {

        String sql = "SELECT product FROM Product product";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    public Product findAById(Long id) {

        String sql = "SELECT product FROM Product product WHERE product.id = :givenId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("givenId", id);

        return (Product) query.uniqueResult();
    }

    List<Product> allProductsByPastExpiredDate() {

        String sql = "SELECT product FROM Product product WHERE product.expiration_date > current_date";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    List<Product> allProductsByNotPastExpiredDate() {

        String sql = "SELECT product FROM Product product WHERE product.expiration_date < current_date";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }
}
