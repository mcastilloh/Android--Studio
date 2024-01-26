package uits.vih.ejemplo1.Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import kotlin.contracts.Returns;
import uits.vih.ejemplo1.Modelos.Materia;

public class ControlBD {

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    String[] camposMateria =new String[]{"id", "nombre", "uval"};

    public ControlBD(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "desarrollo.s3db";
        private static final int version = 1;
        DatabaseHelper(Context context){
            super(context,BASE_DATOS, null, version);
        }

        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ctl_Materia("+
                        "id varchar(10) PRIMARY KEY," +
                        "nombre varchar(25)," +
                        "uval INTEGER);");
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS alumno("+
                        "id varchar(10) PRIMARY KEY," +
                        "nombre varchar(25)," +
                        "apellido varchar(25),"+
                        "matganadas INTEGER);");
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nota("+
                        "id varchar(10) PRIMARY KEY," +
                        "idAlumno varchar(10)," +
                        "ciclo varchar(2)," +
                        "nota INTEGER);");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }

    public void abrir()throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar(){
        DBHelper.close();
    }

    public String insertarMateria(Materia materia){
        String nota = "Se ha ingresado la materia exitosamente";
        ContentValues cv = new ContentValues();
        if (!verificarIntegridad(materia, 1)){
            cv.put("id", materia.getId());
            cv.put("nombre", materia.getNombre());
            cv.put("uval", materia.getUval());
            db.insert("ctl_Materia", null, cv);
        }else {
            nota = "Duplicidad de datos, verificar inserción";
        }
        return nota;
    }

    public Materia consultarMateria(Materia materia){
        String[]nombreMat = {materia.getNombre()};
        Cursor cursor = db.query("ctl_Materia", camposMateria, "nombre =?", nombreMat, null, null, null);
        if (cursor.moveToFirst()){
            Materia materia1 = new Materia();
            materia1.setId(cursor.getString(0));
            materia1.setNombre(cursor.getString(1));
            materia1.setUval(cursor.getString(2));
            return materia1;
        }else
            return null;
    }

    public String actualizarMateria(Materia materia){
        String nota = "Registro Actualizado Correctamente";
        if (verificarIntegridad(materia, 2)){
            String[] id ={materia.getId()};
            ContentValues contentValues =new ContentValues();
            contentValues.put("id", materia.getId());
            contentValues.put("nombre", materia.getNombre());
            contentValues.put("uval", materia.getUval());
            db.update("ctl_Materia", contentValues, "id=?", id);
        }else
            nota="No existe el registro "+materia.getId();
        return nota;
    }

    public String eliminarMateria(Materia materia){
        String nota = "Registro: "+ materia.getNombre() + " eliminado correctamente.";
        if (verificarIntegridad(materia, 2)){
            db.delete("ctl_Materia", "id= "+ materia.getId(), null);
        }else
            nota = "Registro no encontrado";
        return nota;
    }



    public boolean verificarIntegridad(Object objeto, int relacion) throws SQLException{
        switch (relacion){
            case 1: {//Verificar que una materia exista o que el código se encuentre repetido
                Materia m1 = (Materia) objeto;
                String[]datosMat = {m1.getNombre(), m1.getId()};
                abrir();
                Cursor cursor =db.query("ctl_Materia", null, "nombre =? or id=?", datosMat, null, null, null, null);
                if (cursor.moveToFirst()){
                    //Se encontró la materia
                    return true;
                    }
                }
            case 2:{ //Verificar que el código de la materia se encuentra
                Materia m2 = (Materia) objeto;
                String[]datosMat = {m2.getId()};
                abrir();
                Cursor cursor= db.query("ctl_Materia", null, "id=?", datosMat, null, null, null);
                if (cursor.moveToFirst()){
                    //Se encontró el id
                    return true;
                }
            }
            default:
                return false;
        }
    }

}
