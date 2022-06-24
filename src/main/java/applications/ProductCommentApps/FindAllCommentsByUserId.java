package applications.ProductCommentApps;

import dto.ProductCommentByUserIdDTO;
import dto.ProductCommentsByProductIdAndRangeOfDatesDTO;
import entityservice.ProductCommentEntityService;

import java.util.List;

public class FindAllCommentsByUserId {

    public static void main(String[] args) {

        ProductCommentEntityService service = new ProductCommentEntityService();
        List<ProductCommentByUserIdDTO> commentsList = service.findAllCommentsByUserId(1L);
        for (ProductCommentByUserIdDTO comment : commentsList) {
            System.out.println(comment);
        }
    }
}
