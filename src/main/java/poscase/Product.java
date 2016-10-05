package poscase;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by maart on 19-9-2016.
 */
@Data
@NoArgsConstructor
public class Product {

    private int prodid;
    private String barcode;
    private String name;
    private String ean;
    private float price;
    private Collection<Product> subProducts = new ArrayList<Product>();

    public Product(int prodid, String barcode, String name, String ean, float price){
        this.prodid=prodid;
        this.barcode=barcode;
        this.name=name;
        this.ean=ean;
        this.price=price;
    }

    public void addSubProduct(Product product){
        subProducts.add(product);
    }

    public void removeSubProduct(Product product){
        try{
            subProducts.remove(product);
        }
        catch(Exception e){
            System.out.println("cannot remove product from product pack");
        }
    }
}
