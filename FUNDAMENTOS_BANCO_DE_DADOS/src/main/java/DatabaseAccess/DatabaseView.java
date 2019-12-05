
package DatabaseAccess;

import DatabaseAccess.View.GUIView;
import DatabaseAccess.View.View;

import java.sql.*;

public class DatabaseView {


    public static void main(String[] args) throws SQLException {

        View v = new GUIView();
        v.init(args);
    }
}
