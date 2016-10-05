package poscase;

import poscase.dal.OracleAccessLayer;

/**
 * Created by maart on 20-9-2016.
 */
public class main {
    public static void main(String[] args) {

        OracleAccessLayer data = new OracleAccessLayer();

        Session session = new Session(data.getRegisters().get(0), data.getEmployees().get(0));

        Transaction trans = session.newTransaction("sale");

        System.out.println(data.getCustomerById(0).getName());
        trans.setCustomer(data.getCustomerById(0));
        trans.addItem(data.getProducts().get(0));
        trans.addItem(data.getProducts().get(0));
        trans.addItem(data.getProducts().get(1));
        trans.addItem(data.getProducts().get(2));
        trans.addItem(data.getProducts().get(2));
        session.addAndCloseTransaction(trans);

        trans = session.newTransaction("sale");
        trans.addItem(data.getProducts().get(3));

        session.addAndCloseTransaction(trans);
        session.checkOut();
    }
}
