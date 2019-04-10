package xyz.bolitao.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button saveDataButton;
    private Button restoreDataButton;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveDataButton = findViewById(R.id.save_data_button);
        restoreDataButton = findViewById(R.id.restore_data_button);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 21);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        restoreDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                Log.d(TAG, "onClick: name is " + preferences.getString("name", ""));
                Log.d(TAG, "onClick: age is " + preferences.getInt("age", 0));
                Log.d(TAG, "onClick: marriy status: " + preferences.getBoolean("married", false));
            }
        });
    }
}
