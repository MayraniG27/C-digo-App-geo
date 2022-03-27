package com.example.geolvide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class IniciarSesionActivity extends AppCompatActivity {
    Button irMapa;
    EditText Latitud;
    EditText Longitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        irMapa = findViewById(R.id.button3);
        Latitud = findViewById(R.id.editTextTextPersonName2);
        Longitud = findViewById(R.id.editTextTextPassword3);

        irMapa.setOnClickListener((v) -> {

            if (Latitud.getText() != null && Longitud.getText() != null) {
                Intent i = new Intent(IniciarSesionActivity.this, MapaActivity.class);
                i.putExtra("Lati", Latitud.getText().toString());
                i.putExtra("longi", Longitud.getText().toString());
                startActivity(i);

            } else {
                Toast.makeText(IniciarSesionActivity.this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void irMapa(View view) {
        Intent i = new Intent(this, MapaActivity.class);
        startActivity(i);

    }
}
