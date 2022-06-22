package dao;

import base.BaseDao;
import dto.ProductCommentByUserIdDTO;
import dto.ProductCommentsByProductIdAndRangeOfDatesDTO;
import entity.ProductComment;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProductCommentDao extends BaseDao {

    public List<ProductComment> findAll() {
        Query query = getCurrentSession().createQuery("select pc from ProductComment pc");
        return query.list();
    }

    public List<ProductCommentsByProductIdAndRangeOfDatesDTO> findAllCommentsByProductId(Long productId) {

        String sql = "SELECT new dto.ProductCommentsByProductIdAndRangeOfDatesDTO (product.name, product.price, user.name, user.surname, " +
                "user.email, user.phone, productComment.comment, productComment.comment_date)" +
                " FROM ProductComment productComment" +
                " left join User user on productComment.userId = user" +
                " left join Product product on productComment.productId = product" +
                " where product.id = :productId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("productId", productId);

        return query.list();
    }

    public List<ProductCommentsByProductIdAndRangeOfDatesDTO> findAllCommentsByProductIdAndRangeOfDates(Long productId,
                                                                                                        Date firstDate,
                                                                                                        Date lastDate) {

        String sql = "SELECT new dto.ProductCommentsByProductIdAndRangeOfDatesDTO (product.name, product.price, user.name, " +
                "user.surname, user.email, user.phone, productComment.comment, productComment.comment_date)" +
                " FROM ProductComment productComment" +
                " left join User user on productComment.userId = user" +
                " left join Product product on productComment.productId = product" +
                " where (product.id = :productId and (productComment.comment_date between :firstDate and :lastDate))";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("productId", productId);
        query.setParameter("firstDate", firstDate);
        query.setParameter("lastDate", lastDate);

        return query.list();
    }

    public List<ProductCommentByUserIdDTO> findAllCommentsByUserId(Long userId) {

        String sql = "SELECT new dto.ProductCommentByUserIdDTO(user.id, user.name, productComment.productId.name, " +
                "productComment.comment, productComment.comment_date)" +
                " FROM ProductComment productComment" +
                " left join User user on productComment.userId = user " +
                " where user.id = :userId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("userId", userId);

        return query.list();
    }

    public List<ProductCommentByUserIdDTO> findAllCommentsByUserIdAndRangeOfDates(Long userId,
                                                                                  Date firstDate,
                                                                                  Date lastDate) {

        String sql = "SELECT new dto.ProductCommentByUserIdDTO(user.id, user.name, productComment.productId.name, " +
                "productComment.comment, productComment.comment_date)" +
                " FROM ProductComment productComment" +
                " left join User user on productComment.userId = user " +
                " where user.id = :userId and (productComment.comment_date between :firstDate and :lastDate)";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("firstDate", firstDate);
        query.setParameter("lastDate", lastDate);

        return query.list();
    }

}
