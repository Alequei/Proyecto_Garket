package App.Garket.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import App.Garket.Login.Interfaces.ApiServiceLogin;
import App.Garket.Login.Mensaje.ResObj;
import App.Garket.Login.Menu.Menugarket;
import App.Garket.Login.Servidores.ApiServicioLoginGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logeo extends AppCompatActivity {
    private static final String TAG = Logeo.class.getSimpleName();
    Button logeo;
    EditText username;
    EditText password;
    ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo);
        logeo=(Button)findViewById(R.id.logeo);
        username = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        progressbar=findViewById(R.id.progressBar);
        progressbar.setVisibility(View.INVISIBLE);
        logeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar.setVisibility(View.VISIBLE);
                logeo.setVisibility(View.INVISIBLE);
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (validatelogin(user, pass)){
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
            }
        });
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
