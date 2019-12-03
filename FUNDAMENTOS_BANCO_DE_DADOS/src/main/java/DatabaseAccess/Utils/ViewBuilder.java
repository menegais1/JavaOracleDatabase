package DatabaseAccess.Utils;

import DatabaseAccess.Model.Entity;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewBuilder {


    public static void inflateTableView(Entity e, Stage primaryStage, BorderPane borderPane) {

        TableView<Entity> table = new TableView<>();
        System.out.println(e.getClass());
        List<TableColumn<Entity, String>> tableColumns = new ArrayList<>();
        List<String> prettyNames = e.getPrettyNames();
        List<String> fieldNames = e.getFieldNames(e.getClass());
        for (int i = 0; i < fieldNames.size(); i++) {
            TableColumn<Entity, String> tableColumn = new TableColumn(prettyNames.get(i));
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(fieldNames.get(i)));
            tableColumns.add(tableColumn);
        }

        table.getColumns().addAll(tableColumns);

        try {
            table.setItems(FXCollections.observableArrayList(e.getAll(DatabaseConnection.getInstance())));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        borderPane.setCenter(table);
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
