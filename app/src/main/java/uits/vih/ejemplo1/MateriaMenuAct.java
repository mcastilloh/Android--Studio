package uits.vih.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uits.vih.ejemplo1.Materia.ConsultarMaterioa;
import uits.vih.ejemplo1.Materia.IngresarMateria;

public class MateriaMenuAct extends AppCompatActivity {

    Button btn_agregarMat;
    Button btn_consultarMat;
    Button btn_modificarMat;
    Button btn_eliminarMat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_menu);

        btn_agregarMat = findViewById(R.id.btn_insertar_materia);
        btn_consultarMat = findViewById(R.id.btn_consultar_materia);
        btn_modificarMat = findViewById(R.id.btn_modificar_materia);
        btn_eliminarMat = findViewById(R.id.btn_eliminar_materia);

        btn_agregarMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agregarMat = new Intent(MateriaMenuAct.this, IngresarMateria.class);
                startActivity(agregarMat);
            }
        });

        btn_consultarMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consultarMateria = new Intent(MateriaMenuAct.this, ConsultarMaterioa.class);
                startActivity(consultarMateria);
            }
        });
    }
}