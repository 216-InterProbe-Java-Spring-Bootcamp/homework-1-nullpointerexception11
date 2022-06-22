package entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_comment")
public class ProductComment {

    @SequenceGenerator(name = "generator", sequenceName = "URUN_YORUM_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "COMMENT", length = 500)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT", foreignKey = @ForeignKey(name = "FK_COMMENT_PRODUCT_ID"))
    private Product productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", foreignKey = @ForeignKey(name = "FK_COMMENT_USER_ID"))
    private User userId;

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

    public ProductComment(String comment, Date comment_date, Product productId, User userId) {
        this.comment = comment;
        this.comment_date = comment_date;
        this.productId = productId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ProductComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", comment_date=" + comment_date +
                ", productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
