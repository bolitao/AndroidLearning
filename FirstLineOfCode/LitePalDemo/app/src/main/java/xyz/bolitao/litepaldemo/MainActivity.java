package xyz.bolitao.litepaldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button createDataButton;
    private Button addDataButton;
    private Button updateDataButton;
    private Button deleteDataButton;
    private Button queryDataButton;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDataButton = findViewById(R.id.createDatabaseButton);
        createDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });

        addDataButton = findViewById(R.id.addDataButton);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.9);
                book.setPress("Unknown");
                book.save();
            }
        });

        updateDataButton = findViewById(R.id.updateDataButton);
        updateDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Book book = new Book();
//                book.setName("The Lost Symbol");
//                book.setAuthor("Dan Brown");
//                book.setPrice(22.2);
//                book.setPages(512);
//                book.setPress("Unknown");
//                book.save();
//                book.setPrice(10.22);
//                book.save();
                Book book = new Book();
                book.setPrice(9.9);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
            }
        });

        deleteDataButton = findViewById(R.id.deleteDataButton);
        deleteDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class, "price < ?", "15");
            }
        });

        queryDataButton = findViewById(R.id.queryDataButton);
        queryDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> bookList = LitePal.findAll(Book.class);
                for (Book book : bookList) {
                    Log.d(TAG, "onClick: book name is " + book.getName());
                    Log.d(TAG, "onClick: book author is " + book.getAuthor());
                    Log.d(TAG, "onClick: book price is " + book.getPrice());
                    Log.d(TAG, "onClick: book pages is " + book.getPages());
                    Log.d(TAG, "onClick: book press is " + book.getPress());
                }
            }
        });
    }
}
