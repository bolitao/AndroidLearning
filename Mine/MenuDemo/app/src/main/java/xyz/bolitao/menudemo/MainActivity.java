package xyz.bolitao.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.center_text);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu_0:
                break;
            case R.id.context_menu_1:
                break;
            case R.id.context_menu_2:
                finish();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_0:
                Toast.makeText(MainActivity.this, "你点击了菜单 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_menu_1:
                Toast.makeText(MainActivity.this, "你点击了菜单 2", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "启动快捷菜单活动", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, ContextMenuTestActivity.class);
//                startActivity(intent);
                break;
            case R.id.main_menu_2:
                Toast.makeText(MainActivity.this, "你点击了退出", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
