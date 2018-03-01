package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warn")
public class Warn implements Serializable {


    private static final long serialVersionUID = 1666673162716110054L;
    @Id
    @Column(name = "mid")
    private Integer mid;

    @Basic
    @Column(name = "min_ventory", nullable = false)
    private Integer minVentory;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMinVentory() {
        return minVentory;
    }

    public void setMinVentory(Integer minVentory) {
        this.minVentory = minVentory;
    }
}
