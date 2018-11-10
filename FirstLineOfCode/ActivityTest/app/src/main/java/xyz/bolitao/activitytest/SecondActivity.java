package xyz.bolitao.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity (pressed back button)");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button buttonReceiveData = findViewById(R.id.button_receiveData);
        //只有从 FirstActivity 点击“传递数据”按钮才会有 Toast 显示“这是 FirstActivity 通过 Intent 传递的数据”
        // TODO: 解决按钮重叠问题
        buttonReceiveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");
                Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
                Log.d("onClick", "onClick: " + data);
            }
        });

        Button buttonReturnData = findViewById(R.id.button_returnDataInSecondActivity);
        buttonReturnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
