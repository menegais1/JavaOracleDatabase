package DatabaseAccess.View;


import DatabaseAccess.Domain.Client.ClientController;
import DatabaseAccess.Domain.Client.ClientView;
import DatabaseAccess.Domain.Supplier.SupplierController;
import DatabaseAccess.Domain.Supplier.SupplierView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIView extends Application implements View {


    @Override
    public void start(Stage primaryStage) throws Exception {


        BorderPane root = new BorderPane();
        TabPane tabs = new TabPane();
        tabs.tabClosingPolicyProperty().setValue(TabPane.TabClosingPolicy.UNAVAILABLE);
        ClientView clientView = new ClientView(new ClientController(), primaryStage,root);
        SupplierView supplierView = new SupplierView(new SupplierController(), primaryStage,root);
        tabs.getTabs().addAll(clientView.tab, supplierView.tab);

        root.setTop(tabs);
        //initMenu(primaryStage, root);
        //  ViewBuilder.inflateTableView(new Supplier(),primaryStage, root);
        primaryStage.setTitle("Agencia de Turismo");
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


    @Override
    public void init(String[] args) {
        launch(args);
    }
}
