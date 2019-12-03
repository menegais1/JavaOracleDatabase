package DatabaseAccess.Model;

import java.sql.ResultSet;
import java.util.List;

public class PackageService extends Entity<PackageService> {

    public Long id;
    public Long service_id;
    public Long package_id;

    public PackageService(ResultSet result) {
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

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public Long getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Long package_id) {
        this.package_id = package_id;
    }
}
