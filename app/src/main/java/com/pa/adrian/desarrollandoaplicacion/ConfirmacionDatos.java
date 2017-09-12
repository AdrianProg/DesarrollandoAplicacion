package com.pa.adrian.desarrollandoaplicacion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    Button boton;
    TextView nombreText ;
    TextView fechaText;
    TextView telefonoText;
    TextView emailText;
    TextView descripcionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        boton=(Button) findViewById(R.id.btnBotonBack);

        nombreText=(TextView) findViewById(R.id.tvActivity2Nombre);
        fechaText=(TextView) findViewById(R.id.tvActivity2Fecha);
        telefonoText=(TextView) findViewById(R.id.tvActivity2Telefono);
        emailText=(TextView) findViewById(R.id.tvActivity2Email);
        descripcionText=(TextView) findViewById(R.id.tvActivity2Descripcion);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                }

        });

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("Nombre");
        String fecha = parametros.getString("Fecha");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");


        nombreText.setText("Nombre completo: " + nombre);
        fechaText.setText(fecha);
        telefonoText.setText("Teléfono: " + telefono);
        emailText.setText("Email: " + email);
        descripcionText.setText("Descripción: " + descripcion);

    }
}
