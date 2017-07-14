package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert.Dumitrescu on 7/14/2017.
 */
public class DepartmentDao {

    EntityManager em = new EntityManagerImpl();
    Department dm = new Department();

    public Department first() throws IllegalAccessException, SQLException, InstantiationException {
         dm = em.findById(Department.class, (long) 10);
         return dm;
    }
    public Long  second() throws SQLException {
        Long s = em.getNextIdVal("departments","department_id");
        return s;
    }
    public Department third() throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        dm.setDepartmentName("RO");
        dm.setLocation(1700l);
        dm = (Department) em.insert(dm);
        return dm;
    }
    public List<Department> fourth() throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<Department> ls ;
        ls = em.findAll(Department.class);
        return ls;
    }
    public Department fifth() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        dm.setDepartmentName("RO");
        dm.setLocation(1700l);
        dm.setId(10l);
        dm =  em.update(dm);
        return dm;
    }

}
