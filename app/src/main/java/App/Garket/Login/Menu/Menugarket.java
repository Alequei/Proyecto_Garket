package App.Garket.Login.Menu;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menugarket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainlayout,new Principal()).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
            getSupportActionBar().setTitle("Registrar equipo");

            getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout,new Registro_de_Equipos()).commit();
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
}
