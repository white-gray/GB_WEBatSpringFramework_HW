package ru.whitegray.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)
    private Long id;

    @Column(name="firstname", length=255)
    private String firstname;

    @Column(name="secondname", precision=2)
    private String secondname;

    @Column(name="cash", precision=2)
    private float cash;

//    public Buyer(String firstname, String secondname, float cash) {
//        this.firstname = firstname;
//        this.secondname = secondname;
//        this.cash = cash;
//    }
//
//    public Buyer() {
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
    public String getSecondname() {
        return secondname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }



    @ManyToMany
    @JoinTable(
            name = "cart",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")

    )
    private List<Product> productsList;


    public String toString () {
        return "\tBuyer:\tid: " + id+"\t\tFirst Name = "+firstname+"\t\tSeconr Name = "+secondname + "\t\tcash = " + cash ;
    }
}
