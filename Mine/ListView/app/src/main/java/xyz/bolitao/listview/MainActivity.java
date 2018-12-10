package xyz.bolitao.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private int[] image = {R.drawable.watchdogs, R.drawable.halflife};
    private String[] description = {"WatchDogs", "HalfLife2"};
    //    private int length = description.length;
    private int length = 2;
    private ListView listView;
    private List<Map<String, Object>> list;
    private Map<String, Object> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < length; i++) {
            item = new HashMap<String, Object>(16);
            item.put("image", image[i]);
            item.put("description", description[i]);
            list.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.item,
                new String[]{"image", "description"}, new int[]{R.id.imageView, R.id.description1});
        listView.setAdapter(simpleAdapter);
    }
}
