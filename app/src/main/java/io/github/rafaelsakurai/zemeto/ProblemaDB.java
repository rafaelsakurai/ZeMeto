package io.github.rafaelsakurai.zemeto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaelsakurai on 20/03/2018.
 */
public class ProblemaDB extends SQLiteOpenHelper {

    private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public ProblemaDB(Context context) {
        super(context, "Ze", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Problema (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descricao TEXT, data TEXT, status INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Problema salvar(Problema problema) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("descricao", problema.getDescricao());
        values.put("data", df.format(problema.getData()));
        values.put("status", problema.isArrumado() ? 1 : 0);
        if(problema.getId() == null) {
            Long id = db.insert("Problema", null, values);
            problema.setId(id);
        } else {
            String[] whereArgs = {String.valueOf(problema.getId())};
            db.update("Problema", values, "_id = ?", whereArgs);
        }
        db.close();
        return problema;
    }

    public List<Problema> consultarTodos() {
        List<Problema> problemas = new ArrayList();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, descricao, data, status FROM Problema ORDER BY _id", null);
        cursor.moveToFirst();

        for(int i = 0; i < cursor.getCount(); i++) {
            try {
                Problema problema = new Problema(
                        cursor.getLong(0),
                        cursor.getString(1),
                        df.parse(cursor.getString(2))
                );
                problema.setArrumado(cursor.getInt(3) == 0 ? false : true);
                problemas.add(problema);
                cursor.moveToNext();
            } catch (Exception e) {}
        }

        db.close();
        return problemas;
    }
}
