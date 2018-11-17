package xyz.bolitao.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Boli Tao
 */
public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        Button frameLayoutButton = findViewById(R.id.frameLayoutButton);
        frameLayoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frameLayoutButton:
                Intent intent = new Intent(RelativeLayoutActivity.this, FrameLayoutTest.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
