package com.example.a2_volodymyr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Valoracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion);
    }

    public void Aceptar(View v){
        tratarDatos(true);
    }
    public void Cancelar(View v){
        tratarDatos(false);
    }
    private void tratarDatos(Boolean d){

        if(d){

            int valor =Integer.parseInt(((EditText) findViewById(R.id.editText4)).getText().toString());
            if (valor>5)
                valor=5;
            else
                if(valor<0)
                    valor=0;

            Intent intent = new Intent(this,Valoracion.class);
            intent.putExtra("valor",valor);

            setResult(RESULT_OK,intent);
            Log.d("Valoracion","Aceptada");
        }else {
            setResult(RESULT_CANCELED);
            Log.d("Valoracion","Cancelada");
        }
        finish();
    }
}
