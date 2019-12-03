package DatabaseAccess.Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;

public class Package extends Entity<Package> {

    public Long id;
    public BigDecimal total_price;
    public Date order_date;
    public Long client_id;
    public Long payment_method_id;

    public Package(ResultSet result) {
        super(result);
    }

    public Package() {
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", order_date=" + order_date +
                ", client_id=" + client_id +
                ", payment_method_id=" + payment_method_id +
                '}';
    }
}
