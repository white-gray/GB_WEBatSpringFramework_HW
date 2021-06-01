package ru.whitegray.dot;

import ru.whitegray.entity.Cart;


public class CartDot {
    private final Cart cart;
    private Long id;
    private Long buyer_id;
    private Long product_id;

    public CartDot(String name, float price, Cart cart) {
        this.cart = cart;
        this.buyer_id = buyer_id;
        this.product_id = product_id;
    }

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




    public String toString () {
        return "\tCath:\tid: " + id+"\t\tbuyer_id= "+buyer_id+"\t\tproduct_id="+product_id;
    }
}
