package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Robert.Dumitrescu on 7/13/2017.
 */
public interface EntityManager {

    <T> T findById(Class<T> entityClass, Long id) throws SQLException, IllegalAccessException, InstantiationException;
    Long getNextIdVal(String tableName, String columnIdName) throws SQLException ;
    <T> Object insert(T entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException;
	<T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException;
	<T> T update(T entity) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException;
	void delete(Object entity) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException;
    <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException;

}
