package com.example.a16alfonsofa.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLeer, btnCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCargar = (Button) findViewById(R.id.btnGuardarDatos);
        btnLeer = (Button) findViewById(R.id.btnCargarDatos);

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor= prefs.edit();
                editor.putString("nombre","Alfonso");
                editor.putString("apellidos","Fernandez Alvarez");
                editor.apply();

            }
        });

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String nombre = prefs.getString("nombre", "ANONIMO");
                String apellidos = prefs.getString("apellidos", "sin apellidos");


                Log.i("Preferencias", "nombre: " + nombre);
                Log.i("Preferencias", "apellidos: " + apellidos);
            }
        });
    }
}
