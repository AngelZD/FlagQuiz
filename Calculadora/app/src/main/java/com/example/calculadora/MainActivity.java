package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    public void cambioSigno(View view) {
        //Button buttonDigito = (Button) view;
        String resultado;
        if(!(textviewPantalla.getText().toString().equals("0.0"))) {
            resultado = textviewPantalla.getText().toString() + "¬";
        }
        else {
            resultado = "¬";
        }
        textviewPantalla.setText(resultado);
    }
    public void clear(View view) {
        textviewPantalla.setText("0.0");
    }
    public void funcionesGrandes(View view) {
        Button buttonDigito = (Button) view;
        String resultado;
        if(!(textviewPantalla.getText().toString().equals("0.0"))) {
            resultado = textviewPantalla.getText().toString() + buttonDigito.getText().toString() + " (";
        }
        else {
            resultado = buttonDigito.getText().toString() + " (";
        }
        textviewPantalla.setText(resultado);
    }
    public void resolver(View view){
        String post,prueba,resultado;
        prueba = textviewPantalla.getText().toString();
        Convertidor c = new Convertidor();
        Evaluador e = new Evaluador();
        post=c.separar(prueba);
        //Toast.makeText(this,"CadenaPost: \n"+post, Toast.LENGTH_SHORT).show();
        resultado=e.evaluar(post);
        //System.out.println("Post desde main "+post);
        textviewPantalla.setText(resultado);
        //Toast.makeText(this,"Se presiono resolver", Toast.LENGTH_SHORT).show();
    }
}
