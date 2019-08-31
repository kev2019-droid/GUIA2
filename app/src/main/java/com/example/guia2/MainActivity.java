package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button acceder;
    EditText correo;
    EditText contras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo = findViewById(R.id.txtcorreo);
        contras = findViewById(R.id.txtcontrasenia);
        acceder = findViewById(R.id.btnacceder);

        String corre = correo.getText().toString();
        String contra = contras.getText().toString();


        acceder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //edittext traendo los valores de ellos
        EditText contrase = findViewById(R.id.txtcontrasenia);
        EditText corre = findViewById(R.id.txtcorreo);

        // convirtiendo a String
        String contra = contrase.getText().toString();
        String correo = corre.getText().toString();

        if(correo.isEmpty())
        {
            Toast.makeText(this,"Porfavor llene el campo de correo",Toast.LENGTH_SHORT).show();
        }

        else if (contra.isEmpty() ) {

            Toast.makeText(this,"Porfavor llene el campo contraseña",Toast.LENGTH_SHORT).show();
        }

        else {

            switch (view.getId()) {
                case R.id.btnacceder:
                    Toast.makeText(this,"Bienvenido "+correo,Toast.LENGTH_LONG).show();
                    Intent segunda = new Intent(this, SegundaActivity.class);
                    startActivity(segunda);
                    break;

            }

        }
    }
}
