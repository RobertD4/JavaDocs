package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static sun.awt.image.PixelConverter.Argb.instance;

/**
 * Created by Robert.Dumitrescu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager{

   // private Class<T> entityClass;
    //private Map<String, Object> params;

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
        for (ColumnInfo ci : column) {
            if (ci.isId())
                        obj.setColumnName(ci.getDbColumnName());
            System.out.println(ci.getDbColumnName());
        }

        QueryBuilder query = new QueryBuilder();
        query.setTableName(tableName);
        query.setQueryType(QueryType.SELECT);
        query.addQueryColumns(column);
        query.addCondition(obj);

        String h = query.createQuery();
        System.out.println(h);
        con.commit();
        Statement stm;

        T instance = entityClass.newInstance();
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(h);
            System.out.println(10);
            if (rs.next()) {
                System.out.println(11);
                for (ColumnInfo c : column){
                    Field f = instance.getClass().getDeclaredField(c.getColumnName()) ;
                    f.setAccessible(true);
                    f.set(instance, EntityUtils.castFromSqlType(rs.getObject(c.getDbColumnName()),f.getType()));
                    System.out.println(instance);
                }
                return instance;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException {
        Connection con = DBManager.getConnection();
        Statement pst = con.createStatement();
        String query = "SELECT MAX(" + columnIdName + ") + 1 FROM " + tableName;
        System.out.println(query);
        ResultSet rs = pst.executeQuery(query);
        Long x = null;
        if (rs.next()) {
            System.out.println(11);
            x = rs.getLong(1);
            rs.close();
        }
        return x;
    }

    @Override
    public <T> Object insert(T entity) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection con = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());

        ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
        column.addAll(EntityUtils.getColumns(entity.getClass()));
        Long x1  = 0l;
        for (ColumnInfo c : column){
            if (c.isId()) {
                c.setValue(getNextIdVal(tableName,c.getDbColumnName()));
                x1 = getNextIdVal(tableName,c.getDbColumnName());
                System.out.println(c);
            }
            else {
                Field f = entity.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                c.setValue(f.get(entity));

                System.out.println("fhfhhg"+c);
            }
        }


        QueryBuilder query = new QueryBuilder();
        query.addQueryColumns(column);
        System.out.println("22222");

        System.out.println(column);
        query.setTableName(tableName);
        System.out.println(tableName);

        query.setQueryType(QueryType.INSERT);
        String  query1 = query.createQuery();

        System.out.println(query1);
        con.commit();
        Statement pst =  con.createStatement();
        int x = pst.executeUpdate(query1);
        //T instance = new ;

            return findById(entity.getClass(), x1);

    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection con = DBManager.getConnection();
        System.out.println("123456");
        String tableName = EntityUtils.getTableName(entityClass);
        System.out.println("tabelul: "+tableName);

        ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
        column.addAll(EntityUtils.getColumns(entityClass));

        QueryBuilder query = new QueryBuilder();
        query.setTableName(tableName);
        query.setQueryType(QueryType.SELECT);
        query.addQueryColumns(column);
        String qu= query.createQuery();
        System.out.println("Querry: "+qu);
        con.commit();
        Statement pst =  con.createStatement();
        ResultSet rs = pst.executeQuery(qu);

        ArrayList<T> list = new ArrayList<>();


        while(rs.next()){
            T instance = entityClass.newInstance();
            for (ColumnInfo c : column){
                Field f = instance.getClass().getDeclaredField(c.getColumnName()) ;
                f.setAccessible(true);
                f.set(instance, EntityUtils.castFromSqlType(rs.getObject(c.getDbColumnName()),f.getType()));

            }
            list.add( instance);
        }
        System.out.print(list+"");
        return list;
    }

    @Override
    public <T> T update(T entity) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Connection con = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());

        ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
        column.addAll(EntityUtils.getColumns(entity.getClass()));
        Condition obj = new Condition();
        Long x1 =0l;
        for (ColumnInfo c : column){
            if (c.isId()) {
                Field f = entity.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                c.setValue(f.get(entity));
                //c.setColumnName(f.getName());
                obj.setColumnName(c.getDbColumnName());
                obj.setValue(c.getValue());
                 x1 = (Long)c.getValue();
                System.out.println(c);
            }
            else {
                Field f = entity.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                c.setValue(f.get(entity));
                System.out.println(c);
            }

        }

        QueryBuilder query = new QueryBuilder();
        query.setTableName(tableName);
        query.addQueryColumns(column);
        query.setQueryType(QueryType.UPDATE);
        query.addCondition(obj);
        //System.out.println(obj);
        String  query1 = query.createQuery();
        System.out.println(query1);
        con.commit();
        Statement pst =  con.createStatement();
        ResultSet rs = pst.executeQuery(query1);
        if (rs.next()) return (T) findById(entity.getClass(), x1);

        return null;
    }

    @Override
    public void delete(Object entity) throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Connection con = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        Long x1 =0l;
        ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
        column.addAll(EntityUtils.getColumns(entity.getClass()));
        Condition obj = new Condition();

        for (ColumnInfo c : column){
            if (c.isId()) {
                Field f = entity.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                c.setValue(f.get(entity));
                //c.setColumnName(f.getName());
                obj.setColumnName(c.getDbColumnName());
                obj.setValue(c.getValue());
                x1 = (Long)c.getValue();
                System.out.println(c);
            }
            else {
                Field f = entity.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                c.setValue(f.get(entity));
                System.out.println(c);
            }

        }

        QueryBuilder query = new QueryBuilder();
        query.setTableName(tableName);
        query.addQueryColumns(column);
        query.setQueryType(QueryType.DELETE);
        query.addCondition(obj);
        //System.out.println(obj);
        String  query1 = query.createQuery();
        System.out.println(query1);
        con.commit();
        Statement pst =  con.createStatement();
        ResultSet rs = pst.executeQuery(query1);

    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Connection con = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);

        ArrayList<ColumnInfo> column = new ArrayList<ColumnInfo>();
        column.addAll(EntityUtils.getColumns(entityClass));

        for (ColumnInfo c : column){
            if (c.isId()) {
                Field f = entityClass.getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                System.out.println(c);
            }
            else {
                Field f = entityClass.getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                System.out.println(c);
            }

        }
        ArrayList<Condition> ar = new ArrayList<>();
        QueryBuilder query = new QueryBuilder();
        for (Map.Entry<String,Object>  pr : params.entrySet()){
            Condition obj = new Condition();
            obj.setColumnName(pr.getKey());
            obj.setValue(pr.getValue());
            ar.add(obj);
            query.addCondition(obj);

        }

        query.setTableName(tableName);
        query.addQueryColumns(column);
        query.setQueryType(QueryType.SELECT);

        //System.out.println(obj);
        String  query1 = query.createQuery();
        System.out.println("Params : "+query1);
        Statement pst =  con.createStatement();
        ResultSet rs = pst.executeQuery(query1);
        con.commit();

        ArrayList<T> list = new ArrayList<>();

        while(rs.next()){
            T instance = entityClass.newInstance();
            for (ColumnInfo c : column){
                Field f = instance.getClass().getDeclaredField(c.getColumnName()) ;
                f.setAccessible(true);
                f.set(instance, EntityUtils.castFromSqlType(rs.getObject(c.getDbColumnName()),f.getType()));
            }
            list.add( instance);
        }
        System.out.print(list+"");
        return list;
    }
}

