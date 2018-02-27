package com.sr.shopping.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "packet", catalog = "shopping")
public class Packet implements Serializable {

    private static final long serialVersionUID = 3283969481081053020L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", referencedColumnName = "uid",
    foreignKey = @ForeignKey(name = "packet_fk_user"), unique = true)
    private User user;

    @OneToMany(targetEntity = Ticket.class, mappedBy = "packet", cascade = CascadeType.REFRESH)
    private Set<Ticket> tickets = new HashSet<>();


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
