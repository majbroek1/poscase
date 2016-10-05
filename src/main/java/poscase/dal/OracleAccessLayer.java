package poscase.dal;

import poscase.Customer;
import poscase.Employee;
import poscase.Product;
import poscase.Register;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by maart on 3-10-2016.
 */
public class OracleAccessLayer implements DataAccessLayer {

    Connection conn;

    public void openConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "pos", "admin");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(int customerCode) {
        Customer customer = null;

        openConnection();
        try {
            String query = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, customerCode);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                customer = Customer.builder().customerCode(resultSet.getInt("CUSTOMER_ID"))
                        .customerId(resultSet.getInt("CUSTOMERCODE"))
                        .name(resultSet.getString("NAME"))
                        .lastName(resultSet.getString("LASTNAME")).build();
            }

            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }

        return customer;
    }

    public ArrayList<Customer> getCustomers() {
        return null;
    }

    public boolean addCustomer(Customer customer) {
        boolean result = false;
        openConnection();
        try {
            String query = "INSERT INTO CUSTOMER(CUSTOMERCODE,NAME,LASTNAME) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, customer.getCustomerCode());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getLastName());

            int numberOfRows = stmt.executeUpdate();
            if (numberOfRows <= 0) {
                result = false;
            } else {
                result = true;
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return result;
    }

    public Product getProductById(int productId) {
        return null;
    }

    public ArrayList<Product> getProducts() {
        return null;
    }

    public boolean addProduct(Product product) {
        return false;
    }


    //NOT IMPORTANT

    public ArrayList<Register> getRegisters() {
        return new ArrayList<>(Arrays.asList(new Register(01), new Register(1)));
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(Arrays.asList(
                new Employee("Maarten", "pass", 123),
                new Employee("Tessa", "1234", 456),
                new Employee("Lukas", "code", 789))
        );
    }
}
