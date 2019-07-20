package App.Garket.Login.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import App.Garket.Login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Solicitud_de_Aviso extends Fragment {

    ImageView foto_codigo,close;
    public Solicitud_de_Aviso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_solicitud_de__aviso, container, false);
        foto_codigo=view.findViewById(R.id.imagenplacaid);

        foto_codigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDetector dialogDetector=new DialogDetector();
                dialogDetector.show(getFragmentManager(),"Dialogo Detector");
            }
        });

        return view;
    }

}
