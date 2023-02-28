package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Busca los TextView en el layout y los guarda en variables
        TextView txtResultado = findViewById(R.id.txtresultado);
        TextView txtOperacion = findViewById(R.id.txt_Operacion);

        // Obtiene los valores de los extras del Intent
        Intent intent = getIntent();
        int resultadoCalculo = intent.getIntExtra("resultado", 0);
        String operacion = intent.getStringExtra("operacion");

        // Muestra el resultado y la operación en los TextViews
        txtOperacion.setText("El resultado de la " + operacion + " es:");
        txtResultado.setText(String.valueOf(resultadoCalculo));

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