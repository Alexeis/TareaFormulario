package com.example.tarea1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etBirthday;
    Calendar calendario = Calendar.getInstance();

    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBirthday = findViewById(R.id.etBirthday);
        etBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etNombre   = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail    = findViewById(R.id.etEmail);
        etDescripcion    = findViewById(R.id.etDescripcion);

        Bundle parametros = getIntent().getExtras();

        if (parametros != null){
            final String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
            final String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
            final String email        = parametros.getString(getResources().getString(R.string.pemail));
            final String fecha        = parametros.getString(getResources().getString(R.string.pfecha));
            final String descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));

            etNombre.setText(nombre);
            etTelefono.setText(telefono);
            etBirthday.setText(fecha);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }

        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

                intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), etBirthday.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());

                startActivity(intent);
                // finish();
            }
        });

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };

    private void actualizarInput() {
        String formatoDeFecha = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        etBirthday.setText(sdf.format(calendario.getTime()));
    }


}
