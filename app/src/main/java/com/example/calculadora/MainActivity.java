package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Resultado funcion;
    EditText num1;
    EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.txt_n1);
        num2 = findViewById(R.id.txt_n2);

        Button suma = findViewById(R.id.btn_suma);
        Button resta = findViewById(R.id.btn_resta);
        Button multiplicacion = findViewById(R.id.btn_multi);
        Button dividicion = findViewById(R.id.btn_divi);

        Intent pantalla = new Intent(this, ResultActivity.class);

        suma.setOnClickListener(this::onClickSuma);
        resta.setOnClickListener(this::onClickResta);
        multiplicacion.setOnClickListener(this::onClickMultiplicacion);
        dividicion.setOnClickListener(this::onClickDivision);
    }

    private void onClickSuma(View view) {
        try {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());

            funcion = new Resultado(n1, n2);

            int suma = funcion.sumar();
            mostrarResultados("suma", Integer.toString(suma));
        } catch (Exception e) {
            mostrarError();
        }
    }

    private void onClickResta(View view) {
        try {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());

            funcion = new Resultado(n1, n2);

            int resta = funcion.restar();
            mostrarResultados("resta", Integer.toString(resta));
        } catch (Exception e) {
            mostrarError();
        }
    }

    private void onClickMultiplicacion(View view) {
        try {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());

            funcion = new Resultado(n1, n2);

            int multi = funcion.multiplicar();
            mostrarResultados("Multiplicación", Integer.toString(multi));
        } catch (Exception e) {
            mostrarError();
        }
    }

    private void onClickDivision(View view) {
        try {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());

            funcion = new Resultado(n1, n2);

            int division = funcion.dividir();
            mostrarResultados("división", Integer.toString(division));
        } catch (Exception e) {
            mostrarError();
        }
    }

    private void mostrarResultados(String operacion, String resultado) {
        Intent pantalla = new Intent(this, ResultActivity.class);
        pantalla.putExtra("Operacion", operacion);
        pantalla.putExtra("Respuesta", resultado);
        startActivity(pantalla);
    }

    private void mostrarError() {
        Toast.makeText(this, "Ingrese los campos que estan vacios", Toast.LENGTH_LONG).show();
    }
}
