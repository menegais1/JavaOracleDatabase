package DatabaseAccess.Domain.Base;

import DatabaseAccess.Domain.Base.Entity;
import DatabaseAccess.Utils.DatabaseConnection;
import DatabaseAccess.Utils.ErrorHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseController {

    protected Entity model;
    protected List<Entity> records;

    public BaseController(Entity model) {
        this.model = model;
    }

    public Entity getModel() {
        return model;
    }

    public String getName() {
        return model.name();
    }

    public List<Entity> getAll() {
        try {
            records = model.getAll(DatabaseConnection.getInstance());
        } catch (SQLException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            ErrorHandler.HandleResponse(e);
        }
        return records;
    }

    public abstract long delete(Entity e);

    public abstract long insert(List<String> fields, List<String> values);

    public abstract long update(Entity e, List<String> fields, List<String> values);
}
