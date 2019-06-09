package model.dao.members;

import model.dao.sql2o.DataSourceFactory;

public class MemberDaoFactory {
    private static MemberDao memberDao;
    public static synchronized MemberDao getInstance() {
        if (memberDao == null) {
            memberDao = new MemberSql2oDao(DataSourceFactory.getInstance());
        }
        return memberDao;
    }
}
