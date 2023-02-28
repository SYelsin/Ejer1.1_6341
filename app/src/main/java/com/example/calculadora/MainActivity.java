package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.txt_n1);
        num2 = findViewById(R.id.txt_n2);

        Button suma = findViewById(R.id.btn_suma);
        Button resta = findViewById(R.id.btn_resta);
        Button multiplicacion = findViewById(R.id.btn_multi);
        Button division = findViewById(R.id.btn_divi);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] numeros = obtenerNumeros();
                if (numeros != null) {
                    int result = numeros[0] + numeros[1];
                    enviarResultado("suma", result);
                }
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] numeros = obtenerNumeros();
                if (numeros != null) {
                    int result = numeros[0] - numeros[1];
                    enviarResultado("resta", result);
                }
            }
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] numeros = obtenerNumeros();
                if (numeros != null) {
                    int result = numeros[0] * numeros[1];
                    enviarResultado("multiplicación", result);
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] numeros = obtenerNumeros();
                if (numeros != null) {
                    if (numeros[1] == 0) {
                        Toast.makeText(getApplicationContext(), "No se puede dividir por cero", Toast.LENGTH_LONG).show();
                    } else {
                        int result = numeros[0] / numeros[1];
                        enviarResultado("división", result);
                    }
                }
            }
        });
    }

    private int[] obtenerNumeros() {
        try {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());
            return new int[] {n1, n2};
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Ingrese números válidos", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    private void enviarResultado(String operacion, int resultado) {
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra("operacion", operacion);
        intent.putExtra("resultado", resultado);
        startActivity(intent);
    }
}
