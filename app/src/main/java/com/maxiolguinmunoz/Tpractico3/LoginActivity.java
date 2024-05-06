package com.maxiolguinmunoz.Tpractico3;

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

public class LoginActivity extends AppCompatActivity {
    EditText edtUsuario, edtContra;
    Button btnLogear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.generarUI();
    }

    private void generarUI(){
        btnLogear = findViewById(R.id.btnLogin);
        edtContra = findViewById(R.id.edtPass);
        edtUsuario = findViewById(R.id.edtUser);

        btnLogear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsuario.getText().toString().equals("alumno") && edtContra.getText().toString().equals("1234")){
                    Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(LoginActivity.this, R.string.incorrect_pass_or_username, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}