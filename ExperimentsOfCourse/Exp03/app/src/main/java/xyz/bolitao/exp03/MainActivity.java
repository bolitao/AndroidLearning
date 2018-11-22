package xyz.bolitao.exp03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button clickButton;
    private ImageView imageView;
    private CheckBox reading;
    private CheckBox exercise;
    private RadioButton male;
    private RadioButton female;
    private RadioGroup radioGroup;
    private String[] address = {"湖南", "湖北", "广东"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(arrayAdapter);
        ArrayAdapter<String> addressAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, address);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(addressAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "你选择的是" + address[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        reading = findViewById(R.id.reading);
        exercise = findViewById(R.id.exercise);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
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
        radioGroup = findViewById(R.id.radioButtonGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == male.getId()) {
                    Toast.makeText(MainActivity.this, "的性别是：" + male.getText(), Toast.LENGTH_SHORT).show();
                } else if (checkedId == female.getId()) {
                    Toast.makeText(MainActivity.this, "你的性别是：" + female.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
