package ru.whitegray.entity;

import lombok.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)
    private Long id;

    @Column(name="product_id")
    private Long product_id;


    @Column(name="quantity")
    private int quantity;

    @ManyToMany(mappedBy = "cart")
    private Set<User> users;

    public Cart(Long id, int quantity) {
    }


}
