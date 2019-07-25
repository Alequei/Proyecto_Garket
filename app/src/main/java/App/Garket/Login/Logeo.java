package App.Garket.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import App.Garket.Login.Interfaces.ApiServiceLogin;
import App.Garket.Login.Mensaje.ResObj;
import App.Garket.Login.Menu.Menugarket;
import App.Garket.Login.Servidores.ApiServicioLoginGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logeo extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = Logeo.class.getSimpleName();
    Button logeo;
    EditText username;
    EditText password;
    ImageView registro_user;
    ProgressBar progressbar;
    private FirebaseAuth auth;
    private Intent MenuGarket;
    public static final int SING_IN_CODE=777;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo);
        logeo=(Button)findViewById(R.id.logeo);
        auth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        MenuGarket = new Intent(this, Menugarket.class);//Llamas al campo principal
        progressbar=findViewById(R.id.progressBar);
        progressbar.setVisibility(View.INVISIBLE);
        registro_user=findViewById(R.id.Registro_user);
        registro_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(getApplicationContext(),Registrar_Usuario.class);
                startActivity(intent);
            }
        });
        logeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar.setVisibility(View.VISIBLE);
                logeo.setVisibility(View.INVISIBLE);
               final String user = username.getText().toString().trim();
              final  String pass = password.getText().toString().trim();

     /*           if (validatelogin(user, pass)){
                    Intent intent = new Intent(getApplicationContext(), Menugarket.class);
                    startActivity(intent);
                } else if((validatelogin1(user, pass))) {
                    Intent intent = new Intent(getApplicationContext(), Menugarket.class);
                    startActivity(intent);
                }
                else if((validatelogin2(user, pass))) {
                    Intent intent = new Intent(getApplicationContext(), Menugarket.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Logeo.class);
                    startActivity(intent);
                }
            }*/
                if (user.isEmpty() || pass.isEmpty()) {
                    showMessage("Verificar los campos");
                    logeo.setVisibility(View.VISIBLE);
                    progressbar.setVisibility(View.INVISIBLE);
                } else {
                    logearce(user, pass);
                }
            }
        });
    }
    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
    private void logearce(String user, String pass) {
        auth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressbar.setVisibility(View.INVISIBLE);
                    logeo.setVisibility(View.VISIBLE);
                    updateUI();
                } else {

                    showMessage(task.getException().getMessage());
                    logeo.setVisibility(View.VISIBLE);
                    progressbar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    private void updateUI() {
        startActivity(MenuGarket);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuario = auth.getCurrentUser();
        if (usuario != null) {
            //el usuario ya está conectado, así que tenemos que redirigirlo a la página de inicio
            updateUI();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SING_IN_CODE){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            goMainScreen();
        }else {
            Toast.makeText(this,"No se puede iniciar sesion",Toast.LENGTH_SHORT).show();
        }
    }
    private void goMainScreen() {
        Intent intent=new Intent(this,Menugarket.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }




    private boolean validatelogin1(String user, String pass) {
        if (user.equals(61914455) && user.trim().length()==8){
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(pass.equals("alex123") ){
          Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(this, "Password y usuarios incorrectos", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
    private boolean validatelogin2(String user, String pass) {
        if (user.equals(64915574) && user.trim().length()==8){
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(pass.equals("jeremi123") ){
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(this, "Password y usuarios incorrectos", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
    private boolean validatelogin(String user, String pass) {
        if (user.equals(44323343) && user.trim().length()==8){
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(pass.equals("perez123") ){
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(this, "Password y usuarios incorrectos", Toast.LENGTH_SHORT).show();

        }
        return false;
    }


    /*    private void doLogin(final String user, String pass) {
        ApiServiceLogin service = ApiServicioLoginGenerator.createService(ApiServiceLogin.class);
        Call  call = service.getusuarios(user ,pass);
        call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response  response) {
                    if (response.isSuccessful()) {
                        ResObj resObj = (ResObj) response.body();
                        if (resObj.getMessage().equals("true")) {
                            //login start main activity
                            Intent intent = new Intent(Logeo.this, Menugarket.class);
                            intent.putExtra("usuario", user);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Logeo.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Logeo.this,"Please try again !", Toast.LENGTH_SHORT).show();
                    }
                }



           @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Logeo.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}
