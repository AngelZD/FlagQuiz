package com.example.calculadora;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class BasicCalculator extends Fragment implements View.OnClickListener{
    TextView textviewPantalla;

    public BasicCalculator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_calculator, container, false);

    }


    @Override
    public void onClick(View view) {

    }
    public void cambioSigno(View view){
    }
    public void clear(View view){

    }
    public void resolver(View view){

    }
}
