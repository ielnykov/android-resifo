package at.fh.valuvi.resifo.components;

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

    public DatabaseConnection() {
        super(Application.getAppContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        try { insertFromFile(R.raw.sql_dump); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public void insertFromFile(int resourceId) throws IOException {
        InputStream stream = Application.getAppContext().getResources().openRawResource(resourceId);
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