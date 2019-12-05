package DatabaseAccess.Domain.Expense;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.BaseView;
import DatabaseAccess.Utils.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExpenseView extends BaseView {


    public ExpenseView(BaseController controller, Stage primaryStage, BorderPane renderPane) {
        super(controller, primaryStage, renderPane);

    }

    @Override
    public EventHandler onTabSelected() {
        ViewBuilder.inflateTableView(controller, primaryStage, borderPane);
        Button b = new Button("Insert new record");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewBuilder.initInsertModalWindow(controller, "Insert a new record into table", primaryStage, borderPane);
            }
        });
        borderPane.setBottom(b);
        return null;
    }
}
