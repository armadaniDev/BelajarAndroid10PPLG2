package com.example.belajarandroid10pplg2;

import static com.example.belajarandroid10pplg2.R.id.edUsername;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;
    EditText edUsername;
    EditText edPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("Datauser", MODE_PRIVATE);
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek apakah user dan password nya admin
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                if(username.equals("admin") && password.equals("admin")){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("username", username);
                    editor.apply();
                    //sukses
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ListGame.class));
                }else{
                    //gagal
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}