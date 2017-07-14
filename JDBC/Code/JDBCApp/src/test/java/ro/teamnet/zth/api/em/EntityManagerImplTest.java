package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert.Dumitrescu on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindByIdMethod() throws IllegalAccessException, SQLException, InstantiationException {
        EntityManager em = new EntityManagerImpl();
        Department dm = em.findById(Department.class, (long) 10);
        assertEquals("Mesaj functie findById:","Administration",dm.getDepartmentName());
    }

    @Test
    public void testGetNextIdValMethod() throws IllegalAccessException, SQLException, InstantiationException {
        EntityManager em = new EntityManagerImpl();
        Long s = em.getNextIdVal("departments","department_id");
        assertEquals("Mesaj functie nextIdVal:",new Long(278),s);
    }

    @Test
    public void testinsertMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();
        Department dm = new Department();
        dm.setDepartmentName("RO");
        dm.setLocation(1700l);
         dm = (Department) em.insert(dm);
        assertEquals("Mesaj functie insert:",dm.getDepartmentName(),"RO");
    }

    @Test
    public void testFindAllMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();
        List<Department> ls ;
        ls = em.findAll(Department.class);
        assertEquals("Lungime lista: ",42,ls.size());
        assertEquals("Element lista:" ,"Administration",ls.get(0).getDepartmentName());
    }

    @Test
    public void testUpdateMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();
        Department dm = new Department();
        dm.setDepartmentName("RO");
        dm.setLocation(1700l);
        dm.setId(10l);
        dm =  em.update(dm);
        assertEquals("Mesaj functie update:","RO",dm.getDepartmentName());
    }

    @Test
    public void testDeleteMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();
        Department dm = new Department();
        dm.setId(249l);
        em.delete(dm);
        Department ne =em.findById(Department.class,dm.getId());
        assertEquals("Mesaj functie update:",null,ne);
    }

    @Test
    public void testFindByParamsMethod() throws IllegalAccessException, SQLException, InstantiationException, NoSuchFieldException {
        EntityManager em = new EntityManagerImpl();

        Map<String,Object> params = new HashMap<>();
        params.put("department_name","RO");
        params.put("location_id",1700l);
        List<Department> ls ;

        ls = em.findByParams(Department.class,params);
        assertEquals("Metoda FindByParams" ,16,ls.size());

    }


}
