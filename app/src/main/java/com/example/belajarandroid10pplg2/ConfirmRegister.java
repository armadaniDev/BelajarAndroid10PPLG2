package com.example.belajarandroid10pplg2;

import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmRegister extends AppCompatActivity {

    TextView tvUsername;

    TextView tvnama;
    TextView tvEmail;
    TextView tvAlamat;
    TextView tvNomor;
    TextView tvpass;
    TextView tvconfirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirm_register);

        tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvnama = (TextView)findViewById(R.id.tvnama);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvAlamat = (TextView)findViewById(R.id.tvAlamat);
        tvNomor = (TextView)findViewById(R.id.tvNomor);
        tvpass = (TextView)findViewById(R.id.tvpass);
        tvconfirmpass = (TextView)findViewById(R.id.tvconfirmpass);

        String nama = getIntent().getStringExtra("username");
        String nama1 = getIntent().getStringExtra("nama");
        String email = getIntent().getStringExtra("email");
        String alamat = getIntent().getStringExtra("alamat");
        String nomor = getIntent().getStringExtra("nomorHp");
        String pass = getIntent().getStringExtra("password");
        String confirm = getIntent().getStringExtra("cnfrmpassword");

        tvUsername.setText("welcome : "+ nama);
        tvnama.setText("nama : "+ nama);
        tvEmail.setText("email : "+ email);
        tvAlamat.setText("alamat : "+ alamat);
        tvNomor.setText("nomorHp : "+ nomor);
        tvpass.setText("password : "+ pass);
        tvconfirmpass.setText("confirm password : "+ confirm);
    }
}