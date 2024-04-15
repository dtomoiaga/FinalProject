package dataProviders;

import org.testng.annotations.DataProvider;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DBDataProviders {
    @DataProvider(name = "login_errors_sql")
    public Iterator<Object[]> loginErrorsDpCollection() throws Exception {
        Collection<Object[]> dp = new ArrayList<>();

        DatabaseUtils databaseUtils = new DatabaseUtils();
        // db connection
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login_errors;");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String authenticationErrorMessage = resultSet.getString("authenticationErrorMessage");

            dp.add(new Object[]{username, password, authenticationErrorMessage});
        }

        return dp.iterator();
    }
}
