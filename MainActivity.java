package com.example.geolvide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText correo;
    private EditText contrasena;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo=findViewById(R.id.editTextTextPersonName);
        contrasena=findViewById(R.id.editTextTextPassword);

        mAuth=FirebaseAuth.getInstance();
    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();

    }

    public void iniciarSesion (View view){
        mAuth.signInWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user= mAuth.getCurrentUser();
                            Intent i=new Intent(getApplicationContext(), IniciarSesionActivity.class);
                            startActivity(i);
                            Toast.makeText(getApplicationContext(), "Authentication correct", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public void irIniciar (View view){
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);

    }

    public void  irRegistrarse (View view){
        Intent i = new Intent(this, registrarseActivity.class);
        startActivity(i);

    }

}