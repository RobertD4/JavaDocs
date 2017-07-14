package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert.Dumitrescu on 7/14/2017.
 */
public class LocationDao {
    EntityManager em = new EntityManagerImpl();
    Location lc = new Location();

    public Location first() throws IllegalAccessException, SQLException, InstantiationException {
        lc = em.findById(Location.class, (long) 10);
        return lc;
    }
    public Long  second() throws SQLException {
        Long s = em.getNextIdVal("locations","location_id");
        return s;
    }
    public Location third() throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        lc.setCity("RO");
        lc.setId(1000l);
        lc = (Location) em.insert(lc);
        return lc;
    }
    public List<Location> fourth() throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<Location> ls ;
        ls = em.findAll(Location.class);
        return ls;
    }
    public Location fifth() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        lc.setCity("RO");
        lc.setId(1000l);
        lc =  em.update(lc);
        return lc;
    }

}
