
package DatabaseAccess;

import DatabaseAccess.Model.Client;
import DatabaseAccess.Model.Package;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseView {


    public static void main(String[] args) throws SQLException {

        Client c = new Client();
        c = c.getSingle(1, DatabaseConnection.getInstance());
        c = c.getSingle(1, DatabaseConnection.getInstance());
        c.name = "Roberto Menegais";
        c.update(c,new String[]{"name"},DatabaseConnection.getInstance());

        Package p = new Package();
        List<Package> packages = new ArrayList<>();

        packages = p.getAll(DatabaseConnection.getInstance());

        packages.forEach(aPackage -> System.out.println(aPackage.toString()));
    }
}
