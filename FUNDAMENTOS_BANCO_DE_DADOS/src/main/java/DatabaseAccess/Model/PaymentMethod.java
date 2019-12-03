package DatabaseAccess.Model;

import java.sql.ResultSet;

public class PaymentMethod extends Entity<PaymentMethod> {


    public Long id;
    public String name;
    public Long parcels;
    public Long due_days;

    public PaymentMethod(ResultSet result) {
        super(result);
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parcels=" + parcels +
                ", due_days=" + due_days +
                '}';
    }
}
