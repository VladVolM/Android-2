package com.example.a2_volodymyr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String NOMBRE="";
    private String APELLIDOS="";
    private int EDAD,VALORES=0,CANTIDAD=0;
    private Button button;
    Boolean presente=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);

        if (Estado.presente){
            NOMBRE=Estado.NOMBRE;
            APELLIDOS=Estado.APELLIDOS;
            EDAD=Estado.EDAD;
            VALORES=Estado.VALORES;
            CANTIDAD=Estado.CANTIDAD;
            presente=Estado.presente;
            ((TextView) findViewById(R.id.textView)).setText(getString(R.string.Hdatos));
            button.setText(getString(R.string.editar));
        }else {
            presente=Estado.presente;
            ((TextView) findViewById(R.id.textView)).setText(getString(R.string.inicio));
        }


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openActivityIntroducir();
            }

        });
    }

    public void openActivityIntroducir(){
        Intent intent = new Intent(MainActivity.this,IntroducirDatos.class);
        startActivityForResult(intent,1);
    }

    public void Valoracion(View v){
        Intent intent = new Intent(MainActivity.this,Valoracion.class);
        startActivityForResult(intent,2);
    }
    public void ver(View v){
        if (!NOMBRE.equals("") && !APELLIDOS.equals("")) {
            Intent intent = new Intent(MainActivity.this, VerDatos.class);
            intent.putExtra("nombre",NOMBRE);
            intent.putExtra("apellidos",APELLIDOS);
            intent.putExtra("edad",EDAD);
            if(CANTIDAD>0)
                intent.putExtra("media",VALORES/CANTIDAD);
            Log.d("Main","Ver datos");
            startActivity(intent);
        }
    }
    public void Salir(View v){
        finish();
        System.exit(0);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode==1){
            if (resultCode==RESULT_OK){

                EDAD=data.getIntExtra("edad",-1);
                if(EDAD==-1){
                    ((TextView) findViewById(R.id.textView)).setText(getString(R.string.NHdatos));
                    presente=false;
                }else{
                    ((TextView) findViewById(R.id.textView)).setText(getString(R.string.Dintro));
                    NOMBRE=data.getStringExtra("nombre");
                    APELLIDOS=data.getStringExtra("apellidos");
                    presente=true;
                    ((Button) findViewById(R.id.button)).setText(getString(R.string.editar));
                    ponerDatosClass();
                }
            }else{
                ((TextView) findViewById(R.id.textView)).setText(getString(R.string.NHdatos));
            }
        }else{
            if (resultCode==RESULT_OK){
                VALORES+=data.getIntExtra("valor",0);
                CANTIDAD+=1;
                ((TextView) findViewById(R.id.textView)).setText(getString(R.string.Vaplicado));
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        ponerDatosClass();
    }

    private void ponerDatosClass(){
        Estado.NOMBRE=NOMBRE;
        Estado.APELLIDOS=APELLIDOS;
        Estado.EDAD=EDAD;
        Estado.VALORES=VALORES;
        Estado.CANTIDAD=CANTIDAD;
        Estado.presente=presente;
    }
}
