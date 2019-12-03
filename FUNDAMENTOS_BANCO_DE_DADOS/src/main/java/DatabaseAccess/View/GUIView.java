package DatabaseAccess.View;


import DatabaseAccess.Model.Client;
import DatabaseAccess.Utils.DatabaseConnection;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GUIView extends Application implements View {


    @Override
    public void start(Stage primaryStage) throws Exception {


        BorderPane root = new BorderPane();
        initMenu(primaryStage, root);
        initTableView(primaryStage, root);
        primaryStage.setTitle("GitHubAnalyzer");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.show();
    }

    private void initMenu(Stage primaryStage, BorderPane borderPane) {
        final Menu menu1 = new Menu("File");
        MenuItem open = new MenuItem("Open");
//        open.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Escolha o arquivo .txt");
//                File file = fileChooser.showOpenDialog(primaryStage);
//                if (file != null) {
//                    urlFileLoaderController = new UrlFileLoaderController();
//                    String path = file.getPath();
//                    try {
//                        urlFileLoaderController.load(path);
//                    } catch (IOException e) {
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("An error has occurred");
//                        alert.setContentText(e.getMessage());
//                        alert.showAndWait();
//                    }
//                    commitAnalyzerController.setInititalRepositories(urlFileLoaderController.getUrlList());
//                    initTableView(primaryStage, borderPane);
//                }
//            }
//        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        menu1.getItems().add(open);
        menu1.getItems().add(exit);

        final Menu menu2 = new Menu("Tools");
        MenuItem analyzer = new MenuItem("Commit analyzer");
//        analyzer.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if (urlFileLoaderController.isEmpty()) return;
//
//                Task<Void> t = new Task<>() {
//
//                    @Override
//                    protected Void call() throws Exception {
//                        commitAnalyzerController.getCommitsFromRepository();
//                        commitAnalyzerController.printRepositories();
//                        return null;
//                    }
//
//                    @Override
//                    protected void succeeded() {
//                        initTableView(primaryStage, borderPane);
//                    }
//
//                    @Override
//                    protected void failed() {
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("An error has occurred");
//                        alert.setContentText(this.getException().getMessage());
//                        if (this.getException() instanceof MalformedURLException) {
//                            alert.setContentText("Invalid Url");
//                        } else if (this.getException() instanceof ProtocolException) {
//                            alert.setContentText("Error in http protocol");
//                        } else if (this.getException() instanceof IOException) {
//                            alert.setContentText("Impossible to open a connection");
//                        } else {
//                            alert.setContentText(this.getException().getMessage());
//                        }
//                        alert.showAndWait();
//                    }
//                };
//                new Thread(t).start();
//
//            }
//        });
        menu2.getItems().add(analyzer);

        final Menu menu3 = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("About");
                alert.setHeaderText("GitHubAnalyzer");
                alert.setContentText("Autor: Roberto Nisxota Menegais");
                alert.showAndWait();
            }
        });

        menu3.getItems().add(about);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2, menu3);
        borderPane.setTop(menuBar);
    }

    private void initTableView(Stage primaryStage, BorderPane borderPane) {

        TableView<Client> table = new TableView<>();

        Client c = new Client();

        List<TableColumn<Client, String>> tableColumns = new ArrayList<>();
        List<String> prettyNames = c.getPrettyNames();
        List<String> fieldNames = c.getFieldNames(c.getClass());
        for (int i = 0; i < fieldNames.size(); i++) {
            TableColumn<Client, String> tableColumn = new TableColumn(prettyNames.get(i));
            tableColumn.setCellValueFactory(new PropertyValueFactory<Client, String>(fieldNames.get(i)));
            tableColumns.add(tableColumn);
        }

        table.getColumns().addAll(tableColumns);

        try {
            table.setItems(FXCollections.observableArrayList(c.getAll(DatabaseConnection.getInstance())));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        borderPane.setCenter(table);
    }

//    private void initModalWindow(Stage primaryStage, EnadeRow row) {
//        Stage modal = new Stage();
//        ScrollPane scrollPane = new ScrollPane();
//        VBox vBox = new VBox();
//
//        List<String> prettyNames = csvLoaderController.getFieldListPrettyNames();
//
//        for (String prettyName : prettyNames) {
//            Label name = new Label(prettyName + ":");
//            name.setPadding(new Insets(10, 10, 10, 10));
//            name.setFont(new Font(20));
//            Label value = new Label(csvLoaderController.getFieldValueByName(row, prettyName));
//            value.setPadding(new Insets(0, 0, 0, 20));
//            value.setFont(new Font(16));
//            vBox.getChildren().addAll(name, value);
//        }
//
//        Label name = new Label("Imagem:");
//        name.setPadding(new Insets(10, 10, 10, 10));
//        name.setFont(new Font(20));
//        vBox.getChildren().add(name);
//        if (row.getUrlCrop() != null) {
//            try {
//                Image image = new Image(new URL(row.getUrlCrop()).openStream());
//                ImageView imageView = new ImageView(image);
//                vBox.getChildren().add(imageView);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        scrollPane.setContent(vBox);
//        modal.setTitle("Informações adicionais");
//        modal.setScene(new Scene(scrollPane, 800, 600));
//        modal.initModality(Modality.APPLICATION_MODAL);
//        modal.show();
//
//    }

    @Override
    public void init(String[] args) {
        launch(args);
    }
}
