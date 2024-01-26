package uits.vih.ejemplo1.Materia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uits.vih.ejemplo1.Controlador.ControlBD;
import uits.vih.ejemplo1.Modelos.Materia;
import uits.vih.ejemplo1.R;

public class IngresarMateria extends AppCompatActivity {

    EditText txtIdMateria;
    EditText txtNombreMateria;
    EditText txtUVMateria;
    Button btn_ingresarMateria;
    String idMateria ="";
    String nombreMateria="";
    String uvMateria="";
    String nota="";
    Materia materia;
    ControlBD controlBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_materia);
        controlBD = new ControlBD(this);

        txtIdMateria = findViewById(R.id.txtIdMateria);
        txtNombreMateria = findViewById(R.id.txtNombreMateria);
        txtUVMateria = findViewById(R.id.txtUVMateria);
        btn_ingresarMateria = findViewById(R.id.btn_accionMateria);
        materia = new Materia();
        btn_ingresarMateria.setText("Ingresar Materia");

        btn_ingresarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idMateria = txtIdMateria.getText().toString();
                nombreMateria = txtNombreMateria.getText().toString();
                uvMateria = txtUVMateria.getText().toString();

                materia.setId(idMateria);
                materia.setNombre(nombreMateria);
                materia.setUval(uvMateria);

                controlBD.abrir();
                nota = controlBD.insertarMateria(materia);
                controlBD.cerrar();
                Toast.makeText(IngresarMateria.this, nota, Toast.LENGTH_SHORT).show();
            }
        });


    }
}