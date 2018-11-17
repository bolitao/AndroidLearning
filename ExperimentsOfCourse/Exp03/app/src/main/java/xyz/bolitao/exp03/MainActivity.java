package xyz.bolitao.exp03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * @author Boli Tao
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinner;
    private Button clickButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        clickButton = findViewById(R.id.clickButton);
        imageView = findViewById(R.id.imageView);
        clickButton.setOnClickListener(this);
        imageView.setOnClickListener(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkBoxGroup:
                Toast.makeText(getApplicationContext(), "Hello world", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clickButton:
                Toast.makeText(getApplicationContext(), "You clicked \"点击\" button.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView:
                Toast.makeText(getApplicationContext(), "You clicked image.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
