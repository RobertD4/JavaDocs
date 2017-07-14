package ro.teamnet.zth.api.database;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert.Dumitrescu on 7/13/2017.
 */
public class DBManagerTest {


    @Test
    public void testGetConnectionMethod() throws SQLException {
        // String tableName = EntityUtils.getTableName(Department.class);
        //  assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testCheckConnectionMethod() {
//        Connection tableName = DBManager.checkConnection();
//        System.out.println(tableName);
//        assertEquals("Connection status:", "1", tableName);

    }
}
