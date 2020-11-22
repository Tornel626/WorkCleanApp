package com.example.workcleanapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vista_Supervisor extends AppCompatActivity {
    Button atras;
    Button supervisa;
    Button notificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__supervisor);
        atras = (Button) findViewById(R.id.btnsalir);
        supervisa = (Button) findViewById(R.id.btnsuper);
        notificar = (Button) findViewById(R.id.noti);

        notificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newform = new Intent(Vista_Supervisor.this, com.example.workcleanapp.Noti_Supervisor.class);
                startActivity(newform);
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

    public void onsuper(View view){
        Intent newform = new Intent(Vista_Supervisor.this, com.example.workcleanapp.Vista_Supervisar.class);
        startActivity(newform);
    }

    public void onsalir(View view){
        Intent newform = new Intent(Vista_Supervisor.this, com.example.workcleanapp.MainActivity.class);
        startActivity(newform);
    }
}