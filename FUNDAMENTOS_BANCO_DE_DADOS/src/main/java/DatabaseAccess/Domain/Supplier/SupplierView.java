package DatabaseAccess.Domain.Supplier;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Utils.ViewBuilder;
import DatabaseAccess.Domain.Base.BaseView;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SupplierView extends BaseView {


    public SupplierView(BaseController controller, Stage primaryStage, BorderPane renderPane) {
        super(controller, primaryStage, renderPane);
    }

    @Override
    public EventHandler onTabSelected() {
        ViewBuilder.inflateTableView(controller, primaryStage, borderPane);
        return null;
    }
}
