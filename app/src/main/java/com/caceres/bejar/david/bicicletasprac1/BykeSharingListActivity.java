package com.caceres.bejar.david.bicicletasprac1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BykeSharingListActivity extends  AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener, ActivityCompat.OnRequestPermissionsResultCallback {

    //declara un aconstante con código de la activity para añadir bicicleta.
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    //Declara el fragmento para ser usando posteriormente
    ItemFragment fragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byke_sharing_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Inicia el fragmento para ser usado con la interfaz
        fragmento = (ItemFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        //Añade funcionalidad al botón para abrir AddBikeSharingActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad para añadir la bicicleta y espera respuesta.
                Intent intent = new Intent(BykeSharingListActivity.this, AddBikeSharingActivity.class);
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });
    }


    // Este método se llama cuando la tercera activity termina y responde.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // obtiene la descripción de la nueva bicicleta
                String returnString = data.getStringExtra(Intent.EXTRA_TEXT);
                //Evalúa que no esté vacía y procede a añadir a la lista usando la iterfaz del fragment, caso contrario no hace nada
                if(!returnString.equals("")){
                    //Envía al fragment la información para añadir una nueva bicicleta
                    fragmento.add_bike_fragment(returnString);
                }
            }
        }
    }

    @Override
    public void click(Bike item) {
        //Interactúa con clicks en los elementos
        Log.d("Fragmento","obtiene item: "+ item.numero);
    }


    //Interfaz de comunicación entre las Activities y Fragments que la implementen,
    //Esto permite la intercomunicación entre todas las clases.
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void add_bike_fragment(String descrip);
    }

}
