package com.example.workcleanapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.btningresar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.contraseña)).getText().toString();
                if (usuario.equals("pedrope@gmail.com") && contraseña.equals("pedrope1")){
                    Intent newform = new Intent(MainActivity.this,Vista_Empresa.class);
                    startActivity(newform);
                }else if (usuario.equals("pablora@gmail.com") && contraseña.equals("pablora1")){
                    Intent newform = new Intent(MainActivity.this,Vista_Supervisor.class);
                    startActivity(newform);
                }else if (usuario.equals("juanro@gmail.com") && contraseña.equals("juanro1")){
                    Intent newform = new Intent(MainActivity.this, com.example.workcleanapp.Vista_Empleado.class);
                    startActivity(newform);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea salir de WorkClean?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}