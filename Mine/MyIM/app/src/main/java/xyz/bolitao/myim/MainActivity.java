package xyz.bolitao.myim;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * @author Boli Tao
 * @date 2018/12/21
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
     * 替换 Fragment 的方法
     *
     * @param sourceID    被替换的资源 ID，常用 R.id.xxx
     * @param newFragment 要显示的 Fragment
     */
    public void replaceFragment(int sourceID, Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(sourceID, newFragment);
        transaction.commit();
    }
}
