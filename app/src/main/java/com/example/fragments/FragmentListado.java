package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {

    private Juego[] datos = new Juego[] {
            new Juego("Dark Souls", "RPG de accion", 2010),
            new Juego("Elden Ring", "RPG de accion de mundo abierto", 2021),
            new Juego("World of Warcraft", "MMO RPG de mundo abierto", 2004),
            new Juego("CandyBox", "Juego idle de navegador", 2008)
    };

    private ListView lstListado;
    private JuegoListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView) getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorJuego(this));
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onJuegoSeleccionado(
                            (Juego) lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorJuego extends ArrayAdapter<Juego> {
        Activity context;

        AdaptadorJuego(Fragment context) {
            super(context.getActivity(), R.layout.listitem_juego, datos);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_juego, null);
            TextView txtTitulo = (TextView) item.findViewById(R.id.titulo);
            txtTitulo.setText(datos[position].getTitulo());

            TextView txtAnio = (TextView) item.findViewById(R.id.anio);
            txtAnio.setText(String.valueOf(datos[position].getAnio()));

            return (item);
        }

    }

    public void setJuegoListener(JuegoListener listener) {
        this.listener = listener;
    }
}
