package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{

    private static final long serialVersionUID = -6155215961274894476L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    private Integer oid;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "buyer_addr")
    private String buyerAddr;

    @Column(name = "order_time")
    private Date orderTime;

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "total", scale = 2, precision = 8, nullable = false)
    private BigDecimal total;

    @Column(name = "seller_addr")
    private String sellerAddr;

    @Column(name = "order_time_complete")
    private Date orderTimeComplete;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "uid", referencedColumnName = "uid",
            foreignKey = @ForeignKey(name = "orders_fk_user"), nullable = false)
    private User user;

    @OneToMany(targetEntity = OrdersItem.class, mappedBy = "orders")
    private Set<OrdersItem> ordersItems = new HashSet<>();

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddr() {
        return buyerAddr;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSellerAddr() {
        return sellerAddr;
    }

    public void setSellerAddr(String sellerAddr) {
        this.sellerAddr = sellerAddr;
    }

    public Date getOrderTimeComplete() {
        return orderTimeComplete;
    }

    public void setOrderTimeComplete(Date orderTimeComplete) {
        this.orderTimeComplete = orderTimeComplete;
    }
}
