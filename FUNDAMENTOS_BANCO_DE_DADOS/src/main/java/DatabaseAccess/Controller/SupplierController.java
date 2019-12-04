package DatabaseAccess.Controller;

import DatabaseAccess.Model.Client;
import DatabaseAccess.Model.Entity;
import DatabaseAccess.Model.Supplier;
import DatabaseAccess.Utils.DatabaseConnection;

import java.util.List;

public class SupplierController extends BaseController {

    public SupplierController() {
        super(new Supplier());
    }


    @Override
    public long delete(Entity e) {
        Supplier s = (Supplier) e;
        return s.delete(s.id, DatabaseConnection.getInstance());
    }

    @Override
    public long insert(List<String> fields, List<String> values) {
        return 0;
    }

    @Override
    public long update(Entity e, List<String> fields, List<String> values) {
        return 0;
    }
}
