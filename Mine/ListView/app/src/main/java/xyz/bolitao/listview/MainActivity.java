package xyz.bolitao.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Boli Tao
 */
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Map<String, Object>> data;
    private Map<String, Object> item;
    private int[] image = {R.drawable.asuka, R.drawable.avator};
    private String[] description = {"Eva", "Avator"};
    private final int LENGTH = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        data = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < LENGTH; i++) {
            item = new HashMap<String, Object>();
            item.put("photo", image[i]);
            item.put("description", description[i]);
            data.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item,
                new String[] {"photo", "description"}, new int[] {R.id.photo, R.id.textView1});
        listView.setAdapter(simpleAdapter);
    }
}
