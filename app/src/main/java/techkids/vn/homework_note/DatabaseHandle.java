package techkids.vn.homework_note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Admins on 10/11/2017.
 */

public class DatabaseHandle extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "list_note.db";
    private static int DATABASE_VERSION = 1;

    private static String TABLE_NAME = "tbl_notes";
    private static String TITLE = "title";
    private static String DESCRIPTION = "des";

    private static DatabaseHandle databaseHandle;
    public static DatabaseHandle getInstance(Context context) {
        if (databaseHandle == null) {
            databaseHandle = new DatabaseHandle(context);
        }
        return databaseHandle;
    }

    private DatabaseHandle(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tạo bảng trong db
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + " (" + TITLE + " text, " + DESCRIPTION + " text);");
    }

    // Đc gọi khi thêm 1 bảng mới / thêm 1 cột vào 1 bảng trong db
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Xóa bảng (tương đương xóa toàn bộ dữ liệu)
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);

        // Tạo lại bảng
        onCreate(sqLiteDatabase);
    }

    public void addNote(NoteModel noteModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        // thêm record vào db = cách dùng ContentValues
        // tất cả những gì lquan đến việc thay đổi db đều dùng ContentValues
        ContentValues values = new ContentValues();

        values.put(TITLE, noteModel.getTitle());
        values.put(DESCRIPTION, noteModel.getDescription());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    public ArrayList<NoteModel> getAllNote() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<NoteModel> listNote = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                NoteModel noteModel = new NoteModel(cursor.getString(0), cursor.getString(1));
                listNote.add(noteModel);
                cursor.moveToNext();
            }
        }

        return listNote;
    }
}
