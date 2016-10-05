package poscase;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by maart on 19-9-2016.
 */
@Data
public class Session {
    private Register register;
    private Employee employee;
    private Collection<Transaction> transactions = new ArrayList<Transaction>();

    public Session(Register register, Employee employee){
        this.register = register;
        this.employee = employee;
    }

    public Transaction newTransaction(String trans){
        if (trans == null){
            return null;
        }
        if (trans.equalsIgnoreCase("sale")){
            return new Sale();
        }
        else if (trans.equalsIgnoreCase("refund")){
            return new Refund();
        }
        else if (trans.equalsIgnoreCase("reservation")){
            return new Reservation();
        }
        return null;
    }

    public void addAndCloseTransaction(Transaction transaction){
        if (transaction != null){
            transaction.registerTransaction(this);
            transactions.add(transaction);
        }
    }


    public void checkOut(){
        Iterator<Transaction> transIterator = transactions.iterator();
        while(transIterator.hasNext()){
            Transaction trans = transIterator.next();
            trans.outPut();
            System.out.println("Total Price: " + trans.getTotalPrice());
        }
    }

}
