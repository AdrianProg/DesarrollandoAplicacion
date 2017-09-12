package com.pa.adrian.desarrollandoaplicacion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String Tag="MainActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    Button boton;
    TextInputEditText editTextNombre;
    TextView editTextFecha;
    TextInputEditText editTextTelefono;
    TextInputEditText editTextEmail;
    TextInputEditText editTextDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton=(Button) findViewById(R.id.btnBoton);
        editTextNombre=(TextInputEditText) findViewById(R.id.teNombre);
        editTextFecha=(TextView) findViewById(R.id.tvDate);
        editTextTelefono=(TextInputEditText) findViewById(R.id.teTelefono);
        editTextEmail=(TextInputEditText) findViewById(R.id.teEmail);
        editTextDescripcion=(TextInputEditText) findViewById(R.id.teDescripcion);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnBoton:
                        String nombre= editTextNombre.getText().toString();
                        String fecha= editTextFecha.getText().toString();
                        String telefono= editTextTelefono.getText().toString();
                        String email= editTextEmail.getText().toString();
                        String descripcion= editTextDescripcion.getText().toString();

                        Intent intent= new Intent(MainActivity.this, ConfirmacionDatos.class);
                        intent.putExtra("Nombre",nombre);
                        intent.putExtra("Fecha",fecha);
                        intent.putExtra("Telefono",telefono);
                        intent.putExtra("Email",email);
                        intent.putExtra("Descripcion",descripcion);

                        startActivity(intent);
                        break;
                }

            }
        });

        mDisplayDate=(TextView) findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int day=cal.get(Calendar.DAY_OF_MONTH);
                int month=cal.get(Calendar.MONTH);
                int year=cal.get(Calendar.YEAR);


                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,
                        month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(Tag, "onDateSet: dd/mm/yy" + day + "/" + month + "/" + year);

                String date="Fecha nacimiento: " + day + "/" + month + "/" + year;
                mDisplayDate.setText(date);

            }
        };
    }
}
