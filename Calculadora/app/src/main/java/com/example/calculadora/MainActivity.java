package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textviewPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textviewPantalla = this.findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        Button buttonDigito = (Button) view;
        String resultado;
        if(!(textviewPantalla.getText().toString().equals("0.0"))) {
            resultado = textviewPantalla.getText().toString() + buttonDigito.getText().toString();
        }
        else {
            resultado = buttonDigito.getText().toString();
        }
        textviewPantalla.setText(resultado);
    }
}
