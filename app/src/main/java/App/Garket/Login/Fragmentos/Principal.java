package App.Garket.Login.Fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import App.Garket.Login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Principal extends Fragment {

    CardView bt1,bt2,bt3,bt4,bt5,bt6;
    public Principal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.fragment_principal, container, false);
        bt1=vista.findViewById(R.id.avisoid);
        bt2=vista.findViewById(R.id.programadaid);
        bt3=vista.findViewById(R.id.visu_avisoid);
        bt4=vista.findViewById(R.id.visu_ordenesid);
        bt5=vista.findViewById(R.id.indicadoresid);
        bt6=vista.findViewById(R.id.regisequipoid);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout,new Solicitud_de_Aviso()).commit();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout,new OT_Programada()).commit();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout,new Visualizar_Avisos()).commit();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout,new Visualizar_Ordenes()).commit();
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout,new Indicadores()).commit();
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout,new Registro_de_Equipos()).commit();
            }
        });

        return vista;
    }

}
