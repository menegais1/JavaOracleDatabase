package DatabaseAccess.Controller;

import DatabaseAccess.Model.Client;
import DatabaseAccess.Model.Entity;
import DatabaseAccess.Model.Supplier;
import DatabaseAccess.Utils.DatabaseConnection;

import java.lang.reflect.Field;
import java.util.List;

public class ClientController extends BaseController {

    public ClientController() {
        super(new Client());
    }

    @Override
    public long delete(Entity e) {
        Client c = (Client) e;
        return c.delete(c.id, DatabaseConnection.getInstance());
    }

    @Override
    public long insert(List<String> fields, List<String> values) {
        Client c = new Client();
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i);
            try {
                Field f = c.getClass().getField(fieldName);
                f.set(c, f.getType().cast(values.get(i)));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        return c.insert(c, (String[]) fields.toArray(), DatabaseConnection.getInstance());
    }

    @Override
    public long update(Entity e, List<String> fields, List<String> values) {
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i);
            try {
                Field f = e.getClass().getField(fieldName);
                f.set(e, f.getType().cast(values.get(i)));
            } catch (IllegalAccessException | NoSuchFieldException ex) {
                ex.printStackTrace();
            }
        }

        return e.update(e, (String[]) fields.toArray(), DatabaseConnection.getInstance());
    }


}
