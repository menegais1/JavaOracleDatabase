package DatabaseAccess.Domain.Supplier;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.Entity;
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
