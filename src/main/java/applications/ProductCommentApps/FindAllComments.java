package applications.ProductCommentApps;

import entity.Product;
import entity.ProductComment;
import entityservice.ProductCommentEntityService;
import entityservice.ProductEntityService;

import java.util.List;

public class FindAllComments {

    public static void main(String[] args) {

        ProductCommentEntityService service = new ProductCommentEntityService();
        List<ProductComment> commentsList = service.findAll();
        for (ProductComment comment : commentsList) {
            System.out.println(comment);
        }
    }
}
