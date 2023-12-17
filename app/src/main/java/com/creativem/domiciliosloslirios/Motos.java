package com.creativem.domiciliosloslirios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Motos extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motos);

        webView = findViewById(R.id.webView);
        FloatingActionButton fabButton2 = findViewById(R.id.Button_2);
        fabButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llama al método para reiniciar la actividad
                reiniciarActivity();
            }
        });

        FloatingActionButton fabButton = findViewById(R.id.Button_w);


        fabButton.setOnClickListener(view -> {
            try {
                String url = "https://api.whatsapp.com/send?phone=573014418502";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.e("MiApp", "No hay aplicaciones para manejar el intent");
                }
            } catch (Exception e) {
                Log.e("MiApp", "Error al intentar abrir el enlace", e);
            }
        });


        // Configuración del WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilitar JavaScript si es necesario
        webSettings.setBuiltInZoomControls(true); // Habilitar controles de zoom si es necesario

        webView.setWebViewClient(new MyWebViewClient());
        // Cargar la página web
        String url = "https://trello.com/b/IdSYdo4H/entrega-moto"; // Reemplaza con la URL de tu página web
        webView.loadUrl(url);
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

            TextView textViewError = findViewById(R.id.textViewError);
            textViewError.setVisibility(TextView.VISIBLE);
            webView.setVisibility(WebView.GONE);
            // Muestra un mensaje si hay un error al cargar la página
            Toast.makeText(Motos.this, "Verifica su conexión a Internet para ver los domicilios de floristeria los liros.", Toast.LENGTH_LONG).show();
        }


        }

    // Método para reiniciar la actividad
    private void reiniciarActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}