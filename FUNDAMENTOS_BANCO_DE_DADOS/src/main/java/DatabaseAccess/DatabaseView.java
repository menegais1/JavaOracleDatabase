
package DatabaseAccess;

import DatabaseAccess.Model.Client;
import DatabaseAccess.Model.Package;
import DatabaseAccess.Utils.DatabaseConnection;
import DatabaseAccess.View.GUIView;
import DatabaseAccess.View.View;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseView {


    public static void main(String[] args) throws SQLException {

        View v = new GUIView();
        v.init(args);
    }
}
