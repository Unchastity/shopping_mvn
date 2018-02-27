package com.sr.shopping.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ticket", catalog = "shopping")
public class Ticket implements Serializable {

    private static final long serialVersionUID = -7857809412648786751L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Integer tid;

    @Column(name = "privilege", scale = 2, precision = 4, nullable = false)
    private BigDecimal privilege;

    @Column(name = "consume", scale = 2, precision = 6, nullable = false)
    private BigDecimal consume;

    @Column(name = "use_time_max")
    private Date useTimeMax;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cid", referencedColumnName = "cid",
    foreignKey = @ForeignKey(name = "ticket_fk_category"), nullable = false)
    private Category category;

    @ManyToOne(targetEntity = Packet.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "pid", referencedColumnName = "pid",
            foreignKey = @ForeignKey(name = "ticket_fk_packet"), nullable = false)
    private Packet packet;

    @Column(name = "use_time")
    private Date useTime;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public BigDecimal getPrivilege() {
        return privilege;
    }

    public void setPrivilege(BigDecimal privilege) {
        this.privilege = privilege;
    }

    public BigDecimal getConsume() {
        return consume;
    }

    public void setConsume(BigDecimal consume) {
        this.consume = consume;
    }

    public Date getUseTimeMax() {
        return useTimeMax;
    }

    public void setUseTimeMax(Date useTimeMax) {
        this.useTimeMax = useTimeMax;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
}
