package xyz.bolitao.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Boli Tao
 */
public class FirstActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", "onActivityResult: " + returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        Button buttonQuit = (Button) findViewById(R.id.button_quit);
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonExplicitIntent = (Button) findViewById(R.id.button_explicit_intent);
        buttonExplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button buttonImplicitIntent = (Button) findViewById(R.id.button_implicit_intent);
        /*
        摘抄
        为什么这里没有指定 category？
        因为 android.intent.category.DEFAULT 是一种默认的 category，在调用 startActivity() 方法时会自动将这个 category 添加到 Intent 中
        */
        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("xyz.bolitao.activitytest.ACTIONI_START");
                intent.addCategory("xyz.bolitao.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        Button buttonMoreIntentUsage = (Button) findViewById(R.id.button_more_intent_usage);
        /*
         调用浏览器
         TODO: 使用 Chrome Custom Tabs
         在 Manifest 文件中配置 ThirdActivity 时响应的 data 类型是严格对应的，比如 Uri.parse("http://bolitao.xyz") 就得写 http
         如果链接换成了 https://* 则写成 <data android:scheme="https" />
         把这两个都写上去也没问题
         */
        buttonMoreIntentUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://bolitao.xyz"));
                startActivity(intent);
            }
        });

        Button buttonDial = (Button) findViewById(R.id.button_dial);
        // 调用电话
        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123321"));
                startActivity(intent);
            }
        });

        Button buttonDataDeliver = (Button) findViewById(R.id.button_deliverData);
        buttonDataDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                String data = "这是 FirstActivity 通过 Intent 传递的数据";
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });

        Button buttonReturnData = findViewById(R.id.button_returnDataInFirstActivity);
        buttonReturnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}
