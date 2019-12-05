package DatabaseAccess.Domain.Package;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.BaseView;
import DatabaseAccess.Utils.ViewBuilder;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PackageView extends BaseView {


    public PackageView(BaseController controller, Stage primaryStage, BorderPane renderPane) {
        super(controller, primaryStage, renderPane);
    }

    @Override
    public EventHandler onTabSelected() {
        ViewBuilder.inflateTableView(controller, primaryStage, borderPane);
        return null;
    }
}
