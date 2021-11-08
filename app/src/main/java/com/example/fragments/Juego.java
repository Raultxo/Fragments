package com.example.fragments;

public class Juego {

    private String titulo;
    private String descripcion;
    private int anio;

    public Juego(String titulo, String descripcion, int anio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
