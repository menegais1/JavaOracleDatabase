package DatabaseAccess.Domain.PaymentMethod;

import DatabaseAccess.Annotations.AutoGenerated;
import DatabaseAccess.Annotations.Table;
import DatabaseAccess.Domain.Base.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Table(name="payment_method")
public class PaymentMethod extends Entity<PaymentMethod> {

    @AutoGenerated
    public Long id;
    public String name;
    public Long parcels;
    public Long due_days;

    public PaymentMethod(ResultSet result) throws SQLException, IllegalAccessException {
        super(result);
    }

    public PaymentMethod() {
        super();
    }

    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(), null);
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParcels() {
        return parcels;
    }

    public void setParcels(Long parcels) {
        this.parcels = parcels;
    }

    public Long getDue_days() {
        return due_days;
    }

    public void setDue_days(Long due_days) {
        this.due_days = due_days;
    }
}
