package com.sr.shopping.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 6263037522236831352L;
    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @NotEmpty
    @Basic
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotEmpty
    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "real_name", nullable = false)
    private String realName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone", length = 16, nullable = false)
    private String phone;

    @Basic
    @Column(name = "age")
    private Integer age;

    @Basic
    @Column(name = "addr")
    private String addr;

    @Basic
    @Column(name = "status", nullable = false)
    private Integer status;

    @Basic
    @Column(name = "code", length = 64, nullable = false)
    private String code;

    @Basic
    @Column(name = "home_addr")
    private String homeAddr;

    @OneToOne(targetEntity = Wallet.class, mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private Wallet wallet;

//    @OneToOne(targetEntity = Packet.class, mappedBy = "user", fetch = FetchType.EAGER)
    @Transient
    private Packet packet;

//    @OneToMany(targetEntity = Orders.class, mappedBy = "user",
//            fetch = FetchType.LAZY)
    @Transient
    private Set<Orders> orders = new HashSet<>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
