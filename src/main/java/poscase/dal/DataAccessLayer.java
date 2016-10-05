package poscase.dal;

import poscase.Customer;
import poscase.Product;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by maart on 3-10-2016.
 */
public interface DataAccessLayer {

    Customer getCustomerById(int customerCode) throws SQLException;

    ArrayList<Customer> getCustomers();

    boolean addCustomer(Customer customer);

    Product getProductById(int productId);

    ArrayList<Product> getProducts();

    boolean addProduct(Product product);

}
