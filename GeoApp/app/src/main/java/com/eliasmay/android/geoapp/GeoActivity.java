package com.eliasmay.android.geoapp;

        import android.app.Activity;
        import android.content.Intent;
        import android.provider.ContactsContract;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.eliasmay.android.geoapp.Model.BancoDePreguntas;
        import com.eliasmay.android.geoapp.Model.Pregunta;

public class GeoActivity extends AppCompatActivity {

    private final String KEY_POSICION_ACTUAL = "posicion actual";
    private final int REQUEST_SE_MOSTRO_RESPUESTA = 0;
    private Button mBotonCierto;
    private Button mBotonFalso;
    private Button mBotonSiguiente;
    private Button mBotonAnterior;
    private TextView mTextoPregunta;
    private BancoDePreguntas banco;
    private Pregunta mPreguntaActual;
    private Button mBotonMostrarRespuesta;
    private boolean mEstaHaciendoTrampa;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        else{
            if(requestCode == REQUEST_SE_MOSTRO_RESPUESTA){
                if (data != null){
                    return;
                }
                mEstaHaciendoTrampa = TrampaActivity.respuestaMostrada(data);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        crearBancoDePreguntas();

        if (savedInstanceState != null){
            int posicion = savedInstanceState.getInt(KEY_POSICION_ACTUAL);
            mPreguntaActual = banco.get(posicion);
        }

        mPreguntaActual = banco.get(0);
        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta);
        mBotonCierto = (Button) findViewById(R.id.boton_cierto);
        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mBotonAnterior = (Button) findViewById(R.id.boton_anterior);
        mBotonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        mBotonMostrarRespuesta = (Button) findViewById(R.id.texto_boton_mostrar_respuesta);

        actualizarPregunta();


        mBotonCierto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                verificarRespuesta(true);
            }
        });

        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(false);
            }
        });

        mBotonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = banco.previous();
                actualizarPregunta();
            }
        });

        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = banco.next();
                actualizarPregunta();
            }
        });

        mBotonMostrarRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeoActivity.this, TrampaActivity.class);

                boolean isRespuestaEsCorrecta = mPreguntaActual.ismVerdadero();
                intent.putExtra(TrampaActivity.EXTRA_RESPUESTA_ES_CORRECTA, isRespuestaEsCorrecta);
                startActivity(intent);
            }
        });

    }
    private void crearBancoDePreguntas() {
        banco = new BancoDePreguntas();
        banco.add(new Pregunta(R.string.texto_pregunta_1, false));
        banco.add(new Pregunta(R.string.texto_pregunta_2, true));
        banco.add(new Pregunta(R.string.texto_pregunta_3, true));
        banco.add(new Pregunta(R.string.texto_pregunta_4, true));
        banco.add(new Pregunta(R.string.texto_pregunta_5, false));
    }

    private void actualizarPregunta(){
        mTextoPregunta.setText(mPreguntaActual.getmIdResTexto()); //a la pregunta actual obtengo su id como recurso de cadena
    }

    private void verificarRespuesta(boolean botonOprimido){
        boolean respuestaEsVerdadera = mPreguntaActual.ismVerdadero();
        if (botonOprimido == respuestaEsVerdadera){
            Toast.makeText(GeoActivity.this, R.string.texto_correcto, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(GeoActivity.this, R.string.texto_incorrecto, Toast.LENGTH_SHORT).show();
        }

    }


}
