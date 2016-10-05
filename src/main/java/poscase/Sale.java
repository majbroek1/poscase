package poscase;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by maart on 20-9-2016.
 */
@Data
public class Sale extends Transaction {

    @Override
    public void outPut(){
        System.out.println("Sale");
        if (customer != null){
            StringBuilder sb = new StringBuilder();
            sb.append("Naam klant: ");
            sb.append(customer.getName());
            sb.append(" ");
            sb.append(customer.getLastName());
            System.out.println(sb);
        }
        for (LineItem item: lineItems){
            StringBuilder sb = new StringBuilder();
            sb.append("Product:");
            sb.append(item.getProduct().getName());
            sb.append(" Amount: ");
            sb.append(item.getQuantity());
            sb.append(" Price: ");
            sb.append(item.getSubTotal());
            System.out.println(sb);
        }

        System.out.println("_________________");
    }

}
