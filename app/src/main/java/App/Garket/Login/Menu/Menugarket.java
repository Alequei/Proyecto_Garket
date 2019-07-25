package App.Garket.Login.Menu;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import App.Garket.Login.Fragmentos.DialogSecurity;
import App.Garket.Login.Fragmentos.Indicadores;
import App.Garket.Login.Fragmentos.OT_Programada;
import App.Garket.Login.Fragmentos.Principal;
import App.Garket.Login.Fragmentos.Registro_de_Equipos;
import App.Garket.Login.Fragmentos.Solicitud_de_Aviso;
import App.Garket.Login.Fragmentos.Visualizar_Avisos;
import App.Garket.Login.Fragmentos.Visualizar_Ordenes;
import App.Garket.Login.Logeo;
import App.Garket.Login.R;

public class Menugarket extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseUser currentuser;
    FirebaseAuth auth;
    private TextView nombrecorreo;
    private TextView nombre;
    private GoogleApiClient googleApiClient;
    private ImageView garket;
    private static final String TAG = "Menugarket";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menugarket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        garket=(ImageView)findViewById(R.id.imageGarket);
        nombrecorreo=(TextView)findViewById(R.id.correo);
        nombre=(TextView)findViewById(R.id.nombre);
        //Varialbes de Firebase
        auth=FirebaseAuth.getInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainlayout,new Principal()).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        updateNavHeader();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menugarket, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
        }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.solicitud_avisos) {
            getSupportActionBar().setTitle("Solicitud de avisos");
            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new Solicitud_de_Aviso()).commit();
        } else if (id == R.id.o_t_programadas) {
            getSupportActionBar().setTitle("O/T Programadas");

            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new OT_Programada()).commit();
        } else if (id == R.id.visualizar_avisos) {
            getSupportActionBar().setTitle("Visualizar Avisos");

            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new Visualizar_Avisos()).commit();
        } else if (id == R.id.visualizar_orden) {
            getSupportActionBar().setTitle("Visualizar Orden");

            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new Visualizar_Ordenes()).commit();
        } else if (id == R.id.indicadores) {
            getSupportActionBar().setTitle("Indicadores");

            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new Indicadores()).commit();
        } else if (id == R.id.registrar) {
            getSupportActionBar().setTitle("Registro de equipo");
            DialogSecurity dialogSecurity=new DialogSecurity();
            dialogSecurity.show(getSupportFragmentManager(),"Dialog Security");


        }else if(id == R.id.imageGarket){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new Principal()).commit();
        }
        else if (id == R.id.nav_close) {
            Intent loginactivity=new Intent(this, Logeo.class);

            startActivity(loginactivity);

            finish();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void updateNavHeader(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView=navigationView.getHeaderView(0);
        TextView navUsername=headerView.findViewById(R.id.nombre);
        TextView navUserEmail=headerView.findViewById(R.id.correo);
        navUserEmail.setText(currentuser.getEmail());

        navUsername.setText(currentuser.getDisplayName());
         garket.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 FragmentManager fragmentManager = getSupportFragmentManager();
                 fragmentManager.beginTransaction().replace(R.id.mainlayout,new Principal()).commit();
             }
         });
        //Ahora usaremos Glide para cargar la imagen del usuario.
        //Primero necesitamos importar la biblioteca.

    }


}
