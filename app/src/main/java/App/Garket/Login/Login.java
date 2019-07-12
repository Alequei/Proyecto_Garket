package App.Garket.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import App.Garket.Login.Menu.Menugarket;

public class Login extends AppCompatActivity {
    Button logeo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logeo=(Button)findViewById(R.id.logeo);
        logeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(getApplicationContext(), Menugarket.class);
                startActivity(intent);
            }
        });
    }
}
