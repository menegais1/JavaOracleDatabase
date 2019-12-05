package DatabaseAccess.Domain.Service;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.Entity;
import DatabaseAccess.Domain.Service.Service;
import DatabaseAccess.Utils.DatabaseConnection;
import DatabaseAccess.Utils.Helpers;

import java.lang.reflect.Field;
import java.util.List;

public class ServiceController extends BaseController {

    public ServiceController() {
        super(new Service());
    }


    @Override
    public long delete(Entity e) {
        Service c = (Service) e;
        return c.delete(c.id, DatabaseConnection.getInstance());
    }

    @Override
    public long insert(List<String> fields, List<String> values) {
        Service c = new Service();
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i);
            try {
                Field f = c.getClass().getField(fieldName);
                Object value = Helpers.convertStringToObject(values.get(i), f.getType());
                if (f.getType() == String.class)
                    f.set(c, value.toString());
                else
                    f.set(c, f.getType().cast(value));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        return c.insert(c, fields.toArray(new String[0]), DatabaseConnection.getInstance());
    }

    @Override
    public long update(Entity e, List<String> fields, List<String> values) {
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i);
            try {
                Field f = e.getClass().getField(fieldName);
                Object value = Helpers.convertStringToObject(values.get(i), f.getType());
                if (f.getType() == String.class)
                    f.set(e, value.toString());
                else
                    f.set(e, f.getType().cast(value));
            } catch (IllegalAccessException | NoSuchFieldException ex) {
                ex.printStackTrace();
            }
        }

        return e.update(e, fields.toArray(new String[0]), DatabaseConnection.getInstance());
    }
}
