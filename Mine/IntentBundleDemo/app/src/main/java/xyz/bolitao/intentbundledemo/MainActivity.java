package xyz.bolitao.intentbundledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button cancleButton;
    private Button nextButton;
    private Button addressSelectButton;
    private TextView addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        cancleButton = findViewById(R.id.cancleButton);
        nextButton = findViewById(R.id.nextButton);
        addressSelectButton = findViewById(R.id.addressSelectButton);
        addressText = findViewById(R.id.addressText);
        cancleButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        addressSelectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextButton:
                Person person = new Person();
                person.setUsername(usernameEditText.getText().toString());
                person.setPassword(passwordEditText.getText().toString());
                person.setAddress(addressText.getText().toString());
                Intent intent = new Intent(MainActivity.this, ShowResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("person", person);
//                bundle.putString("province", addressText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.addressSelectButton:
                Intent selectAddressIntent = new Intent(MainActivity.this, SelectAddressActivity.class);
                startActivityForResult(selectAddressIntent, 0);
                break;
            case R.id.cancleButton:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String address = "";
            try {
                address = bundle.getString("province");
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (address != null) {
                addressText.setText(address);
            }
        }
    }
}
