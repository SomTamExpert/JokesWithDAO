package bbw.km;

import bbw.km.dao.ACCDBDAO;
import bbw.km.dao.SQLDAO;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ACCDBDAO accdbdao = new ACCDBDAO();
        accdbdao.getAllJokes();

        SQLDAO sqldao = new SQLDAO();
        sqldao.getAllJokes();
    }
}
