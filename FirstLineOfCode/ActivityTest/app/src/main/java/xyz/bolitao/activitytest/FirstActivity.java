package xyz.bolitao.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
         TODO: 如何使用 Chrome custom tabs？

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
            }
        });
    }
}
