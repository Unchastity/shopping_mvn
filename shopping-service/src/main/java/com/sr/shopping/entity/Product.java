package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {


    private static final long serialVersionUID = 8096458386066297935L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    private Integer pid;

    @Column(name = "p_name", nullable = false)
    private String pName;

    @Column(name = "mark_price", nullable = false, scale = 2, precision = 8)
    private BigDecimal markPrice;

    @Column(name = "shop_price", nullable = false, scale = 2, precision = 8)
    private BigDecimal shopPrice;

    @Column(name = "inventory", nullable = false)
    private Integer inventory;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "p_desc")
    private String pDesc;

    @Column(name = "is_hot", nullable = false)
    private Integer isHot;

    @Column(name = "p_date", nullable = false)
    private Date pDate;

    @ManyToOne(targetEntity = CategorySecond.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "csid", referencedColumnName = "csid",
            foreignKey = @ForeignKey(name = "product_fk_category_second"), nullable = false)
    private CategorySecond categorySecond;

    @OneToMany(targetEntity = OrdersItem.class, mappedBy = "product")
    private Set<OrdersItem> ordersItems = new HashSet<>();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }

    public Set<OrdersItem> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(Set<OrdersItem> ordersItems) {
        this.ordersItems = ordersItems;
    }
}
