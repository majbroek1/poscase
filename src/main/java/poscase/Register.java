package poscase;

import lombok.Data;

/**
 * Created by maart on 20-9-2016.
 */
@Data
public class Register {
    private int registerId;

    public Register(int registerId){
        this.registerId = registerId;
    }
}
