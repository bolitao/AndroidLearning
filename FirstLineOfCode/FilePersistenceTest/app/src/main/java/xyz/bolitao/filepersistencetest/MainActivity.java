package xyz.bolitao.filepersistencetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Boli Tao
 */
public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.main_edit_text);

        String inputString = load("data");
        if (!TextUtils.isEmpty(inputString)) {
            editText.setText(inputString);
            editText.setSelection(inputString.length());
            Toast.makeText(this, "文本框数据恢复成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String data = editText.getText().toString();
        save("data", data);
    }

    /**
     * 将传入的文本保存
     *
     * @param filename  文件名
     * @param inputText 从别处获得的文本
     */
    public void save(String filename, String inputText) {
        FileOutputStream outputStream = null;
        BufferedWriter writer = null;
        try {
            outputStream = openFileOutput(filename, MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回文件中的字符
     *
     * @param fileName 需要被读取的文件
     */
    public String load(String fileName) {
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        StringBuilder str = new StringBuilder();
        try {
            inputStream = openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                str.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str.toString();
    }
}
