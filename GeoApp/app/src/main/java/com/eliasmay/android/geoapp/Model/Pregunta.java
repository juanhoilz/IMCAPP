package com.eliasmay.android.geoapp.Model;

/**
 * Created by Alumnos on 16/10/2018.
 */

public class Pregunta {
    private int mIdResTexto;
    private boolean mVerdadero;

    public Pregunta (int IdResTexto, boolean verdadera) {
        mIdResTexto = IdResTexto;
        mVerdadero = verdadera;
    }

    public int getmIdResTexto() {
        return mIdResTexto;
    }

    public void setmIdResTexto(int mIdResTexto) {
        this.mIdResTexto = mIdResTexto;
    }

    public boolean ismVerdadero() {
        return mVerdadero;
    }

    public void setmVerdadero(boolean mVerdadero) {
        this.mVerdadero = mVerdadero;
    }

}
