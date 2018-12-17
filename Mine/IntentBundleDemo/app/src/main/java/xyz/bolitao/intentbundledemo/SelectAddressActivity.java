package xyz.bolitao.intentbundledemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectAddressActivity extends ListActivity {
    private String[] addresses = new String[]{"湖南", "湖北", "上海", "北京"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, addresses);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("province", addresses[position]);
        intent.putExtras(bundle);
        this.setResult(RESULT_OK, intent);
        finish();
    }
}
