package DatabaseAccess.View;

import DatabaseAccess.Controller.BaseController;
import DatabaseAccess.Model.Entity;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class BaseView {

    public Tab tab;
    public BorderPane borderPane;
    protected BaseController controller;
    protected Stage primaryStage;

    public BaseView(BaseController controller, Stage primaryStage, BorderPane renderPane) {
        this.controller = controller;
        instantiateTab(controller.getName(), renderPane);
    }

    protected void instantiateTab(String tabName, BorderPane renderPane) {
        borderPane = new BorderPane();
        this.tab = new Tab(tabName, borderPane);
        tab.setOnSelectionChanged(onTabSelected());
        renderPane.setCenter(borderPane);
    }

    public abstract EventHandler onTabSelected();
}
