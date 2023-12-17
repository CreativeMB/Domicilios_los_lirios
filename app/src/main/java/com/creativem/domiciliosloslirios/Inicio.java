package com.creativem.domiciliosloslirios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);



        TextView irmoto = findViewById(R.id.moto);
        TextView irbici = findViewById(R.id.bici);

        // inicio animaciones
        ViewFlipper viewFlipper1 = findViewById(R.id.moto_slider);
        Animacionesimagenes animicionesInicios1 = new Animacionesimagenes(this, viewFlipper1);
        ViewFlipper viewFlipper2 = findViewById(R.id.bici_slider);
        Animacionesimagenes animicionesInicios2 = new Animacionesimagenes(this, viewFlipper2);


        irmoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Motos.class);
                startActivity(intent);
            }
        });

        irbici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bici.class);
                startActivity(intent);
            }
        });
    }
    }
