package com.eliasmay.android.geoapp.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumnos on 17/10/2018.
 */

public class BancoDePreguntas {
    private final List<Pregunta> banco;
    private int posocionActual;
    private int numElementos;

    public BancoDePreguntas(){
        banco = new ArrayList<>();
        posocionActual = -1;
    }

    public void add(Pregunta pregunta){
        banco.add(pregunta);
        if (size() == 1){
            posocionActual = 0;
        }
    }

    public int getPosocionActual(int posicion){
        posocionActual = posicion;
        return posocionActual;
    }

    public int size(){
        return banco.size();
    }

    public Pregunta get(int posocion){
        return banco.get(posocion);
    }

    public boolean isEmpty(){
        return banco.isEmpty();
    }

    public Pregunta next(){
        if(isEmpty()){
            return null;
        }
        else{
            if (posocionActual == size() -1){
                posocionActual = 0;
            }
            else{
                posocionActual++;
            }
            return banco.get(posocionActual);
        }
    }

    public Pregunta previous(){
        if (posocionActual == 0){
            posocionActual = size() -1;
        }
        else {
            posocionActual--;
        }
        return banco.get(posocionActual);
    }
}
