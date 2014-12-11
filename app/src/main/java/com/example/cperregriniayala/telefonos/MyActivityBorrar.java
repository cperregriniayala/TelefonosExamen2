package com.example.cperregriniayala.telefonos;

import android.app.Activity;
import android.app.ListActivity;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import java.util.ArrayList;

/**
 * Created by cperregriniayala on 11/12/14.
 */
public class MyActivityBorrar extends ListActivity {


    lista.setOnItemLongClickListener (new ArrayList.AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(ArrayList<Contactos>){
            //Borramos el elemento de la lista
            fileList().remove(position);
            //Metodo para actualizar la lista
            actualizarLista();
            return false;
        }
    });

}
