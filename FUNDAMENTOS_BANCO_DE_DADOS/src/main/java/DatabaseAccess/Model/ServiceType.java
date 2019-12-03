package DatabaseAccess.Model;

import java.sql.ResultSet;

public class ServiceType extends Entity<ServiceType> {
    public Long id;
    public String name;

    public ServiceType(ResultSet result) {
        super(result);
    }


    @Override
    public String toString() {
        return "ServiceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
