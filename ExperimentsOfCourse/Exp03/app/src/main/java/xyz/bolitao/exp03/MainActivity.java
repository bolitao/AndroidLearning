package xyz.bolitao.exp03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * @author Boli Tao
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinner;
    private Button clickButton;
    private ImageView imageView;
    private CheckBox reading;
    private CheckBox exercise;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        clickButton = findViewById(R.id.clickButton);
        imageView = findViewById(R.id.imageView);
        reading = findViewById(R.id.reading);
        exercise = findViewById(R.id.exercise);
        radioGroup = findViewById(R.id.radioButtonGroup);
        final RadioButton male = findViewById(R.id.male);
        final RadioButton female = findViewById(R.id.female);
        clickButton.setOnClickListener(this);
        imageView.setOnClickListener(this);
        View.OnClickListener onCheckBoxClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "你的爱好是：";
                if (reading.isChecked()) {
                    text = text + reading.getText().toString();
                }
                if (exercise.isChecked()) {
                    text = text + exercise.getText().toString();
                }
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        };
        reading.setOnClickListener(onCheckBoxClickListener);
        exercise.setOnClickListener(onCheckBoxClickListener);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == male.getId()) {
                    Toast.makeText(MainActivity.this, "你的性别是：" + male.getText(), Toast.LENGTH_SHORT).show();
                } else if (checkedId == female.getId()) {
                    Toast.makeText(MainActivity.this, "您的性别是：" + female.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
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
