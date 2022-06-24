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

    public List<Product> allProductsByExpired() {

        String sql = "SELECT product FROM Product product WHERE product.created_date > current_date";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

   public List<Product> allProductsByNotExpired() {

        String sql = "SELECT product FROM Product product WHERE " +
                "product.created_date < current_date or product.created_date = null";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }
}
