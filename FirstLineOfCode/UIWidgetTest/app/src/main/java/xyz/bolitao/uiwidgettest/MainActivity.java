package xyz.bolitao.uiwidgettest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * @author Boli Tao
 * 使用实现 OnClickListener 接口来监听点击事件
 * 同样可以使用匿名类的方式
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setOnClickListener(this);
        Button controlProgressBarButton = (Button) findViewById(R.id.button_controlProgressBar);
        controlProgressBarButton.setOnClickListener(this);
        progressBar = (ProgressBar) (findViewById(R.id.progress_bar));
        Button addProgressButton = (Button) (findViewById(R.id.button_addProgress));
        addProgressButton.setOnClickListener(this);
        Button alertDialogButton = (Button) (findViewById(R.id.alertDialogButton));
        alertDialogButton.setOnClickListener(this);
        Button progressDialogButton = (Button) (findViewById(R.id.progressDialogButton));
        progressDialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String string = editText.getText().toString();
                Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_view:
                imageView.setImageResource(R.drawable.a71169136);
                //TODO 实现轮换
                /*if (imageView.getResources().equals(R.drawable.tom)) {
                    imageView.setImageResource(R.drawable.a71169136);
                } else if (imageView.getResources().equals(R.drawable.a71169136)) {
                    imageView.setImageResource(R.drawable.tom);
                }*/
                break;
            case R.id.button_controlProgressBar:
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else if (progressBar.getVisibility() == View.VISIBLE) {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.button_addProgress:
                int progress = progressBar.getProgress();
                progress += 10;
                progressBar.setProgress(progress);
                break;
            case R.id.alertDialogButton:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("RUA!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.progressDialogButton:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is a ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
