package applications.ProductApps;

import entity.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class FindByNotExpiredDate {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.allProductByNotExpired();
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
