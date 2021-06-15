package ru.whitegray.dot;

import lombok.Data;
import ru.whitegray.entity.Cart;

@Data
public class CartDot {
    private final Cart cart;
    private Long id;
    private Long buyer_id;
    private Long product_id;

}
