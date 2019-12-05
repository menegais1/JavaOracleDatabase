package DatabaseAccess.Domain.ServiceType;

import DatabaseAccess.Annotations.AutoGenerated;
import DatabaseAccess.Annotations.Table;
import DatabaseAccess.Domain.Base.Entity;

import java.sql.ResultSet;
import java.util.List;

@Table(name="service_type")
public class ServiceType extends Entity<ServiceType> {

    @AutoGenerated
    public Long id;
    public String name;

    public ServiceType(ResultSet result) {
        super(result);
    }

    public ServiceType() {
        super();
    }


    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(), null);
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
