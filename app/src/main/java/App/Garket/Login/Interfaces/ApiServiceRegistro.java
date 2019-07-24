package App.Garket.Login.Interfaces;

import java.util.List;

import App.Garket.Login.Clases.almacen;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceRegistro {
        String API_BASE_URL = "https://api-garket-db.herokuapp.com/api/";
        @GET("almacenes/")
        Call<List<almacen>> getalmacen();
    }

