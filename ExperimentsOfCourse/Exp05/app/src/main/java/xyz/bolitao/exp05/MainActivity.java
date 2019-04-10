package xyz.bolitao.exp05;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
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
    private Button addressButton;
    private TextView addressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        cancleButton = findViewById(R.id.cancleButton);
        nextButton = findViewById(R.id.nextButton);
        addressButton = findViewById(R.id.addressButton);
        addressTextView = findViewById(R.id.addressTextView);
        usernameEditText.setOnClickListener(this);
        passwordEditText.setOnClickListener(this);
        cancleButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        addressButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancleButton:
                finish();
                break;
            case R.id.nextButton:
                Intent intent = new Intent(MainActivity.this, ShowResultActivity.class);
                Bundle bundle = new Bundle();
                Person person = new Person();
                person.setUserName(usernameEditText.getText().toString());
                person.setUserPassword(passwordEditText.getText().toString());
                person.setAddress(addressTextView.getText().toString());
                bundle.putSerializable("person", person);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.addressButton:
                Intent addressSelectIntent = new Intent(MainActivity.this, AddressSelectActivity.class);
                startActivityForResult(addressSelectIntent, 0);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            try {
                Bundle bundle = data.getExtras();
                addressTextView.setText(bundle.getString("province"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
