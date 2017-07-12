package ro.teamnet.zth.api.em;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Robert.Dumitrescu on 7/12/2017.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public QueryBuilder addCondition(Condition condition){
        this.conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName){
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumn){
        for (ColumnInfo c: queryColumn){
            this.queryColumns.add(c);
        }
        return this;
    }
    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType = queryType;
        return this;
    }

    private StringBuilder createSelectQuery(){
        StringBuilder query = new StringBuilder();
        query.append("SELECT");
        for (ColumnInfo col : queryColumns){
            query.append(col.getColumnName() +", ");
        }
        int index = query.lastIndexOf(",");
        query.deleteCharAt(index);
        query.append("FROM" + tableName +"WHERE");
        for (Condition cond : conditions){
            query.append(cond.getValue());
        }
        return query;
    }

    private StringBuilder createDeleteQuery(){
    return null;
    }

    private StringBuilder createUpdateQuery(){
        return null;
    }

    private StringBuilder createInsertQuery(){
        return null;
    }

    public StringBuilder createQuery(){
        if (queryType.equals(QueryType.SELECT)) return createSelectQuery();
        if (queryType.equals(QueryType.DELETE)) return createDeleteQuery();
        if (queryType.equals(QueryType.UPDATE)) return createUpdateQuery();
        if (queryType.equals(QueryType.INSERT)) return createInsertQuery();
       return null;
    }

    public String getValueForQuery(Object value){
        if (value instanceof String) return ""+value+"";
            else if (value instanceof Date) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";
            }
            else
                return value.toString();
    }
}
