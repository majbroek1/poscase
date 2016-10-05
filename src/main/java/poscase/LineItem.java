package poscase;

import lombok.Data;

/**
 * Created by maart on 20-9-2016.
 */
@Data
public class LineItem {
    private int lineid;
    private Product product;
    private int quantity;
    private Discount discount;

    public LineItem(Product product){
        this.product = product;
        this.quantity = 1;
    }

    public void addItem(){
        this.quantity++;
    }

    public void removeItem(){
        this.quantity--;
    }

    public float getSubTotal(){
        return product.getPrice() * quantity;
    }

}
