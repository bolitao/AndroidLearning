package xyz.bolitao.exp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView timeShow;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeShow = (TextView) findViewById(R.id.timeShow);
        Button button1 = (Button) findViewById(R.id.button1);
        Log.d("HelloWorldActivity", "onCreate: execute");
        Log.d(TAG, "onCreate: dd");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("" + new Date());
            }
        });
    }
}
