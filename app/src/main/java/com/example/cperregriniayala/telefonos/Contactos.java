package com.example.cperregriniayala.telefonos;

import android.app.Activity;

import java.io.Serializable;
import java.util.ArrayList;


public class Contactos extends Activity /* implements Serializable */
{
    String nombre;
    String telefono;

    public Contactos(String nombre, String telefono)
    {
        this.nombre=nombre;
        this.telefono=telefono;
    }

    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    public String toString()
    {
        return nombre + " " + telefono;
    }

}
