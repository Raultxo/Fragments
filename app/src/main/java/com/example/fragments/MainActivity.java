package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements JuegoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado fragmentListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.frgListado);
        fragmentListado.setJuegoListener(this);

    }

    @Override
    public void onJuegoSeleccionado(Juego j) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().
                    findFragmentById(R.id.frgDetalle)).mostrarDetalle(j.getDescripcion());
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, j.getDescripcion());
            startActivity(i);
        }
    }
}