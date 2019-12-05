package DatabaseAccess.Domain.Revenue;

import DatabaseAccess.Domain.Base.BaseController;
import DatabaseAccess.Domain.Base.BaseView;
import DatabaseAccess.Utils.ViewBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RevenueView extends BaseView {


    public RevenueView(BaseController controller, Stage primaryStage, BorderPane renderPane) {
        super(controller, primaryStage, renderPane);
    }

    @Override
    public EventHandler onTabSelected() {
        System.out.println("SELECTED");
        ViewBuilder.inflateTableView(controller, primaryStage, borderPane);
        Button b = new Button("Insert new record");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewBuilder.initInsertModalWindow(controller, "Insert a new record into table", primaryStage, borderPane);
            }
        });
        b.setPadding(new Insets(20, 20, 20, 20));
        b.setTranslateX(10);
        Button r = new Button("Reload Records");
        r.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewBuilder.inflateTableView(controller, primaryStage, borderPane);
            }
        });
        r.setPadding(new Insets(20, 20, 20, 20));
        r.setTranslateX(10);
        HBox h = new HBox();
        h.setTranslateY(10);
        h.setTranslateX(10);
        h.getChildren().addAll(b, r);
        borderPane.setBottom(h);
        return null;
    }
}
