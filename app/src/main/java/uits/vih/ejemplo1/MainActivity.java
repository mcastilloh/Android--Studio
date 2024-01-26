package uits.vih.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import uits.vih.ejemplo1.Controlador.ControlBD;
import uits.vih.ejemplo1.Modelos.Materia;

public class MainActivity extends AppCompatActivity {

    ControlBD controlBD;
    Button btn_materia_menu;
    Button btn_alumno_menu;
    Button btn_nota_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controlBD = new ControlBD(this);

        btn_materia_menu = (Button) findViewById(R.id.btn_materia_menu);
        btn_alumno_menu = (Button) findViewById(R.id.btn_alumno_menu);
        btn_nota_menu = (Button) findViewById(R.id.nota_menu);

        btn_materia_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent materia = new Intent(MainActivity.this, MateriaMenuAct.class);
                startActivity(materia);
            }
        });

    //    datosMaterias();
    //    consultarMateria();
      //  actualizarMateria();
    //    eliminarMateria();
    }

    private void eliminarMateria() {
        Materia materiaEliminar = new Materia("0","Estructura","4");
        String nota="";
        controlBD.abrir();
        nota = controlBD.eliminarMateria(materiaEliminar);
        controlBD.cerrar();
        Toast.makeText(this, nota, Toast.LENGTH_SHORT).show();

    }

    private void actualizarMateria() {
        Materia materiaActualizar = new Materia("10","Estructura","4");
        String nota = "";
        controlBD.abrir();
        nota = controlBD.actualizarMateria(materiaActualizar);
        controlBD.cerrar();
        Toast.makeText(this, nota, Toast.LENGTH_SHORT).show();
    }

    private void consultarMateria() {
        Materia materiaBuscar = new Materia("1","Estructura","4");
        Materia matRetornada = new Materia();
        controlBD.abrir();
        matRetornada = controlBD.consultarMateria(materiaBuscar);
        controlBD.cerrar();
        Toast.makeText(this, matRetornada.getNombre(), Toast.LENGTH_SHORT).show();

    }

    private void datosMaterias() {

        Materia m1 = new Materia("1", "Estructuras", "4");
        String nota = "";
        controlBD.abrir();
        nota = controlBD.insertarMateria(m1);
        controlBD.cerrar();
        Toast.makeText(this, nota, Toast.LENGTH_SHORT).show();

    }
}