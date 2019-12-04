package DatabaseAccess.Controller;

import DatabaseAccess.Model.Client;
import DatabaseAccess.Model.Entity;
import DatabaseAccess.Model.Supplier;
import DatabaseAccess.Utils.DatabaseConnection;

public class SupplierController extends BaseController {

    public SupplierController() {
        super(new Supplier());
    }


    @Override
    public long delete(Entity e) {
        Supplier s = (Supplier) e;
        return s.delete(s.id, DatabaseConnection.getInstance());
    }
}
