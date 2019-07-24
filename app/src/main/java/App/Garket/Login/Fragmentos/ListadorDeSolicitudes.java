package App.Garket.Login.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import App.Garket.Login.R;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadorDeSolicitudes extends Fragment {


    public ListadorDeSolicitudes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listador_de_solicitudes, container, false);
    }

}
