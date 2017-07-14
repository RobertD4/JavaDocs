package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert.Dumitrescu on 7/14/2017.
 */
public class DepartmentDaoTest {
        DepartmentDao dd = new DepartmentDao();

    @Test
    public void testFirstMethod() throws IllegalAccessException, SQLException, InstantiationException {
        assertEquals("Mesaj functie findById:","Administration",dd.first().getDepartmentName());
    }

    @Test
    public void testSecondMethod() throws IllegalAccessException, SQLException, InstantiationException {
        assertEquals("Mesaj functie nextIdVal:",new Long(278),dd.second());
    }
    @Test
    public void testThirdMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        assertEquals("Mesaj functie insert:",dd.third().getDepartmentName(),"RO");
    }
    @Test
    public void testFourthMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        assertEquals("Lungime lista: ",42,dd.fourth().size());
        assertEquals("Element lista:" ,"RO",dd.fourth().get(0).getDepartmentName());
    }
    @Test
    public void testFifthMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        assertEquals("Mesaj functie update:","RO",dd.fifth().getDepartmentName());
    }


}
