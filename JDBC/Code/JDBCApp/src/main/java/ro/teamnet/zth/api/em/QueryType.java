package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum QueryType {
    SELECT, INSERT, UPDATE, DELETE;

    /**
     * Created by Robert.Dumitrescu on 7/13/2017.
     */
    public static class EntityManagerImpl implements EntityManager{

        @Override
        public <T> T findById(Class<T> entityClass, Long id) throws SQLException, IllegalAccessException, InstantiationException {
            Connection con = DBManager.getConnection();
            String tableName = EntityUtils.getTableName(entityClass);
            ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
            column.addAll(EntityUtils.getColumns(entityClass));
            ArrayList<Field> field = new ArrayList<Field>();
            field.addAll(EntityUtils.getFieldsByAnnotations(entityClass,entityClass));
            Condition obj = new Condition();
            obj.setValue(id);
            obj.setColumnName("location_id");
            QueryBuilder query = new QueryBuilder();
            query.setTableName("departments");
            query.setQueryType(SELECT);
            query.addQueryColumns(column);
            query.addCondition(obj);
            query.createQuery();
            con.commit();
            PreparedStatement stm;
            T instance = entityClass.newInstance();
            try {
                stm = (PreparedStatement) con.createStatement();
                ResultSet rs = stm.executeQuery(String.valueOf(query));
                if (rs.next()) {

                    for (ColumnInfo c : column){
                        Field f = instance.getClass().getDeclaredField(c.getColumnName()) ;
                        f.setAccessible(true);
                        f.set(instance, rs);
                    }
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return instance;
        }

        @Override
        public Long getNextIdVal(String tableName, String columnIdName) throws SQLException {
            Connection con = DBManager.getConnection();
            PreparedStatement pst = (PreparedStatement) con.createStatement();
            String query = "SELECT MAX(" + tableName + ") + 1 FROM" + columnIdName;
            ResultSet rs = pst.executeQuery(query);
            Long x = null;
            if (rs.next()) {
                x = rs.getLong(0);
                rs.close();
            }
            return x;
        }

        @Override
        public <T> Object insert(T entity) throws SQLException, InstantiationException, IllegalAccessException {
            Connection con = DBManager.getConnection();
            String tableName = EntityUtils.getTableName((Class) entity);
            ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
            column.addAll(EntityUtils.getColumns((Class) entity));
            QueryBuilder query = new QueryBuilder();
            query.setTableName("departments");
            query.setQueryType(SELECT);
            query.addQueryColumns(column);
            query.createQuery();
            PreparedStatement pst = (PreparedStatement) con.createStatement();
            ResultSet rs = pst.executeQuery(String.valueOf(query));
            if (rs.next()) {
                return findById(entity.getClass(),rs.getLong(0)) ;
            }
            return null;
        }

        @Override
        public <T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
            Connection con = DBManager.getConnection();
            String tableName = EntityUtils.getTableName((Class) entityClass);
            ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
            column.addAll(EntityUtils.getColumns((Class) entityClass));
            QueryBuilder query = new QueryBuilder();
            query.setTableName("departments");
            query.setQueryType(SELECT);
            query.addQueryColumns(column);
            query.createQuery();
            PreparedStatement pst = (PreparedStatement) con.createStatement();
            ResultSet rs = pst.executeQuery(String.valueOf(query));
            ArrayList<T> list = new ArrayList<>();
            T instance = entityClass.newInstance();
            while(rs.next()){
                for (ColumnInfo c : column){
                    Field f = instance.getClass().getDeclaredField(c.getColumnName()) ;
                    f.setAccessible(true);
                    f.set(instance, rs);
                    list.add((T) f);
                }
            }
            return list;
        }
    }

    /**
     * Created by Robert.Dumitrescu on 7/13/2017.
     */
    public static interface EntityManager {

        <T> T findById(Class<T> entityClass, Long id) throws SQLException, IllegalAccessException, InstantiationException;
        Long getNextIdVal(String tableName, String columnIdName) throws SQLException ;
        <T> Object insert(T entity) throws SQLException, InstantiationException, IllegalAccessException;
        <T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException;

    }
}
