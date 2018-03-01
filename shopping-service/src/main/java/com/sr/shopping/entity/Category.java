package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 4177071387207806002L;
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Basic
    @Column(name = "c_name", length = 255, nullable = false)
    private String cName;

    @Basic
    @Column(name = "discount", scale = 2, precision = 3, nullable = false)
    private BigDecimal discount;

    @Basic
    @Column(name = "privilege_time", nullable = true)
    private Date privilegeTime;

    @OneToMany(targetEntity = CategorySecond.class, mappedBy = "category",
            fetch = FetchType.EAGER)
    private Set<CategorySecond> categorySecondList = new HashSet<>();

    @OneToMany(targetEntity = Ticket.class, mappedBy = "packet", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getPrivilegeTime() {
        return privilegeTime;
    }

    public void setPrivilegeTime(Date privilegeTime) {
        this.privilegeTime = privilegeTime;
    }

    public Set<CategorySecond> getCategorySecondList() {
        return categorySecondList;
    }

    public void setCategorySecondList(Set<CategorySecond> categorySecondList) {
        this.categorySecondList = categorySecondList;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
