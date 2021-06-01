package ru.whitegray.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)
    private Long id;

    @Column(name="buyer_id")
    private Long buyer_id;

    @Column(name="product_id")
    private Long product_id;


    @Column(name="quantity")
    private int quantity;

    public Cart(Long name, Long price, int quantity) {
        this.buyer_id = buyer_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Cart() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    public String toString () {
        return "\tCath:\tid: " + id+"\t\tbuyer_id= "+buyer_id+"\t\tproduct_id="+product_id;
    }
}
