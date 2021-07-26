package com.example.agendacrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendacrud.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtEmail);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.InsertaContacto(txtNombre.getText().toString(),txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString());
                if (id > 0 ){
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                    limpiar();
                    Intent intent = new Intent(NuevoActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
    }
}