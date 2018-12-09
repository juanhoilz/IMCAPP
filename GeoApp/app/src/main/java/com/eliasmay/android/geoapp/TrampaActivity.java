package com.eliasmay.android.geoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrampaActivity extends AppCompatActivity {
    public static String EXTRA_RESPUESTA_ES_CORRECTA = "com.eliasmay.android.geoapp.respuesta_es_correcta";
    public static String EXTRA_SE_MOSTRO_LA_RESPUESTA = "com.eliasmay.android.geoapp.respuesta_es_correcta";

    private Button mBotonMostrarRespuesta;

        private TextView mRespuestaTextView;
        public static boolean respuestaMostrada(Intent result){
            return  result.getBooleanExtra(EXTRA_SE_MOSTRO_LA_RESPUESTA,false);
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa);

        mRespuestaTextView = findViewById(R.id.respuesta_textview);
        mBotonMostrarRespuesta = findViewById(R.id.texto_boton_mostrar_respuesta);

        mBotonMostrarRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                boolean respuestaEsCorrecta = intent.getBooleanExtra(EXTRA_RESPUESTA_ES_CORRECTA, false);
                if (respuestaEsCorrecta) {
                    mRespuestaTextView.setText("Cierto");
                } else {
                    mRespuestaTextView.setText("Falso");
                }
            }});
    }
     private void setExtraSeMostroLaRespuesta(boolean seMostroLaRespuesta){
            Intent datos = new Intent();
            datos.putExtra(EXTRA_SE_MOSTRO_LA_RESPUESTA, seMostroLaRespuesta);
            setResult(RESULT_OK, datos);
     }
}
