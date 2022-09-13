package bbw.km.dao;

public class DBAccessFactory {

    public JokeDAO getDataBaseAccess(String id) {
        if (id.equals("SQL")) {
            return new SQLDAO();
        } else if (id.equals("MDB")) {
            return new ACCDBDAO();
        } else {
            return null;
        }
    }
}
