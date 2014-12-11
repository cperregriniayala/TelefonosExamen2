package com.example.cperregriniayala.telefonos;

import android.app.ListActivity;
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
import java.util.Arrays;

public class MyActivity3 extends ListActivity{
    ArrayList <Contactos> arra;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity3);

        arra = (ArrayList<Contactos>)getIntent().getSerializableExtra("id1");
        setListAdapter(new ArrayAdapter<Contactos>(this, android.R.layout.simple_list_item_1, arra));
    }

    public void onListItemClick(ListView parent,View v,int posicion,long id)
    {
        Intent intento = new Intent(MyActivity3.this, MyActivity2.class);
        intento.putExtra("id2", arra.get(posicion));
        startActivityForResult(intento, 1);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_my_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showToast(String mensaje)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, mensaje, duration);
        toast.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            Contactos pavo = (Contactos) data.getSerializableExtra("id3");
            Contactos contacto = (Contactos) data.getSerializableExtra("id4");
            Intent intento = new Intent(MyActivity3.this, MyActivity.class);
            intento.putExtra("id4", contacto);
            intento.putExtra("id3", pavo);
            setResult(RESULT_OK, intento);
            finish();
        }
    }
}
