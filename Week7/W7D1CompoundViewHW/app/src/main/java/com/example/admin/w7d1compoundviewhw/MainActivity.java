package com.example.admin.w7d1compoundviewhw;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.w7d1compoundviewhw.compoundview.LoginLayout;
import com.example.admin.w7d1compoundviewhw.customview.MyRectangleView;

public class MainActivity extends AppCompatActivity {

    private MyRectangleView myRectangleView;
    private Button btnLogin;
    private EditText etLogin;
    private Button btnSignUp;
    private EditText etPass;

    private String MY_SHARED_PREF = "mySharedPref";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        login();

        //get shared preferences, sharedpreference file
        sharedPreferences = getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);

        signUp();


    }

    private void signUp() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = etLogin.getText().toString();
                String pass = etPass.getText().toString();

                editor = sharedPreferences.edit();

                editor.putString("user", user);
                editor.putString("pass", pass);

                boolean isSaved = editor.commit();

                if (isSaved) {
                    Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    etLogin.setText("");
                    etPass.setText("");
                }


            }
        });
    }

    private void login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = sharedPreferences.getString("user", "no data");
                String pass = sharedPreferences.getString("pass", "no data");



                if (user.equals(etLogin.getText().toString()) && pass.equals(etPass.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void bindViews() {
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        etLogin = findViewById(R.id.etUserName);
        etPass = findViewById(R.id.etPassword);
        
    }
}
