package com.maxiolguinmunoz.Tpractico3;

import static java.net.Proxy.Type.HTTP;

import android.content.Intent;
import android.net.Uri;
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

public class AcercaActivity extends AppCompatActivity {

    Button btnVolver;
    Button btnLlamar;
    Button btnEmail;
    EditText edtAsunto, edtMensaje;
    String gmail = "maxiolguinmunoz@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acerca);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.generarUI();
    }
    private void generarUI(){
        btnVolver = findViewById(R.id.btnVolver);
        btnLlamar = findViewById(R.id.btnLlamar);
        btnEmail = findViewById(R.id.btnEmail);
        edtAsunto = findViewById(R.id.edtAsunto);
        edtMensaje = findViewById(R.id.edtMensaje);
        String correo = "maxiolguinmunoz@gmail.com";
        Uri number = Uri.parse("tel:2954582566");

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcercaActivity.this, InicioActivity.class);
                startActivity(intent);
            }
        });
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });


       // String asunto = edtAsunto.getText().toString();
       // String mensaje = edtMensaje.getText().toString();

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{correo});
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_SUBJECT, edtAsunto.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, edtMensaje.getText().toString());

                startActivity(Intent.createChooser(email, "Enviar email."));

            }
        });
    }
}