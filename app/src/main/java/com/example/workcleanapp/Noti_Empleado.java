package com.example.workcleanapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Noti_Empleado extends AppCompatActivity {

    private EditText Caja;
    private Button enviar;
    private Button cancelar;
    EditText textonoti;
    TextView txtvista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti__empleado);
        enviar = (Button) findViewById(R.id.btnenviar);
        cancelar = (Button) findViewById(R.id.btncancelar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newform = new Intent(Noti_Empleado.this, com.example.workcleanapp.Vista_Empleado.class);
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

    public void MostrarTexto(View v){
        textonoti = (EditText)findViewById(R.id.textonoti);
        txtvista = (TextView)findViewById(R.id.txtvista);

        String a = textonoti.getText().toString();
        txtvista.setText(a);
        Toast.makeText(Noti_Empleado.this, a, Toast.LENGTH_LONG).show();
    }

    public void Borrar(View v){
        textonoti = (EditText)findViewById(R.id.textonoti);
        txtvista = (TextView)findViewById(R.id.txtvista);

        textonoti.setText("");
        txtvista.setText("");
        Toast.makeText(Noti_Empleado.this, "Texto borrado", Toast.LENGTH_LONG).show();
    }
}