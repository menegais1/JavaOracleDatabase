package DatabaseAccess.Utils;

import DatabaseAccess.Controller.BaseController;
import DatabaseAccess.Model.Entity;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewBuilder {


    public static void inflateTableView(Entity e, BaseController controller, List<Entity> items, Stage primaryStage, BorderPane pane) {

        TableView<Entity> table = new TableView<>();
        System.out.println(e.getClass());
        List tableColumns = new ArrayList<>();
        List<String> prettyNames = e.getPrettyNames();
        List<String> fieldNames = e.getFieldNames(e.getClass());
        for (int i = 0; i < fieldNames.size(); i++) {
            TableColumn<Entity, String> tableColumn = new TableColumn(prettyNames.get(i));
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(fieldNames.get(i)));
            tableColumns.add(tableColumn);
        }
        TableColumn<Entity, Button> removeButton = new TableColumn<>("Remove");
        removeButton.setCellFactory(ActionButtonTableCell.<Entity>forTableColumn("Remove", entity -> {
            if (controller.delete(entity) > 0) {
                table.setItems(FXCollections.observableArrayList(controller.getAll()));
            }
            return entity;
        }));

        TableColumn<Entity, Button> updateButton = new TableColumn<>("Update");
        updateButton.setCellFactory(ActionButtonTableCell.<Entity>forTableColumn("Update", entity -> {
            return entity;
        }));

        table.getColumns().addAll(tableColumns);
        table.getColumns().add(updateButton);
        table.getColumns().add(removeButton);
        table.setItems(FXCollections.observableArrayList(items));


        pane.setCenter(table);
    }

//    public static void initModalWindow(Entity e, Stage primaryStage, EnadeRow row) {
//        Stage modal = new Stage();
//        ScrollPane scrollPane = new ScrollPane();
//        VBox vBox = new VBox();
//
//        List<String> prettyNames = e.getPrettyNames();
//        List<String> names = e.getFieldNames(e.getClass());
//        for (String prettyName : prettyNames) {
//            Label name = new Label(prettyName + ":");
//            name.setPadding(new Insets(10, 10, 10, 10));
//            name.setFont(new Font(20));
//            Label value = new Label(e.getClass().getField());
//            value.setPadding(new Insets(0, 0, 0, 20));
//            value.setFont(new Font(16));
//            vBox.getChildren().addAll(name, value);
//        }
//
//        scrollPane.setContent(vBox);
//        modal.setTitle("Informações adicionais");
//        modal.setScene(new Scene(scrollPane, 800, 600));
//        modal.initModality(Modality.APPLICATION_MODAL);
//        modal.show();
//
//    }

}
