package App.Garket.Login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.Map;

import App.Garket.Login.Menu.Menugarket;

public class Registrar_Usuario extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    static int PReqCode = 1;
    static int REQUESCODE = 1;
    private EditText useremail, password, nombre, apellido;
    private Button btRegister;
    private FirebaseAuth auth;
    private ProgressBar logindproce;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__usuario);
        //Llamado de variables
        mData= FirebaseDatabase.getInstance().getReference();
        useremail = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        logindproce = findViewById(R.id.progressBar);
        btRegister = findViewById(R.id.logeo);
        //
        logindproce.setVisibility(View.INVISIBLE);
        //Variable de Firebase
        auth = FirebaseAuth.getInstance();
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Registro", "onclick");

                btRegister.setVisibility(View.INVISIBLE);
                logindproce.setVisibility(View.VISIBLE);
                final String email = useremail.getText().toString();
                final String pass = password.getText().toString();
                final String nom = nombre.getText().toString();
                final String ape = apellido.getText().toString();
                //Condicion par a ver los campos

                if (email.isEmpty() || pass.isEmpty() || nom.isEmpty() || ape.isEmpty()) {
                    //algo sale mal: todos los campos deben ser rellenados
                    //necesitamos mostrar un mensaje de error
                    showMessage("Verifica todos los campos");
                    btRegister.setVisibility(View.VISIBLE);
                    logindproce.setVisibility(View.INVISIBLE);
                } else {
                    //todo está bien y todos los campos están completos ahora podemos comenzar a crear una cuenta de usuario
                    //El método Crear cuenta de usuario intentará crear el usuario si el correo electrónico es válido
                    CreateUserAccount(email, pass, nom,ape);
                }
            }
        });
    }
        private void CreateUserAccount (final String email, final String name, final String pass, final String ape){

            // this method  create user account with specific email and password

            auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("Nombre", name);
                        map.put("email", email);
                        map.put("pass", pass);
                        map.put("ape", ape);
                        String id = auth.getCurrentUser().getUid();
                        mData.child("User").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task2) {
                                if (task2.isSuccessful()) {
                                    updateUI();
                                }
                            }
                        });
                        showMessage("Cuenta Creada");
                    } else {
                        //account  creation falled
                        showMessage("Creación de Cuenta Fallida" + task.getException().getMessage());
                        btRegister.setVisibility(View.VISIBLE);
                        logindproce.setVisibility(View.INVISIBLE);
                    }
                }
            });


        }


        private void updateUI () {
            Intent reficlogeo = new Intent(getApplicationContext(), Menugarket.class);
            startActivity(reficlogeo);
            finish();
        }

        //Metodo para  enviar  el error
        private void showMessage (String message){

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        }


        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null) {
                //the user has successfully picked an image
                //we  need to save its reference to a Uri varial
            }
        }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

