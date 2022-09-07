package bbw.km;

import bbw.km.dao.ACCDBDAO;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

        ACCDBDAO.selectAllJokes();
    }
}
