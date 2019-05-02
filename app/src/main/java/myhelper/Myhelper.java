package myhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Myhelper extends SQLiteOpenHelper {

    private static final String databaseName ="DictionaryDB";
    private static final int dbVersion = 1;
    //tblWord fields

    private static final String tblWord = "tblWord";
    private static final String WordID = "WordID";
    private static final String Word = "Word";
    private static final String Meaning = "Meaning";

    //Constructor

    public Myhelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }
    public long InsertData(String word, String meaning, SQLiteDatabase db) {
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Word, word);
        contentValues.put(Meaning, meaning);
        id = db.insert(tblWord, null, contentValues);
        return id;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tblWord +
                "("
                + WordID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Word + " Text,"
                + Meaning + " Text " +
                ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
