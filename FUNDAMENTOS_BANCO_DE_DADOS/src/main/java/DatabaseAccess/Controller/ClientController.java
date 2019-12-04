package DatabaseAccess.Controller;

import DatabaseAccess.Model.Client;
import DatabaseAccess.Model.Entity;
import DatabaseAccess.Model.Supplier;
import DatabaseAccess.Utils.DatabaseConnection;

public class ClientController extends BaseController {

    public ClientController() {
        super(new Client());
    }

    @Override
    public long delete(Entity e) {
        Client c = (Client) e;
        return c.delete(c.id, DatabaseConnection.getInstance());
    }

}
