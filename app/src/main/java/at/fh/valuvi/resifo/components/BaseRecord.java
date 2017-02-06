package at.fh.valuvi.resifo.components;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import at.fh.valuvi.resifo.helpers.ArrayHelper;

public class BaseRecord extends BaseModel {

    public long id;
    public Boolean isNewRecord = true;

    protected SQLiteDatabase db = (new DatabaseConnection()).getDb();
    protected static final String[] excludeFields = new String[] {"tableName", "$change", "serialVersionUID"};

    public String getTableName() { return ""; }

    public Boolean save() {
        if (!validate()) { return false; }

        ContentValues values = new ContentValues();
        for (Field field: getFields()) {
            try {
                Object value = field.get(this);

                if (value == null) { continue; }

                // Date Type is Date or DateTime
                if (field.getType().isAssignableFrom(Date.class)) {
                    DataType dataType = field.getAnnotation(DataType.class);
                    if (dataType != null && dataType.type() == DataType.DATETIME) {
                        values.put(field.getName(), getDbDateTimeString((Date) value));
                    } else {
                        values.put(field.getName(), getDbDateString((Date) value));
                    }
                } else { // Other data types
                    values.put(field.getName(), String.valueOf(field.get(this)));
                }
            }
            catch (Exception e) { System.out.println(e); }
        }

        if (isNewRecord) {
            this.id = db.insert(getTableName(), null, values);
            this.isNewRecord = false;
        } else {
            db.update(getTableName(), values, "id=?", new String[] {String.valueOf(id)});
        }

        return true;
    }

    public void delete() {
        db.delete(getTableName(), "id=?", new String[] {String.valueOf(id)});
    }

    public Object find(int id) {
        Cursor cursor = findRecords(id);

        Object model;

        try {
            model = (cursor.moveToFirst()) ? fillModel(getNewModelInstance(), cursor) : null;
        } finally {
            cursor.close();
        }

        db.close();

        return model;
    }

    public Object find(HashMap<String, Object> attributes) {
        Cursor cursor = findRecords(attributes);

        Object model;
        try {
            model = (cursor.moveToFirst()) ? fillModel(getNewModelInstance(), cursor) : null;
        } finally {
            cursor.close();
        }

        db.close();

        return model;
    }

    public Object[] findAll() {
        return findAll(new HashMap<String, Object>());
    }

    public Object[] findAll(HashMap<String, Object> attributes) {
        Cursor cursor = findRecords(attributes);

        ArrayList<Object> models = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                Object newModel = fillModel(getNewModelInstance(), cursor);
                models.add(newModel);
            }
        } finally {
            cursor.close();
        }

        db.close();

        return models.toArray(new Object[] {});
    }

    protected Field[] getFields() {
        Field[] fields = this.getClass().getDeclaredFields();

        ArrayList<Field> list = new ArrayList<>();
        for (Field field: fields) {
            if (Arrays.asList(excludeFields).contains(field.getName())) { continue; }
            list.add(field);
        }

        return list.toArray(new Field[] {});
    }

    private Cursor findRecords(int id) {
        String sql = String.format("SELECT * FROM %s WHERE id=?", getTableName());

        return db.rawQuery(sql, new String[] {String.valueOf(id)});
    }

    private Cursor findRecords(HashMap<String, Object> attributes) {
        ArrayList<String> paramsSqlList = new ArrayList<>();
        ArrayList<String> paramsList = new ArrayList<>();
        for (Map.Entry<String, Object> attribute: attributes.entrySet()) {
            String paramSql = String.format("%s=?", attribute.getKey());
            paramsSqlList.add(paramSql);
            paramsList.add((String) attribute.getValue());
        }

        String paramsSql = new ArrayHelper(paramsSqlList).join(" AND ");
        String[] params = paramsList.toArray(new String[] {});

        String sql = (attributes.size() > 0)
                ? String.format("SELECT * FROM %s WHERE %s", getTableName(), paramsSql)
                : String.format("SELECT * FROM %s", getTableName());

        return db.rawQuery(sql, params);
    }

    private Object fillModel(Object model, Cursor cursor) {
        for (Field field: getFields()) {
            try {
                String value = cursor.getString(cursor.getColumnIndex(field.getName()));
                field.set(model, value);
            } catch(Exception e) { System.out.println(e); }
        }

        return model;
    }

}
