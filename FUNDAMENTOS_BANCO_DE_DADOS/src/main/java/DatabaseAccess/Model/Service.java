package DatabaseAccess.Model;

import java.sql.ResultSet;
import java.util.List;

public class Service extends Entity<Service> {

    public Long id;
    public String name;
    public Long price;
    public Long payment_method_id;
    public Long service_type_id;
    public Long supplier_id;

    public Service(ResultSet result) {
        super(result);
    }

    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass());
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(Long payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public Long getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(Long service_type_id) {
        this.service_type_id = service_type_id;
    }

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }
}
