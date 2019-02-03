package com.example.tarea1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConfirmarDatos extends AppCompatActivity {

    private TextView vtNombre;
    private TextView vtFecha;
    private TextView vtTelefono;
    private TextView vtEmail;
    private TextView vtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();

        final String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        final String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        final String email        = parametros.getString(getResources().getString(R.string.pemail));
        final String fecha        = parametros.getString(getResources().getString(R.string.pfecha));
        final String descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));

        vtNombre         = findViewById(R.id.tvName);
        vtTelefono       = findViewById(R.id.tvTel);
        vtEmail          = findViewById(R.id.tvEmail);
        vtFecha          = findViewById(R.id.tvFecha);
        vtDescripcion    = findViewById(R.id.tvDescripcion);

        vtNombre.setText("Nombre: " + nombre);
        vtTelefono.setText("Tel: " + telefono);
        vtEmail.setText("Email: " + email);
        vtFecha.setText("Fecha Nacimiento: " + fecha);
        vtDescripcion.setText("Descripción: " + descripcion);


        // El Boton

        Button btnEditar = findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);

                intent.putExtra(getResources().getString(R.string.pnombre), nombre);
                intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
                intent.putExtra(getResources().getString(R.string.pemail), email);
                intent.putExtra(getResources().getString(R.string.pfecha), fecha);
                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion);
                startActivity(intent);

            }
        });
    }


}
