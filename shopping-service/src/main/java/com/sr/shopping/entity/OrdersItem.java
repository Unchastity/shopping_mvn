package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "orders_item", catalog = "shopping")
public class OrdersItem implements Serializable {

    private static final long serialVersionUID = -8621696682522862030L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "sub_total", scale = 2, precision = 8, nullable = false)
    private BigDecimal subTotal;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "pid", referencedColumnName = "pid",
    foreignKey = @ForeignKey(name = "orders_item_fk_product"))
    private Product product;

    @ManyToOne(targetEntity = Orders.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "oid", referencedColumnName = "oid",
            foreignKey = @ForeignKey(name = "orders_item_fk_orders"))
    private Orders orders;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
