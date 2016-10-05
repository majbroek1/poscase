package poscase;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by maart on 19-9-2016.
 */
@Data
public abstract class Transaction {
    private boolean paid = false;
    protected Customer customer;
    protected Collection<LineItem> lineItems = new ArrayList<LineItem>();
    protected Session session;

    public void registerTransaction(Session session) {
        this.session = session;
    }

    public void outPut() {

    }

    public void addItem(Product prod) {
        Iterator<LineItem> itemIterator = lineItems.iterator();
        boolean found = false;
        while (itemIterator.hasNext()) {
            LineItem itItem = itemIterator.next();
            if (itItem.getProduct().equals(prod)) {
                found = true;
                itItem.addItem();
            }
        }
        if (!found) {
            lineItems.add(new LineItem(prod));
        }
    }

    public void removeItem(Product prod) {
        Iterator<LineItem> itemIterator = lineItems.iterator();
        while (itemIterator.hasNext()) {
            LineItem itItem = itemIterator.next();
            if (itItem.getProduct().equals(prod)) {
                if (itItem.getQuantity() > 1) {
                    itItem.removeItem();
                } else {
                    itemIterator.remove();
                }
            }
        }
    }

    public float getTotalPrice() {
        Iterator<LineItem> itemIterator = lineItems.iterator();
        float totalPrice = 0F;
        while (itemIterator.hasNext()) {
            LineItem itItem = itemIterator.next();
            totalPrice = totalPrice + (itItem.getQuantity() * itItem.getProduct().getPrice());
        }
        return totalPrice;
    }

}
