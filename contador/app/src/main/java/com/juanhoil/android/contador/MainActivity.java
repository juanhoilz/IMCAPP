package com.juanhoil.android.contador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    private EditText campo ;
    private Button botonContador;
    private Button botonReiniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonContador = (Button) findViewById(R.id.botonConteo);
        botonReiniciar = (Button) findViewById(R.id.botonReinicio);
         campo = (EditText) findViewById(R.id.editTextConteo);

        botonContador.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String sCampo = campo.getText().toString();
            int conteo = Integer.parseInt(sCampo);
            conteo++;
            sCampo = String.valueOf(conteo);
            campo.setText(sCampo);
        }

        });
        botonReiniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                campo.setText("0");
            }

        });
    }
}
