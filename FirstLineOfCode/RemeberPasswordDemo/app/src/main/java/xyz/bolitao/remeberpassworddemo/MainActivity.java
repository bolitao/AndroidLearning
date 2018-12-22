package xyz.bolitao.remeberpassworddemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.remeberPasswordCheckBox);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isRemembered = preferences.getBoolean("isRemember", false);

        if (isRemembered) {
            usernameEditText.setText(preferences.getString("username", ""));
            passwordEditText.setText(preferences.getString("password", ""));
            checkBox.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (username.equals("admin") && password.equals("123456")) {
                    editor = preferences.edit();
                    if (checkBox.isChecked()) {
                        editor.putBoolean("isRemember", true);
                        editor.putString("username", username);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, AfterLoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "帐号或密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
