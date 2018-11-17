package xyz.bolitao.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button launchRelativeActivityButton = (Button) (findViewById(R.id.launchRelativeActivityButton));
        launchRelativeActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.launchRelativeActivityButton:
                Intent intent = new Intent(getApplicationContext(), RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
