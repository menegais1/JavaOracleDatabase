package DatabaseAccess.Model;

import java.sql.ResultSet;

public class PackageService extends Entity {

    public Long id;
    public Long service_id;
    public Long package_id;

    public PackageService(ResultSet result) {
        super(result);
    }
}
