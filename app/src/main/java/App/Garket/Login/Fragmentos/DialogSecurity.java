package App.Garket.Login.Fragmentos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import App.Garket.Login.R;

public class DialogSecurity extends DialogFragment {
    private static final String TAG = "DialogSecurity";
    private EditText codigo;
    private Button verificador;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.dialog_seguridad,container,false);

        codigo=view.findViewById(R.id.codigoseguridad);
        verificador=view.findViewById(R.id.verificador);
        verificador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Onclick:captura input");
                FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainlayout, new ListadorDeRegistro()).commit();
                    getDialog().dismiss();

                }

        });


        return view;
    }

}
