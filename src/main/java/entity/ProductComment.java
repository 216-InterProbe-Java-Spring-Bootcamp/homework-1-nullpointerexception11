package entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCTS_COMMENTS")
public class ProductComment {

    @SequenceGenerator(name = "generator", sequenceName = "URUN_YORUM_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "FK_COMMENT_PRODUCT_ID"))
    private Product productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_COMMENT_USER_ID"))
    private User userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COMMENT_DATE")
    private Date comment_date;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "COMMENT", length = 500)
    private String comment;

    public ProductComment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public ProductComment(Long id, Product productId, User userId, Date comment_date, String comment) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.comment_date = comment_date;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ProductComment{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", comment_date=" + comment_date +
                ", comment='" + comment + '\'' +
                '}';
    }
}
