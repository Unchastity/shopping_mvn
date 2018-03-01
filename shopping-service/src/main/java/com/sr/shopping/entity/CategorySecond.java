package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category_second")
public class CategorySecond implements Serializable {

    private static final long serialVersionUID = 2862506537983711071L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "csid", nullable = false)
    private Integer csid;

    @Basic
    @Column(name = "cs_name", nullable = false)
    private String csName;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", referencedColumnName = "cid",
            foreignKey = @ForeignKey(name = "category_second_fk_category"))
    private Category category;

    @OneToMany(targetEntity = Product.class, mappedBy = "categorySecond")
    private Set<Product> products = new HashSet<>();

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
