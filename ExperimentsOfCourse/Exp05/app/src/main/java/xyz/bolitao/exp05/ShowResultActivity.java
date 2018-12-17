package xyz.bolitao.exp05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowResultActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Person person = null;
        try {
            person = (Person) bundle.getSerializable("person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "输入的信息是：\n用户名：";
        if (person != null) {
            str += person.getUserName() + "\n密码：";
            str += person.getUserPassword() + "\n地址：";
            str += person.getAddress();
        }
        textView.setText(str);
    }
}
