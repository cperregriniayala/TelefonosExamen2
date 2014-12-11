package com.example.cperregriniayala.telefonos;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MyActivity extends Activity {

    Button bA;
    Button bE;
    Button bL;
    Button Borrar;

    EditText eNombre1;
    EditText eTelefono;
    EditText eNombre2;
    Contactos objContactos;

    public ArrayList<Contactos> array = new ArrayList<Contactos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        bA = (Button) findViewById(R.id.bAñadir);
        bE = (Button) findViewById(R.id.bEditar);
        bL = (Button) findViewById(R.id.bL);
        eNombre1 = (EditText) findViewById(R.id.editText);
        eTelefono = (EditText) findViewById(R.id.editText2);
        eNombre2 = (EditText) findViewById(R.id.editText3);

         //Añadiriamos contacto
        bA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                objContactos = new Contactos(eNombre1.getText().toString(), eTelefono.getText().toString());
                array.add(objContactos);

                showToast("AÑADO ok");


                });


                bL.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View view) {
                             Intent intento = new Intent(MyActivity.this, MyActivity3.class);
                             intento.putExtra("id1", array);
                             startActivityForResult(intento, 1);
                             eNombre1.setText("");
                             eTelefono.setText("");
                                          }
                                      }
        });
            }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.my, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_settings) {
                    return true;
                }
                return super.onOptionsItemSelected(item);
            }

            public void showToast(String mensaje) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, mensaje, duration);
                toast.show();
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (resultCode == RESULT_OK) {
                    showToast("******Aqui********");
                    Contactos pavo = (Contactos) data.getSerializableExtra("id3");
                    Contactos cont = (Contactos) data.getSerializableExtra("id4");

                    for (int i = 0; i < array.size(); i++) {

                        if (array.get(i).getNombre().equalsIgnoreCase(cont.getNombre().toString())) {
                            array.get(i).setNombre(pavo.getNombre());
                            array.get(i).setTelefono(pavo.getTelefono());
                        }
                    }

                    showToast("Contacto modificado");
                }
            }
        }
    }