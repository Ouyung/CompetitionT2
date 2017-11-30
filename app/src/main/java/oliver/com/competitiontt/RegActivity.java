package oliver.com.competitiontt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;
import static oliver.com.competitiontt.R.id.password;

public class RegActivity extends AppCompatActivity {
    EditText unit, name, job, mail, password, password2;
    Button register;
    Intent intent;
    private String PREF_FILE;
    String UNIT, NAME, JOB, MAIL, PASSWORD, PASSWORD2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        unit = (EditText) findViewById(R.id.et_unit);
        name = (EditText) findViewById(R.id.et_name);
        job = (EditText) findViewById(R.id.et_job);
        mail = (EditText) findViewById(R.id.et_mail);
        password = (EditText) findViewById(R.id.et_password);
        password2 = (EditText) findViewById(R.id.et_password2);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (unit.length()!=0 && name.length()!=0 && job.length()!=0 && mail.length() != 0 &&  password.length() != 0 && password2.length() != 0) {
                    Intent intent = new Intent();
                    intent.setClass(RegActivity.this, MainActivity.class);
                    startActivity(intent);
                    restore();
                } else {
                    Toast.makeText(RegActivity.this, "欄位不可空白", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void restore() {
        SharedPreferences settings = getSharedPreferences(PREF_FILE, MODE_PRIVATE);


        settings.edit().putString(UNIT, unit.getText().toString()).commit();
        settings.edit().putString(NAME, name.getText().toString()).commit();
        settings.edit().putString(JOB, job.getText().toString()).commit();
        settings.edit().putString(MAIL, mail.getText().toString()).commit();
        settings.edit().putString(PASSWORD, password.getText().toString()).commit();
        settings.edit().putString(PASSWORD2, password2.getText().toString()).commit();
        Toast.makeText(RegActivity.this, "註冊成功", Toast.LENGTH_SHORT).show();
    }
}



