package App.Garket.Login.Fragmentos;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import App.Garket.Login.R;
public class Barras extends Fragment implements ZXingScannerView.ResultHandler {
    private ZXingScannerView escanerView;

    public Barras() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view= inflater.inflate(R.layout.fragment_barras, container, false);
        EscanerQR(view);
        return  view;
    }
    public void EscanerQR(View view){
        escanerView=new ZXingScannerView(getContext());
        setContentView(escanerView);
        escanerView.resumeCameraPreview(this);
        escanerView.startCamera();
    }

    private void setContentView(ZXingScannerView escanerView) {
    }


    @Override
    public void onPause() {
        super.onPause();
        escanerView.stopCamera();
        this.finish();
    }

    private void finish() {

    }

    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Resultado del Scanner");
        builder.setMessage("Resultado: "+result.getText()+"\n"+"Formato: "+result.getBarcodeFormat());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
    }

}

