package DatabaseAccess.Domain.Expense;

import DatabaseAccess.Annotations.AutoGenerated;
import DatabaseAccess.Domain.Base.Entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Expense extends Entity<Expense> {

    @AutoGenerated
    public Long id;
    public Long parcels;
    public Date issue_date;
    public Date due_date;
    public BigDecimal value;
    public String status;
    public Long package_id;
    public Long supplier_id;

    public Expense(ResultSet result) throws SQLException, IllegalAccessException {
        super(result);
    }

    public Expense() {
        super();
    }

    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(), null);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParcels() {
        return parcels;
    }

    public void setParcels(Long parcels) {
        this.parcels = parcels;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Long package_id) {
        this.package_id = package_id;
    }

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }
}
