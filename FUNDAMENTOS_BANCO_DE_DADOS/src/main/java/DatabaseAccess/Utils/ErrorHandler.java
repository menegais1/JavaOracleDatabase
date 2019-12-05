package DatabaseAccess.Utils;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ErrorHandler {


    private static void LogError(String errorType, String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR, errorType + ": " + error, ButtonType.CLOSE);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("ERROR");
        alert.show();
    }

    public static void HandleResponse(Exception ex) {
        if (ex.getClass() == SQLException.class) {
            LogError("SQL ERROR:", ex.getLocalizedMessage());
        } else {
            LogError("GENERAL ERROR:", ex.getLocalizedMessage());
        }
    }

}
