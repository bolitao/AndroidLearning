package xyz.bolitao.myim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

/**
 * @author Boli Tao
 * @date 2018/12/21
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mainDrawerLayout;
    private FloatingActionButton newChatFloatingActionButton;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        mainDrawerLayout = findViewById(R.id.main_layout);
        initNavigation();

        newChatFloatingActionButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO
                return false;
            }
        });

        newChatFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                //TODO: after clicking search menu, there should be a fragment/ activity showing
                return true;
            default:
        }
        return false;
    }

    /**
     * 使用 Fragment 替换 FrameLayout
     *
     * @param sourceID    被替换的资源 ID，常用 R.id.xxx
     * @param newFragment 要显示的 Fragment
     */
    public void replaceFragment(int sourceID, Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(sourceID, newFragment);
        transaction.commit();
    }


    private void initNavigation() {
        navigationView = findViewById(R.id.main_navigation);
        newChatFloatingActionButton = findViewById(R.id.new_chat_floating_button);
        navigationView.setCheckedItem(R.id.nav_chat);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_new_chat:
//                mainDrawerLayout.closeDrawer(GravityCompat.START);
                navigationView.setCheckedItem(R.id.nav_new_chat);
                return false;
            case R.id.nav_new_secret_chat:
                mainDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            case R.id.nav_chat:
                navigationView.setCheckedItem(R.id.nav_chat);
                mainDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_contact:
                navigationView.setCheckedItem(R.id.nav_contact);
                mainDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_addContact:
                mainDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            case R.id.nav_settings:
                mainDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            case R.id.nav_help_and_feedback:
                mainDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
                return false;
            default:
                return true;
        }
    }
}
