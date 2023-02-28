package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView texto = (TextView)findViewById(R.id.txtresultado);
        TextView ope = (TextView)findViewById(R.id.txt_Operacion);
        Intent pantalla = getIntent();
        String operacion = pantalla.getStringExtra("Operacion");
        String result = pantalla.getStringExtra("Respuesta");
        texto.setText(result);
        ope.setText("El resultado de la " +operacion + " es:");
        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la actividad actual y vuelve a la anterior
                finish();
            }
        });
    }
}
