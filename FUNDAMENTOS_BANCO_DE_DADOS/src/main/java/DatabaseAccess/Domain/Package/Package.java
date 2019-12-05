package DatabaseAccess.Domain.Package;

import DatabaseAccess.Domain.Base.Entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

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
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(),null);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(Long payment_method_id) {
        this.payment_method_id = payment_method_id;
    }
}