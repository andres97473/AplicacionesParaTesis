package app.umariana.com.persistenciacondatosestructurados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by davidguerrero on 9/09/16.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_empresa";
    public static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + DbManager.TABLE_NAME);
        onCreate(db);
    }
}
