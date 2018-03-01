package com.sr.shopping.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "wallet")
public class Wallet implements Serializable {

    private static final long serialVersionUID = -1128750935366018600L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wid")
    private Integer wid;

    @Column(name = "money", nullable = false, scale = 2, precision = 8)
    private BigDecimal money;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", referencedColumnName = "uid",
    foreignKey = @ForeignKey(name = "wallet_fk_user"), unique = true)
    private User user;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }
}
