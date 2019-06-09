package model.dao.sql2o;

import jdk.internal.loader.Resource;
import jdk.internal.module.Resources;
import org.sql2o.GenericDatasource;

import javax.sql.DataSource;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class DataSourceFactory {
    private static DataSource dataSource;
    private static String SCHEMA_PATH = "db/schema.sql";
    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new GenericDatasource(
                    "jdbc:h2:mem:kafka;DB_CLOSE_DELAY=-1;AUTO_RECONNECT=TRUE;MULTI_THREADED=TRUE",
                    "",
                    ""
            );

            createSchema(dataSource);
        }
        return dataSource;
    }

    private static void createSchema(DataSource dataSource) {
        String createSchema = "";

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream is = classLoader.getResourceAsStream(SCHEMA_PATH);

        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            createSchema = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }

        try (Connection conn = dataSource.getConnection()) {
            conn.prepareStatement(createSchema).execute();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}
