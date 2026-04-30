package com.example.belajarandroid10pplg2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    EditText edNama;
    EditText edEmail;
    EditText edAlamat;
    EditText edNomorWa;
    EditText etpass;
    EditText edConfirm;
    Button btnRegis;
    Button btnBackLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        edNama = (EditText) findViewById(R.id.edNama);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edAlamat = (EditText) findViewById(R.id.edAlamat);
        edNomorWa = (EditText) findViewById(R.id.edNomorWa);
        etpass = (EditText) findViewById(R.id.etpass);
        edConfirm = (EditText) findViewById(R.id.edConfirm);
        btnRegis = (Button) findViewById(R.id.btnRegis);
        btnBackLogin = (Button) findViewById(R.id.btnBackLogin);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edNama.getText().toString().trim();
                String email = edEmail.getText().toString().trim();
                String alamat = edAlamat.getText().toString().trim();
                String nomor = edNomorWa.getText().toString().trim();
                String pass = etpass.getText().toString().trim();
                String confirm = edConfirm.getText().toString().trim();
                if (nama.isEmpty() || email.isEmpty() || alamat.isEmpty() || nomor.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(Register.this, "Semua Wajib Diisi", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!email.endsWith("@gmail.com")) {
                    edEmail.setError("Email harus menggunakan @gmail.com");
                    edEmail.requestFocus();
                    return;
                }
                if (pass.length() < 6) {
                    etpass.setError("Password minimal 6 karakter");
                    etpass.requestFocus();
                    return;
                }
                if (!confirm.equals(pass)) {
                    edConfirm.setError("Password tidak sama");
                    edConfirm.requestFocus();
                    return;
                }
                edNama.setText("");
                edEmail.setText("");
                edAlamat.setText("");
                edNomorWa.setText("");
                etpass.setText("");
                edConfirm.setText("");
                Toast.makeText(Register.this, "Register Sukses", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this, ConfirmRegister.class);
                intent.putExtra("username", nama);
                intent.putExtra("email", email);
                intent.putExtra("alamat", alamat);
                intent.putExtra("nomorHp", nomor);
                intent.putExtra("password", pass);
                intent.putExtra("cnfrmpassword", confirm);
                startActivity(intent);
            }
        });
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
    }
}