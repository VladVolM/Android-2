package com.example.a2_volodymyr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class IntroducirDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_datos);
        if (Estado.presente) {
            ((EditText) findViewById(R.id.editText2)).setText(Estado.NOMBRE);
            ((EditText) findViewById(R.id.editText3)).setText(Estado.APELLIDOS);
            ((EditText) findViewById(R.id.editText)).setText(String.valueOf(Estado.EDAD));
        }
    }

    public void Aceptar(View v){
        tratarDatos(true);
    }
    public void Cancelar(View v){
        tratarDatos(false);
    }
    private void tratarDatos(Boolean d){

        if(d){
            EditText edit1 = (EditText) findViewById(R.id.editText2);
            String nombre = edit1.getText().toString();

            EditText edit2 = (EditText) findViewById(R.id.editText3);
            String apellidos = edit2.getText().toString();


            EditText edit3 = (EditText) findViewById(R.id.editText);
            int edad =Integer.parseInt(edit3.getText().toString());

            Intent intent = new Intent(this,VerDatos.class);

            intent.putExtra("nombre",nombre);
            intent.putExtra("apellidos",apellidos);
            intent.putExtra("edad",edad);
            setResult(RESULT_OK,intent);
            Log.d("Datos","Aceptado");
        }else {
            setResult(RESULT_CANCELED);
            Log.d("Datos","Cancelado");
        }

        finish();
    }
}
