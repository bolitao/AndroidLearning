package xyz.bolitao.exp06;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Handler myHander;
    private Button startButton;
    private Button endButton;
    private TextView textView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.start_button);
        endButton = findViewById(R.id.end_button);
        textView = findViewById(R.id.text_view);
        endButton.setEnabled(false);
        myHander = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x001) {
                    Bundle bundle = msg.getData();
                    int i = bundle.getInt("value");
                    textView.setText("当前已运行 " + i + " 秒");
                }
            }
        };
        intent = new Intent(this, MyService.class);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
                startButton.setEnabled(false);
                endButton.setEnabled(true);
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
                startButton.setEnabled(true);
                endButton.setEnabled(false);
            }
        });
    }
}
