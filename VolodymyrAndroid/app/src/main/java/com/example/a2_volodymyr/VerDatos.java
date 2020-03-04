package com.example.a2_volodymyr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerDatos extends AppCompatActivity {

    TextView nom;
    TextView ape;
    TextView eda;
    TextView val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        nom = (TextView) findViewById(R.id.textView8);
        ape = (TextView) findViewById(R.id.textView9);
        eda = (TextView) findViewById(R.id.textView10);
        val = (TextView) findViewById(R.id.textView11);

        Intent intent = getIntent();
        nom.setText(intent.getStringExtra("nombre"));
        ape.setText(intent.getStringExtra("apellidos"));
        eda.setText(""+intent.getIntExtra("edad",0));
        val.setText(""+intent.getIntExtra("media",0));
    }

}
