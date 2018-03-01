package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin_user")
public class AdminUser implements Serializable {

    private static final long serialVersionUID = -8192766742818356093L;

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Basic
    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;

    @Basic
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Basic
    @Column(name = "min_ventory", nullable = false)
    private Integer minVentroy;

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

    public Integer getMinVentroy() {
        return minVentroy;
    }

    public void setMinVentroy(Integer minVentroy) {
        this.minVentroy = minVentroy;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", minVentroy=" + minVentroy +
                '}';
    }
}
