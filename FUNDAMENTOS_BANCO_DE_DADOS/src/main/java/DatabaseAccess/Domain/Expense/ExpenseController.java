package DatabaseAccess.Domain.Expense;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.Entity;
import DatabaseAccess.Domain.Expense.Expense;
import DatabaseAccess.Utils.DatabaseConnection;
import DatabaseAccess.Utils.ErrorHandler;
import DatabaseAccess.Utils.Helpers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class ExpenseController extends BaseController {

    public ExpenseController() {
        super(new Expense());
    }


    @Override
    public long delete(Entity e) {
        Expense c = (Expense) e;
        try {
            return c.delete(c.id, DatabaseConnection.getInstance());
        } catch (SQLException ex) {
            ErrorHandler.HandleResponse(ex);
        }
        return -1;
    }

    @Override
    public long insert(List<String> fields, List<String> values) {
        try {
            Expense c = new Expense();
            for (int i = 0; i < fields.size(); i++) {
                String fieldName = fields.get(i);

                Field f = c.getClass().getField(fieldName);
                Object value = Helpers.convertStringToObject(values.get(i), f.getType());
                if (value == null) continue;

                if (f.getType() == String.class)
                    f.set(c, value.toString());
                else
                    f.set(c, f.getType().cast(value));
            }


            return c.insert(c, fields.toArray(new String[0]), DatabaseConnection.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException | SQLException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            ErrorHandler.HandleResponse(e);
        }
        return -1;
    }

    @Override
    public long update(Entity e, List<String> fields, List<String> values) {
        try {
            for (int i = 0; i < fields.size(); i++) {
                String fieldName = fields.get(i);

                Field f = e.getClass().getField(fieldName);
                Object value = Helpers.convertStringToObject(values.get(i), f.getType());
                if (value == null) continue;
                if (f.getType() == String.class)
                    f.set(e, value.toString());
                else
                    f.set(e, f.getType().cast(value));

            }

            return e.update(e, fields.toArray(new String[0]), DatabaseConnection.getInstance());
        } catch (IllegalAccessException | SQLException | NoSuchFieldException | InstantiationException | InvocationTargetException | NoSuchMethodException ex) {
            ErrorHandler.HandleResponse(ex);
        }
        return -1;
    }

}
