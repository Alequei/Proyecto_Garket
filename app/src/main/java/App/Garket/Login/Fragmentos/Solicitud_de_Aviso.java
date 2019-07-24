package App.Garket.Login.Fragmentos;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import App.Garket.Login.Clases.ResponseMessage;
import App.Garket.Login.Interfaces.ApiServiceSolicitud;
import App.Garket.Login.R;
import App.Garket.Login.Clases.solicitud;
import App.Garket.Login.Servidores.ApiServicioSolicitudGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Solicitud_de_Aviso extends Fragment {
    private ImageView imagePreview;
    private EditText clase_equipoinput;
    private EditText fecha_fin;
    private EditText hora_fin;
    private  Button guardar;
    ProgressBar progressBar;
    private EditText observacioninput;
    private List<solicitud> solicituds;

    ImageView foto_codigo,close;
    private static final String TAG = Registro_de_Equipos.class.getSimpleName();
    public Solicitud_de_Aviso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view;
        view=inflater.inflate(R.layout.fragment_solicitud_de__aviso, container, false);
        imagePreview = view.findViewById(R.id.imagenplacaid);
        clase_equipoinput = view.findViewById(R.id.equipo);
        observacioninput = view.findViewById(R.id.observacionid);
        guardar=view.findViewById(R.id.btnRegistrar);
        progressBar=view.findViewById(R.id.progressBar);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        progressBar.setVisibility(view.INVISIBLE);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar.setVisibility(view.INVISIBLE);
                progressBar.setVisibility(view.VISIBLE);

            }
        });
        //Llamamso al campo Dialogo
        foto_codigo=view.findViewById(R.id.imagenplacaid);
        foto_codigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDetector dialogDetector=new DialogDetector();
              /*  TextView dialog_ubicacion=v.findViewById(R.id.dialog_ubicacion);
                TextView dialog_equipo=v.findViewById(R.id.dialog_equipo);
                TextView dialog_FechaI=v.findViewById(R.id.dialog_fechaI);
                TextView dialog_HoraI=v.findViewById(R.id.dialog_hora);
                dialog_ubicacion.setText(solicituds.get(view.getId()).getAlmacen().getUbicacion());
                dialog_equipo.setText(solicituds.get(view.getId()).getAlmacen().getEquipo());
                dialog_FechaI.setText(solicituds.get(view.getId()).getFecha_inicio());
                dialog_HoraI.setText(solicituds.get(view.getId()).getHora_inicio());*/
                dialogDetector.show(getFragmentManager(),"Dialogo Detector");
            }
        });

//        callRegister();
//        initialize();
        return view;
    }
    private static final int CAPTURE_IMAGE_REQUEST = 300;

    private Uri mediaFileUri;

    public void takePicture(View view) {
        try {

            if (!permissionsGranted()) {
                ActivityCompat.requestPermissions(getActivity(), PERMISSIONS_LIST, PERMISSIONS_REQUEST);
                return;
            }

            // Creando el directorio de imágenes (si no existe)
            File mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    throw new Exception("Failed to create directory");
                }
            }

            // Definiendo la ruta destino de la captura (Uri)
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
            mediaFileUri = Uri.fromFile(mediaFile);

            // Iniciando la captura
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mediaFileUri);
            startActivityForResult(intent, CAPTURE_IMAGE_REQUEST);

        } catch (Exception e) {
            Log.e(TAG, e.toString());
            Toast.makeText(getContext(), "Error en captura: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

 /*   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_REQUEST) {
            // Resultado en la captura de la foto
            if (resultCode == Activity.RESULT_OK) {
                try {
                    Log.d(TAG, "ResultCode: RESULT_OK");
                    // Toast.makeText(this, "Image saved to: " + mediaFileUri.getPath(), Toast.LENGTH_LONG).show();

                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), mediaFileUri);

                    // Reducir la imagen a 800px solo si lo supera
                    bitmap = scaleBitmapDown(bitmap, 800);

                    imagePreview.setImageBitmap(bitmap);
                } catch (Exception e) {
                    Log.d(TAG, e.toString());
                    Toast.makeText(getContext(), "Error al procesar imagen: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d(TAG, "ResultCode: RESULT_CANCELED");
            } else {
                Log.d(TAG, "ResultCode: " + resultCode);
            }
        }
    }*/


    public void callRegister() {

        String observacion = observacioninput.getText().toString();
        String equipo = clase_equipoinput.toString();
        String fin = fecha_fin.getText().toString();
        String Hfin = hora_fin.getText().toString();

        if (equipo.isEmpty() || observacion.isEmpty()) {
            Toast.makeText(getContext(), "Nombre y equipo son campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiServiceSolicitud service = ApiServicioSolicitudGenerator.createService(ApiServiceSolicitud.class);

        Call<ResponseMessage> call =  service.createSolicitud( observacion,equipo,fin,Hfin);

        /*if (mediaFileUri == null) {
            // Si no se incluye imagen hacemos un envío POST simple
            call = service.createSolicitud( observacion,equipo,fin,Hfin);
        } else {
            // Si se incluye hacemos envió en multiparts

            File file = new File(mediaFileUri.getPath());
            Log.d(TAG, "File: " + file.getPath() + " - exists: " + file.exists());

            // Podemos enviar la imagen con el tamaño original, pero lo mejor será comprimila antes de subir (byteArray)
            // RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);

            Bitmap bitmap = BitmapFactory.decodeFile(mediaFileUri.getPath());

            // Reducir la imagen a 800px solo si lo supera
            bitmap = scaleBitmapDown(bitmap, 800);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
            MultipartBody.Part imagenPart = MultipartBody.Part.createFormData("imagen", file.getName(), requestFile);

            RequestBody nombrePart = RequestBody.create(MultipartBody.FORM, nombre);
            RequestBody precioPart = RequestBody.create(MultipartBody.FORM, precio);
            RequestBody detallesPart = RequestBody.create(MultipartBody.FORM, detalles);

            call = service.createProductoWithImage(nombrePart, precioPart, detallesPart, imagenPart);
        }*/

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                        Toast.makeText(getActivity(), responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                        finish();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
    private void initialize() {
        ApiServiceSolicitud service1 = ApiServicioSolicitudGenerator.createService(ApiServiceSolicitud.class);

        Call<List<solicitud>> call = service1.getSolicitudes();

        call.enqueue(new Callback<List<solicitud>>() {
            @Override
            public void onResponse(Call<List<solicitud>> call1 , Response<List<solicitud>> response) {
                try {
                    int code = response.code();
                    Log.d(TAG, "HTTP status code: " + code);
                    if (response.isSuccessful()) {
                        List<solicitud> viajes= response.body();
                        Log.d(TAG, "buses: " + viajes);
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
            public void onFailure(Call<List<solicitud>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }






    private void finish() {
    }

    private static final int PERMISSIONS_REQUEST = 200;

    private static String[] PERMISSIONS_LIST = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private boolean permissionsGranted() {
        for (String permission : PERMISSIONS_LIST) {
            if (ContextCompat.checkSelfPermission(getContext(), permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                for (int i = 0; i < grantResults.length; i++) {
                    Log.d(TAG, "" + grantResults[i]);
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getContext(), PERMISSIONS_LIST[i] + " permiso rechazado!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Toast.makeText(getContext(), "Permisos concedidos.", Toast.LENGTH_LONG).show();
                takePicture(null);
            }
        }
    }

    // Redimensionar una imagen bitmap
    private Bitmap scaleBitmapDown(Bitmap bitmap, int maxDimension) {

        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int resizedWidth = maxDimension;
        int resizedHeight = maxDimension;

        if (originalHeight > originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = (int) (resizedHeight * (float) originalWidth / (float) originalHeight);
        } else if (originalWidth > originalHeight) {
            resizedWidth = maxDimension;
            resizedHeight = (int) (resizedWidth * (float) originalHeight / (float) originalWidth);
        } else if (originalHeight == originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = maxDimension;
        }
        return Bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
    }

}


