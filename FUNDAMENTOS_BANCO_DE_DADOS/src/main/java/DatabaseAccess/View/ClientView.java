package DatabaseAccess.View;

import DatabaseAccess.Controller.BaseController;
import DatabaseAccess.Utils.ViewBuilder;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientView extends BaseView {


    public ClientView(BaseController controller, Stage primaryStage, BorderPane renderPane) {
        super(controller, primaryStage, renderPane);

    }

    @Override
    public EventHandler onTabSelected() {
        ViewBuilder.inflateTableView(controller.getModel(),controller, controller.getAll(), primaryStage, borderPane);
        return null;
    }
}
