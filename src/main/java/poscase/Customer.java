package poscase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by maart on 19-9-2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private int customerId, customerCode;
    private String name, lastName;

}
