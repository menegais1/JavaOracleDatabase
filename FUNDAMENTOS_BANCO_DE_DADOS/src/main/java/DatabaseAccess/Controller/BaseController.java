package DatabaseAccess.Controller;

import DatabaseAccess.Model.Entity;
import DatabaseAccess.Utils.DatabaseConnection;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

}
