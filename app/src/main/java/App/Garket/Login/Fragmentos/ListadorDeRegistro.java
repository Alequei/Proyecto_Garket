package App.Garket.Login.Fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import App.Garket.Login.Adaptadores.AdaptadorRegistro;
import App.Garket.Login.Clases.almacen;
import App.Garket.Login.Interfaces.ApiServiceRegistro;
import App.Garket.Login.R;
import App.Garket.Login.Servidores.ApiServicioGeneratorRegistro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadorDeRegistro extends Fragment {
    private RecyclerView registroList;
    private static final String TAG = ListadorDeRegistro.class.getSimpleName();
    FloatingActionButton floatingActionButton;
    public ListadorDeRegistro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listador_de_registro, container, false);
        registroList = view.findViewById(R.id.listregistro);

        registroList.setLayoutManager(new LinearLayoutManager(getContext()));
        floatingActionButton=view.findViewById(R.id.fab);
        registroList.setAdapter(new AdaptadorRegistro());
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainlayout, new Registro_de_Equipos()).commit();

            }
        });
        initialize();

        return view;
    }
    private void initialize() {

        ApiServiceRegistro service = ApiServicioGeneratorRegistro.createService(ApiServiceRegistro.class);

        Call<List<almacen>> call = service.getalmacen();
        call.enqueue(new Callback<List<almacen>>() {
            @Override
            public void onResponse(Call<List<almacen>> call, Response<List<almacen>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<almacen> almacen= response.body();
                        Log.d(TAG, "buses: " + almacen);

                        AdaptadorRegistro adapter = (AdaptadorRegistro) registroList.getAdapter();
                        adapter.setAlmacenList(almacen);
                        adapter.notifyDataSetChanged();


                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<almacen>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getActivity() , t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
