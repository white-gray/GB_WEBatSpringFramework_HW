package ru.whitegray.entity;



import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)
    private Long id;

    @Column(name="name", length=255)
    private String name;

    @Column(name="price", precision=2)
    private float price;

    public Product(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString () {
        System.out.println("\tid: " + id+"\t\tname= "+name+"\t\tprice="+price);
        return null;
    }
}
