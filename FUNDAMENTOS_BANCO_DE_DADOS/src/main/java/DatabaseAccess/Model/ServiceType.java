package DatabaseAccess.Model;

import java.sql.ResultSet;
import java.util.List;

public class ServiceType extends Entity<ServiceType> {
    public Long id;
    public String name;

    public ServiceType(ResultSet result) {
        super(result);
    }


    @Override
    public List<String> getPrettyNames() {
        return getFieldNames(this.getClass(),null);
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
