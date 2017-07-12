package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Robert.Dumitrescu on 7/12/2017.
 */
public class EntityUtils {
    public EntityUtils() throws UnsupportedOperationException {
    }

    public static String getTableName(Class entity) {
        for (Annotation a : entity.getAnnotations()) {
            if (a.annotationType().equals(Table.class)) return ((Table) a).name();

        }
        return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumn(Class entity) {
        Field[] fields = entity.getDeclaredFields();
        ArrayList<ColumnInfo> list = new ArrayList<ColumnInfo>();
        for (Field f : fields) {
            if (f.getClass().getName().equals(Column.class.getName()) || f.getClass().getName().equals(Id.class.getName())) {
                ColumnInfo object = new ColumnInfo();
                object.setColumnName("");
                list.add(object);
            }
        }
        return list;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {
        if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Integer")) return (Integer) value;
        if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Long")) return (Long) value;
        if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Float")) return (Float) value;
        if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Double")) return (Double) value;
        if (!(value instanceof BigDecimal)) return value;
        return null;
    }

    public static ArrayList<Field> getFieldsByAnnotatins(Class clazz, Class annotation) {
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<Field> list = new ArrayList<Field>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(annotation))
                list.add(f);
        }
        return list;
    }

    public static Object getSqlValue(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        if (object.getClass().isAnnotationPresent(Table.class)) {
            for (Field f : fields) {
                if (f.getClass().isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    return f;
                }
            }
        }
        return object;
    }

}
