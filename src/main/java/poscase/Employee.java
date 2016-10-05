package poscase;

import lombok.Data;

/**
 * Created by maart on 19-9-2016.
 */
@Data
public class Employee {

    private String name;
    private String password;
    private int employeeId;

    public Employee(String name,String password, int employeeId){
        this.name = name;
        this.password = password;
        this.employeeId = employeeId;
    }


}
