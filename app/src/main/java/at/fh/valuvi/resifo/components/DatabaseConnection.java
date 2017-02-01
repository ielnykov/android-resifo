package at.fh.valuvi.resifo.components;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import at.fh.valuvi.resifo.R;

public class DatabaseConnection extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "resifo.sqlite";
    public SQLiteDatabase db;
    private Context context;

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        try { System.out.println("POWER!!!");insertFromFile(context, R.raw.sql_dump); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public void insertFromFile(Context context, int resourceId) throws IOException {
        InputStream stream = context.getResources().openRawResource(resourceId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        while (reader.ready()) {
            String line = reader.readLine();
            getDb().execSQL(line);
        }

        reader.close();
    }

    public SQLiteDatabase getDb() {
        if (db == null || !db.isOpen()) {
            db = getWritableDatabase();
        }

        return db;
    }

}