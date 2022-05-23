package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,email;
    Button register;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        username=(EditText) findViewById(R.id.etRegEmail);
        email=(EditText) findViewById(R.id.etRegPass);
        register=(Button) findViewById(R.id.btnRegister);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

            String name=sharedPreferences.getString(KEY_NAME,null);

            if (name!=null){
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,username.getText().toString());
                editor.putString(KEY_EMAIL,email.getText().toString());
                editor.apply();
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Register successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}