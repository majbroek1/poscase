package poscase.discounttypes;

import poscase.Discount;
import poscase.Product;

/**
 * Created by maart on 20-9-2016.
 */
public class AbsoluteDiscount extends Discount {

    private float priceModifier;
    private Product product;

    public AbsoluteDiscount(float priceModifier, Product product) {
        this.priceModifier = priceModifier;
        this.product = product;
    }

    public float calculateDiscount() {
        return (product.getPrice() - priceModifier);
    }


}
