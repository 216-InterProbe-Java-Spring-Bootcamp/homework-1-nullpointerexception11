package entityservice;

import dao.ProductDao;
import entity.Product;

import java.util.List;

public class ProductEntityService {

    private final ProductDao productDao;

    public ProductEntityService() {
        productDao = new ProductDao();
    }

    public List<Product> findAllProduct() {
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findAById(id);
    }

    public List<Product> allProductByExpired() {
        return productDao.allProductsByExpired();
    }

    public List<Product> allProductByNotExpired() {
        return productDao.allProductsByNotExpired();
    }

}
