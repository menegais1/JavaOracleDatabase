package DatabaseAccess.Domain.Base;


import DatabaseAccess.Annotations.AutoGenerated;
import DatabaseAccess.Annotations.Table;
import DatabaseAccess.Utils.DatabaseConnection;
import DatabaseAccess.Utils.Tuple;
import DatabaseAccess.Utils.TypeMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Entity<T> {


    public Entity(ResultSet result) {
        fillEntity(result);
    }

    public Entity() {

    }

    public void fillEntity(ResultSet result) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (Modifier.isPublic(field.getModifiers()))
                    field.set(this, result.getObject(field.getName(), field.getType()));
            } catch (IllegalAccessException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public T getSingle(long id, DatabaseConnection db) throws SQLException {
        String tableName = getTableName(this.getClass());
        ResultSet result = db.ExecuteQuery("SELECT * FROM " + tableName + " WHERE ID = ?",
                new Tuple[]{
                        new Tuple<Object, JDBCType>(id, JDBCType.INTEGER)
                });
        Entity e = null;
        result.next();
        try {
            e = getClass().getConstructor(ResultSet.class).newInstance(result);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        db.CloseStatement(result.getStatement());
        return (T) e;
    }

    public List<T> getAll(DatabaseConnection db) throws SQLException {
        String tableName = getClass().getName();
        String[] split = tableName.split("\\.");
        tableName = split[split.length - 1];
        ResultSet result = db.ExecuteQuery("SELECT * FROM " + tableName, null);
        List<T> entities = new ArrayList<>();
        while (result.next()) {
            try {
                entities.add((T) getClass().getConstructor(ResultSet.class).newInstance(result));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        db.CloseStatement(result.getStatement());
        return entities;
    }

    public long insert(T e, String[] fields, DatabaseConnection db) {

        String tableName = getTableName(e.getClass());
        List<Field> classFields = getFields(e, fields);

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO " + tableName);
        queryBuilder.append(insertQueryFieldsValue(classFields));
        Tuple<Object, JDBCType>[] binds = bindsToArray(getBindings(e, classFields));
        try {
            ResultSet r = db.Execute(queryBuilder.toString(), binds);
            r.next();
            return r.getLong(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public long update(T e, String[] fields, DatabaseConnection db) {

        String tableName = getTableName(e.getClass());
        List<Field> classFields = getFields(e, fields);

        StringBuilder queryBuilder = new StringBuilder("UPDATE " + tableName);
        queryBuilder.append(" SET ").append(updateQueryFieldsValue(classFields));
        queryBuilder.append(" WHERE id = ?");

        List<Tuple<Object, JDBCType>> listBinds = getBindings(e, classFields);
        ;
        try {
            listBinds.add(new Tuple<>(e.getClass().getField("id").get(e), JDBCType.INTEGER));
        } catch (IllegalAccessException | NoSuchFieldException ex) {
            ex.printStackTrace();
        }
        Tuple<Object, JDBCType>[] binds = bindsToArray(listBinds);
        db.Execute(queryBuilder.toString(), binds);
        return 1;
    }

    public long delete(long id, DatabaseConnection db) {
        String tableName = getTableName(this.getClass());
        ResultSet result = db.Execute("DELETE FROM " + tableName + " WHERE ID = ?",
                new Tuple[]{
                        new Tuple<Object, JDBCType>(id, JDBCType.INTEGER)
                });
        return 1;
    }

    private List<Tuple<Object, JDBCType>> getBindings(T e, List<Field> fields) {
        List<Tuple<Object, JDBCType>> binds = new ArrayList<>();

        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            try {
                binds.add(new Tuple<Object, JDBCType>(field.get(e), TypeMapping.getJDBCType(field.getType())));
            } catch (IllegalAccessException ex) {
                binds.add(new Tuple<>(null, JDBCType.NULL));
            }
        }
        return binds;
    }

    private Tuple<Object, JDBCType>[] bindsToArray(List<Tuple<Object, JDBCType>> binds) {
        Tuple<Object, JDBCType>[] bindsArray = new Tuple[binds.size()];
        for (int i = 0; i < binds.size(); i++) {
            bindsArray[i] = binds.get(i);
        }
        return bindsArray;
    }

    private List<Field> getFields(T e, String[] fields) {
        List<Field> classFields = new ArrayList<>();
        if (fields != null && fields.length > 0 && fields[0].equals("*"))
            classFields.addAll(Arrays.asList(e.getClass().getFields()));
        else {
            for (String field : fields) {
                try {
                    classFields.add(e.getClass().getField(field));
                } catch (NoSuchFieldException ex) {
                    ex.printStackTrace();
                }
            }
        }
        classFields.removeIf(field -> field.isAnnotationPresent(AutoGenerated.class));

        return classFields;
    }

    private String insertQueryFieldsValue(List<Field> fields) {

        StringBuilder queryBuilder = new StringBuilder("(");
        for (Field field : fields) {
            queryBuilder.append(field.getName()).append(",");
        }
        queryBuilder.replace(queryBuilder.lastIndexOf(","), queryBuilder.lastIndexOf(",") + 1, ")");
        queryBuilder.append(" VALUES(");
        for (Field field : fields) {
            queryBuilder.append("?,");
        }
        queryBuilder.replace(queryBuilder.lastIndexOf(","), queryBuilder.lastIndexOf(",") + 1, ")");

        return queryBuilder.toString();
    }

    private String updateQueryFieldsValue(List<Field> fields) {

        StringBuilder queryBuilder = new StringBuilder("");
        for (Field field : fields) {
            queryBuilder.append(field.getName()).append(" = ?,");
        }
        queryBuilder.replace(queryBuilder.lastIndexOf(","), queryBuilder.lastIndexOf(",") + 1, " ");

        return queryBuilder.toString();
    }

    private String getTableName(Class<?> t) {
        String tableName = "";
        if (t.isAnnotationPresent(Table.class)) {
            tableName = t.getAnnotation(Table.class).name();
        } else {
            tableName = t.getName();
            String[] split = tableName.split("\\.");
            tableName = split[split.length - 1];
        }

        return tableName;

    }

    public List<String> getFieldNames(Class<?> c, List<Class<Annotation>> annotationsToIgnore) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = c.getFields();
        boolean add = true;
        for (Field field : fields) {
            if (annotationsToIgnore != null)
                for (Class<Annotation> annotation : annotationsToIgnore) {
                    add = !field.isAnnotationPresent(annotation);
                }
            if (add)
                fieldNames.add(field.getName());
        }
        return fieldNames;
    }

    public String name() {
        Class<?> c = this.getClass();
        if (c.isAnnotationPresent(Table.class))
            return c.getAnnotation(Table.class).name();
        return getTableName(c);
    }

    public abstract List<String> getPrettyNames();

    public List<Tuple<Type, Object>> getData(List<String> fields, Entity e) {
        List<Tuple<Type, Object>> data = new ArrayList<>();
        for (String field : fields) {
            try {
                Field f = e.getClass().getField(field);
                data.add(new Tuple<Type, Object>(f.getType(), f.get(e)));
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }
}
