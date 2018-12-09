package xyz.bolitao.intentbundledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResultActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Person person = null;
        String address = null;
        try {
            person = (Person) bundle.getSerializable("person");
            address = bundle.getString("province");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        textView = findViewById(R.id.resultTextView);
        String text = "您输入的信息是：\n";
        if (person != null) {
            text += "用户名：" + person.getUsername() + "\n";
            text += "密码:" + person.getPassword() + "\n";
            text += "地址：" + address;
        }
        textView.setText(text);
    }
}
