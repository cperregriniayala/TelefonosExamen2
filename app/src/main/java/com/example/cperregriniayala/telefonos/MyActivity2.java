package com.example.cperregriniayala.telefonos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyActivity2 extends Activity {

    Button bG;
    EditText nom;
    EditText tel;
    Contactos objContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        bG = (Button) findViewById(R.id.bG);
        nom = (EditText) findViewById(R.id.editText4);
        tel = (EditText) findViewById(R.id.editText5);

        final Contactos cont = (Contactos) getIntent().getSerializableExtra("id2");

        nom.setText(cont.getNombre());
        tel.setText(cont.getTelefono());

        bG.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intento = new Intent(MyActivity2.this, MyActivity.class);

                Contactos pavo = new Contactos(nom.getText().toString(),tel.getText().toString());
                intento.putExtra("id3", pavo);
                intento.putExtra("id4",cont);
                setResult(RESULT_OK, intento);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
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
}
