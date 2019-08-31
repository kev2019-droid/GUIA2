package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity implements View.OnLongClickListener {
    AutoCompleteTextView fruta, animal, lenguaje;
    Button btprocesar;
    String[] frut = { "fresa","naranja","Manzana" };
    String[] lengua = { "C","JAVA","C#" };
    String[] anima = { "tigre","leon","mariposa" };
    ProgressBar bara;
    boolean activo = false;
    int i = 0;
    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle("saludos");
        }


        fruta = findViewById(R.id.txtfruta);
        animal = findViewById(R.id.txtanimal);
        lenguaje = findViewById(R.id.txtlenguaje);
        btprocesar = findViewById(R.id.btnprocesar);
        bara = findViewById(R.id.bar);

        ArrayAdapter<String> adapteranimal = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,anima);
        ArrayAdapter<String> adapterfruta = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,frut);
        ArrayAdapter<String> adapterlenguaje = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,lengua);



        animal.setThreshold(1);
        animal.setAdapter(adapteranimal);

        fruta.setThreshold(1);
        fruta.setAdapter(adapterfruta);

        lenguaje.setThreshold(1);
        lenguaje.setAdapter(adapterlenguaje);


        
        btprocesar.setOnLongClickListener(this);
    }
    public void mensaje(){
        String frutas = fruta.getText().toString();
        String animals = animal.getText().toString();
        String lengua = lenguaje.getText().toString();

        Toast.makeText(getApplicationContext(),"cosas favoritas:" +" fruta: "+frutas+" animal: "+animals+" lenguaje de programacion: "+lengua,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.btnprocesar: {
                //  setProgressValue(0);


                Thread carga = new Thread(new Runnable() {
                    @Override
                    public void run() {


                        while (i <= 100) {
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    bara.setProgress(i);
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==100)
                            {

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mensaje();
                                    }
                                });


                            }


                            i = i+20;
                        }


                    }
                });  carga.start();



            }

            break;
        }
        return false;
    }
}
