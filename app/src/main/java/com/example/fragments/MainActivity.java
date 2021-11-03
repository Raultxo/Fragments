package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements JuegoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado fragmentListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.frgListado);

    }

    @Override
    public void onJuegoSeleccionado(Juego j) {

    }
}