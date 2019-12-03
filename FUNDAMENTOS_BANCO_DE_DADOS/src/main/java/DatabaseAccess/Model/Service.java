package DatabaseAccess.Model;

import java.sql.ResultSet;

public class Service extends Entity {

    public Long id;
    public String name;
    public Long price;
    public Long payment_method_id;
    public Long service_type_id;
    public Long supplier_id;

    public Service(ResultSet result) {
        super(result);
    }


}
