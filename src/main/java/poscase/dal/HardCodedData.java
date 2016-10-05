package poscase.dal;

import java.util.ArrayList;
import lombok.Data;
import poscase.*;
import poscase.discounttypes.AbsoluteDiscount;

/**
 * Created by maart on 21-9-2016.
 */
@Data
public class HardCodedData implements DataAccessLayer{

    private static HardCodedData myData = new HardCodedData();

    public static HardCodedData getMyData(){
        return myData;
    }

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Register> registers = new ArrayList<Register>();
    private ArrayList<Discount> discounts = new ArrayList<Discount>();

    int customerid = 0;

    private HardCodedData(){
        Product proda = new Product(0,"12345","Coca Cola 33cl", "AB1234567", 0.55F);
        Product prodb = new Product(1,"54321","Fanta", "CD1234567", 0.50F);
        Product prodc = new Product(2,"56789","Cassis", "EF1234567", 0.45F);
        Product proda6pack = new Product(3,"98765","Coca Cola 6 pack 33cl", "AB12345678", 2.50F);
        for (int i = 0; i< 6; i++){
            proda6pack.addSubProduct(proda);
        }
        Product prodb6pack = new Product(4,"24680","Fanta 6 pack", "CD12345678", 2.45F);
        for (int i = 0; i< 6; i++){
            prodb6pack.addSubProduct(prodb);
        }
        products.add(proda);
        products.add(prodb);
        products.add(prodc);
        products.add(proda6pack);
        products.add(prodb6pack);

        Employee empla = new Employee("Maarten","pass", 123);
        Employee emplb = new Employee("Tessa","1234", 456);
        Employee emplc = new Employee("Lukas","code", 789);
        employees.add(empla);
        employees.add(emplb);
        employees.add(emplc);

        Customer custa = new Customer(0, 321,"Edem", "Eminov");
        Customer custb = new Customer(1, 654,"Bowie", "Kuijten");
        Customer custc = new Customer(2, 987,"Alexander", "van Esch");
        customers.add(custa);
        customers.add(custb);
        customers.add(custc);

        Register rega = new Register(1);
        Register regb = new Register(2);
        Register regc = new Register(3);
        registers.add(rega);
        registers.add(regb);
        registers.add(regc);

        AbsoluteDiscount disca = new AbsoluteDiscount(0.15F, proda6pack);
        discounts.add(disca);


    }

    public Customer getCustomerById(int customerCode){
        Customer result = null;
        for (Customer customer: customers){
            if (customer.getCustomerCode() == customerCode){
                result = customer;
            }
        }
        return result;
    }

    public boolean addCustomer(Customer customer) {
        if (customers.add(customer)){
            return true;
        }
        else{
            return false;
        }
    }

    public Product getProductById(int productCode){
        Product result = null;
        for (Product product: products){
            if (product.getProdid() == productCode){
                result = product;
            }
        }
        return result;
    }

    public boolean addProduct(Product product) {
        if (products.add(product)){
            return true;
        }
        else{
            return false;
        }
    }

}
