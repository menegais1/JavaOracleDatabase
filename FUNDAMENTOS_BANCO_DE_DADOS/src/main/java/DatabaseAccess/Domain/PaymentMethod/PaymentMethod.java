package DatabaseAccess.Domain.PaymentMethod;

import DatabaseAccess.Domain.Base.Entity;

import java.sql.ResultSet;
import java.util.List;

public class PaymentMethod extends Entity<PaymentMethod> {


    public Long id;
    public String name;
    public Long parcels;
    public Long due_days;

    public PaymentMethod(ResultSet result) {
        super(result);
    }

    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(),null);
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
