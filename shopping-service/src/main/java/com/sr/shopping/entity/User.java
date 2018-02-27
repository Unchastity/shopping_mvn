package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", catalog = "shopping")
public class User implements Serializable {

    private static final long serialVersionUID = 6263037522236831352L;
    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Basic
    @Column(name = "user_name", nullable = false)
    private String userName;

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

    @OneToMany(targetEntity = Wallet.class, mappedBy = "user")
    private Set<Wallet> wallets = new HashSet<>();

    @OneToMany(targetEntity = Packet.class, mappedBy = "user")
    private Set<Packet> packets = new HashSet<>();

    @OneToMany(targetEntity = Orders.class, mappedBy = "user",
            fetch = FetchType.LAZY)
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

    public Set<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(Set<Wallet> wallets) {
        this.wallets = wallets;
    }

    public Set<Packet> getPackets() {
        return packets;
    }

    public void setPackets(Set<Packet> packets) {
        this.packets = packets;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
