package com.example.geolvide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registrarseActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText correo;
    private EditText contrasena;
    private EditText contrasenaConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth=FirebaseAuth.getInstance();

        correo= findViewById(R.id.editTextTextPersonName4);
        contrasena=findViewById(R.id.editTextTextPassword2);
        contrasenaConfirmar=findViewById(R.id.editTextTextPassword3);
    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser =mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void registrarUsuario(View view){

        if(contrasena.getText().toString().equals(contrasenaConfirmar.getText().toString())){

           mAuth.createUserWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                       @Override
                       public void onComplete (@NonNull Task <AuthResult> task){
                           if(task.isSuccessful()){
                               Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_SHORT).show();
                               FirebaseUser user= mAuth.getCurrentUser();
                               Intent i= new Intent(getApplicationContext(), MainActivity.class);
                               startActivity(i);
                           }else{
                               Toast.makeText(getApplicationContext(), "Autentication failed", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });

        }else{
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }

}