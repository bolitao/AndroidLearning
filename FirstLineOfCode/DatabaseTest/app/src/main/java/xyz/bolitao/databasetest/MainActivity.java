package xyz.bolitao.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import xyz.bolitao.databasetest.database.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper myDatabaseHelper;

    private Button createTableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);

        createTableButton = findViewById(R.id.createTableButton);

        createTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();
            }
        });
    }
}
