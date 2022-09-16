package bbw.km.dao;

/**
 * Class DBAccessFactory
 *
 * @author marco
 * @version 13.09.2022
 */
public class DBAccessFactory {

    public JokeDAO getDataBaseAccess(String id) {
        if (id.equals("SQL")) {
            return new SQLDAO();
        } else if (id.equals("MDB")) {
            return new ACCDBDAO();
        } else if (id.equals("MONGO")) {
            return new MONGODAO();
        } else {
            return null;
        }
    }
}
