package App.Garket.Login.Interfaces;

import java.util.List;

import App.Garket.Login.Clases.ResponseMessage;
import App.Garket.Login.Clases.solicitud;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiServiceSolicitud {
    String API_BASE_URL = "https://api-garket-db.herokuapp.com/api";
    @GET("/solicitudes")
    Call<List<solicitud>> getSolicitudes();

    @FormUrlEncoded
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitud(@Field("codigodetec") String codigodetec,
                                         @Field("descripcion") String precio,
                                         @Field("fecha_fin") String fecha_inicio,
                                        @Field("hora_fin") String hora_inicio);

    @Multipart
    @POST("/solicitudes")
    Call<ResponseMessage> createSolicitudWithImage(
            @Part("codigodetec") RequestBody codigodetec,
            @Part("descripcion") RequestBody descripcion,
            @Part("fecha_fin") RequestBody fecha_inicio,
            @Part("hora_fin") RequestBody hora_inicio,
            @Part MultipartBody.Part imagen
    );

}
