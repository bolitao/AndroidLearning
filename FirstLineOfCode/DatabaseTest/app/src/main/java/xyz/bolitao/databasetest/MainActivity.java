package xyz.bolitao.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import xyz.bolitao.databasetest.database.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    private Button createTableButton;
    private Button addDataButton;
    private Button updateDataButton;
    private Button deleteDataButton;
    private Button queryDataButton;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);

        createTableButton = findViewById(R.id.createTableButton);
        createTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        addDataButton = findViewById(R.id.add_dataButton);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.9);
                db.insert("book", null, values);
                values.clear();
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values);
            }
        });

        updateDataButton = findViewById(R.id.update_data_button);
        updateDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.9);
                updateDataButton.setText("RUA!");
                db.update("book", values, "name=?", new String[]{"The Da Vinci Code"});
            }
        });

        deleteDataButton = findViewById(R.id.deleteDataButton);
        deleteDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("book", "pages > ?", new String[]{"500"});
            }
        });

        queryDataButton = findViewById(R.id.queryDataButton);
        queryDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("book", null, null, null, null, null, null, null);
                // moveToFirst method will return false if the cursor is empty
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG, "onClick: book name is " + name);
                        Log.d(TAG, "onClick: book author is " + author);
                        Log.d(TAG, "onClick: book pages is " + pages);
                        Log.d(TAG, "onClick: book price is " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
