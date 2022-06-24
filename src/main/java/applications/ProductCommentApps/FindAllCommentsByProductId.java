package applications.ProductCommentApps;

import dto.ProductCommentsByProductIdAndRangeOfDatesDTO;
import entityservice.ProductCommentEntityService;

import java.util.List;

public class FindAllCommentsByProductId {

    public static void main(String[] args) {

        ProductCommentEntityService service = new ProductCommentEntityService();
        List<ProductCommentsByProductIdAndRangeOfDatesDTO> commentsList = service.findAllCommentsByProductId(1L);
        for (ProductCommentsByProductIdAndRangeOfDatesDTO comment : commentsList) {
            System.out.println(comment);
        }
    }
}
