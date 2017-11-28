package oliver.com.competitiontt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_login, btn_search,btn_reg,btn_talk,btn_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.login);
        btn_search = (Button) findViewById(R.id.search);
        btn_reg = (Button)findViewById(R.id.reg);
        btn_talk = (Button)findViewById(R.id.talk);
        btn_up = (Button)findViewById(R.id.updata) ;

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CustomDialogActivity.class);
                startActivity(it);

            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, searchActivity.class);
                startActivity(it);
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,RegActivity.class);
                startActivity(it);
            }
        });
        btn_talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,talkActivity.class);
                startActivity(it);
            }
        });
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,UpDataActivity.class);
                startActivity(it);
            }
        });
    }


}


