package DatabaseAccess.Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;

public class Expense extends Entity<Expense> {

    public Long id;
    public Long parcels;
    public Date issue_date;
    public Date due_date;
    public BigDecimal value;
    public String status;
    public Long package_id;
    public Long supplier_id;

    public Expense(ResultSet result) {
        super(result);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", parcels=" + parcels +
                ", issue_date=" + issue_date +
                ", due_date=" + due_date +
                ", value=" + value +
                ", status='" + status + '\'' +
                ", package_id=" + package_id +
                '}';
    }
}
