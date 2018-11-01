package com.caceres.bejar.david.bicicletasprac1;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBikeSharingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike_sharing);
        Button btn_add = (Button) findViewById(R.id.button_añadir);
        final TextInputEditText texto = (TextInputEditText) findViewById(R.id.textInputEditText);

        //Se llama al dar click en el botón añadir bicicleta.
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringToPassBack = texto.getText().toString();

                // put the String to pass back into an Intent and close this activity
                Intent intent = new Intent();
                intent.putExtra(Intent.EXTRA_TEXT, stringToPassBack);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
