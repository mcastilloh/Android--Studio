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

public class ConsultarMaterioa extends AppCompatActivity {

    EditText txtIdMateria;
    EditText txtNombreMateria;
    EditText txtUVMateria;
    TextView lbl_idMateria;
    TextView lbl_nombreMateria;
    TextView lbl_uvMateria;
    Button btn_consultarMateria;
    String idMateria ="";
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
        btn_consultarMateria = findViewById(R.id.btn_accionMateria);
        lbl_idMateria = findViewById(R.id.lblIdMateria);
        lbl_nombreMateria = findViewById(R.id.lblNombreMateria);
        lbl_uvMateria = findViewById(R.id.lblUVMateria);
        materia = new Materia();
        btn_consultarMateria.setText("Consultar Materia");
        lbl_idMateria.setText("Nombre a consultar");
        txtIdMateria.setHint("Ingrese el nombre");

        lbl_nombreMateria.setText("ID");
        txtNombreMateria.setHint("Ingrese el nombre de la materia a consultar");

        txtNombreMateria.setEnabled(false);
        txtUVMateria.setEnabled(false);

        btn_consultarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idMateria = txtIdMateria.getText().toString();
                materia.setNombre(idMateria);

                Materia matRetornada = new Materia();
                controlBD.abrir();
                matRetornada = controlBD.consultarMateria(materia);
                controlBD.cerrar();
                materia.setId(matRetornada.getId());
                materia.setUval(matRetornada.getUval());
                Toast.makeText(ConsultarMaterioa.this, matRetornada.getNombre(), Toast.LENGTH_SHORT).show();

                txtNombreMateria.setText(matRetornada.getId());
                txtUVMateria.setText(matRetornada.getUval());
            }
        });
    }
}