package oliver.com.competitiontt;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDialogActivity extends Activity {

    Button btn_confirm,btn_cancel;
    TextView text_content,text_title,text_close;
    EditText username,password;
    String USERNAME,PASSWORD;


    private String PREF_FILE;
    Context context;
//    EditText username,password;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_custom_dialog);
        findView();

        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        text_close = (TextView) findViewById(R.id.text_close);
        text_title = (TextView) findViewById(R.id.text_title);
        text_content = (TextView) findViewById(R.id.text_content);


        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences getInfo = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
                final String NAME = getInfo.getString(USERNAME, "");
                final String PASS = getInfo.getString(PASSWORD, "");

                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(CustomDialogActivity.this, "欄位不可空白", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.getText().toString().equals(NAME) && password.getText().toString().equals(PASS)) {
                        Intent intent = new Intent();
                        intent.setClass(CustomDialogActivity.this, UserHomePage.class);
                        startActivity(intent);
                        Toast.makeText(CustomDialogActivity.this, "帳號驗證成功", Toast.LENGTH_SHORT).show();
                    } else if (!username.getText().toString().equals(NAME) || !password.getText().toString().equals(PASS)) {
                        Toast.makeText(CustomDialogActivity.this, "帳號驗證失敗", Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(CustomDialogActivity.this, "you click confirm!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomDialogActivity.this, "you click cancel!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        text_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomDialogActivity.this, "you click close!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    void findView(){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);

        context=this;

    }
}