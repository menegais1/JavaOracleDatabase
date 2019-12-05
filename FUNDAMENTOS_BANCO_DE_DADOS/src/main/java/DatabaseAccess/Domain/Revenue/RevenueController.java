package DatabaseAccess.Domain.Revenue;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.Entity;
import DatabaseAccess.Domain.Revenue.Revenue;
import DatabaseAccess.Utils.DatabaseConnection;
import DatabaseAccess.Utils.Helpers;

import java.lang.reflect.Field;
import java.util.List;

public class RevenueController extends BaseController {

    public RevenueController() {
        super(new Revenue());
    }


    @Override
    public long delete(Entity e) {
        Revenue c = (Revenue) e;
        return c.delete(c.id, DatabaseConnection.getInstance());
    }

    @Override
    public long insert(List<String> fields, List<String> values) {
        Revenue c = new Revenue();
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
