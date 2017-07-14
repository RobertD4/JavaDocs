package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert.Dumitrescu on 7/14/2017.
 */
public class LocationDaoTest {

   LocationDao dd = new LocationDao();

    @Test
    public void testFirstMethod() throws IllegalAccessException, SQLException, InstantiationException {
        assertEquals("Mesaj functie findById:","Administration",dd.first().getCity());
    }

    @Test
    public void testSecondMethod() throws IllegalAccessException, SQLException, InstantiationException {
        assertEquals("Mesaj functie nextIdVal:",new Long(278),dd.second());
    }
    @Test
    public void testThirdMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        assertEquals("Mesaj functie insert:",dd.third().getCity(),"RO");
    }
    @Test
    public void testFourthMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        assertEquals("Lungime lista: ",42,dd.fourth().size());
        assertEquals("Element lista:" ,"Administration",dd.fourth().get(0).getCity());
    }
    @Test
    public void testFifthMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        assertEquals("Mesaj functie update:","RO",dd.fifth().getCity());
    }
}
