package App.Garket.Login.Interfaces;

import android.widget.EditText;

import java.util.List;

import App.Garket.Login.Mensaje.ResObj;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceLogin {
    String API_BASE_URL = "https://api-garket-db.herokuapp.com/api/";

    @GET("usuarios/{usuario}/{contraseña}")

    Call getusuarios(@Path("username") String user, @Path("contraseña") String pass);
}
