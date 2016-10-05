import org.junit.Test;
import poscase.Customer;
import poscase.Session;
import poscase.Transaction;
import poscase.dal.OracleAccessLayer;

/**
 * Created by maart on 5-10-2016.
 */
public class Tests {


    //BAD TESTS, BUT EASIER FOR USAGE THAN USING THE MAIN
    @Test
    public void testGetCustomer(){
        OracleAccessLayer data = new OracleAccessLayer();

        Session session = new Session(data.getRegisters().get(0), data.getEmployees().get(0));

        Transaction trans = session.newTransaction("sale");

        Customer customer = data.getCustomerById(0);


        System.out.println(customer.getName());

    }

    @Test
    public void testAddCustomer(){
        OracleAccessLayer data = new OracleAccessLayer();

        Session session = new Session(data.getRegisters().get(0), data.getEmployees().get(0));

        Transaction trans = session.newTransaction("sale");

        Customer customer = Customer.builder().customerCode(1234).name("henk").lastName("haar").build();

        data.addCustomer(customer);


    }

}
