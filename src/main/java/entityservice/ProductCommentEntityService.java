package entityservice;

import dao.ProductCommentDao;
import dto.ProductCommentByUserIdDTO;
import dto.ProductCommentsByProductIdAndRangeOfDatesDTO;
import entity.ProductComment;

import java.util.Date;
import java.util.List;

public class ProductCommentEntityService {

    private final ProductCommentDao productCommentDao;

    public ProductCommentEntityService() {
        productCommentDao = new ProductCommentDao();
    }

    public List<ProductComment> findAll(){
        return productCommentDao.findAll();
    }

    public List<ProductCommentsByProductIdAndRangeOfDatesDTO> findAllCommentsByProductId(Long productId){
        return productCommentDao.findAllCommentsByProductId(productId);
    }

    public List<ProductCommentsByProductIdAndRangeOfDatesDTO> findAllCommentsByProductIdAndRangeOfDates(Long productId,
                                                                                                        Date firstDate,
                                                                                                        Date lastDate) {
        return productCommentDao.findAllCommentsByProductIdAndRangeOfDates(productId, firstDate, lastDate);
    }

    public List<ProductCommentByUserIdDTO> findAllCommentsByUserId(Long userId){
        return productCommentDao.findAllCommentsByUserId(userId);
    }

    public List<ProductCommentByUserIdDTO> findAllCommentsByUserIdAndRangeOfDates(Long userId,
                                                                                  Date firstDate,
                                                                                  Date lastDate){
        return productCommentDao.findAllCommentsByUserIdAndRangeOfDates(userId, firstDate, lastDate);
    }
}
