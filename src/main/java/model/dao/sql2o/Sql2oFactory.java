package model.dao.sql2o;

import org.sql2o.Sql2o;

import javax.sql.DataSource;

public class Sql2oFactory {
    private static Sql2o sql2o;

    public static synchronized Sql2o getInstance(DataSource dataSource) {
        if (sql2o == null) {
            sql2o = new Sql2o(dataSource);
        }
        return sql2o;
    }


}
