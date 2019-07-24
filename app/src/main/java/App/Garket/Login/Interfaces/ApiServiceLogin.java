package App.Garket.Login.Interfaces;

import android.widget.EditText;

import java.util.List;

import App.Garket.Login.Clases.usuarios;
import App.Garket.Login.Mensaje.ResObj;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiServiceLogin {
    String API_BASE_URL = "https://api-garket-db.herokuapp.com/api/";
    @GET("usuarios/")

    Call<List<usuarios>> getusuarios();
}
