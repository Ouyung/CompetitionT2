package oliver.com.competitiontt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.R.attr.name;
import static oliver.com.competitiontt.R.id.password;

public class RegActivity extends AppCompatActivity {
    private static final String TAG = "FirebaseAuth";
    EditText unit, name, job, mail, etpassword,etpassword2;
    Button register;
    Intent intent;
    private String PREF_FILE;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    String UNIT, NAME, JOB, MAIL, PASSWORD, PASSWORD2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        findViews();
        setListeners();
    }

    private void findViews() {

        unit = (EditText) findViewById(R.id.et_unit);
        name = (EditText) findViewById(R.id.et_name);
        job = (EditText) findViewById(R.id.et_job);
        mail = (EditText) findViewById(R.id.et_mail);
        etpassword = (EditText) findViewById(R.id.et_password);
        etpassword2 = (EditText) findViewById(R.id.et_password2);
        register = (Button) findViewById(R.id.register);


    }

    private void setListeners() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mail.getText().toString();
                String password = etpassword.getText().toString();
//                String unit1 = unit.getText().toString();
//                String name1 = name.getText().toString();
//                String job1 = job.getText().toString();



                signUp(email,password);
            }
        });
    }
    private void signUp(String email,String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegActivity.this, "註冊失敗",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(RegActivity.this, "註冊成功",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegActivity.this, CustomDialogActivity.class);
                            startActivity(intent);

                        }

                        // ...
                    }
                });

    }

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (unit.length()!=0 && name.length()!=0 && job.length()!=0 && mail.length() != 0 &&  password.length() != 0 && password2.length() != 0) {
//                    Intent intent = new Intent();
//                    intent.setClass(RegActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    restore();
//                } else {
//                    Toast.makeText(RegActivity.this, "欄位不可空白", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//
//    private void restore() {
//        SharedPreferences settings = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
//
//
//        settings.edit().putString(UNIT, unit.getText().toString()).commit();
//        settings.edit().putString(NAME, name.getText().toString()).commit();
//        settings.edit().putString(JOB, job.getText().toString()).commit();
//        settings.edit().putString(MAIL, mail.getText().toString()).commit();
//        settings.edit().putString(PASSWORD, password.getText().toString()).commit();
//        settings.edit().putString(PASSWORD2, password2.getText().toString()).commit();
//        Toast.makeText(RegActivity.this, "註冊成功", Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }
}



