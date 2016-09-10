package app.umariana.com.persistenciacondatosestructurados;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class OpcionConsultar extends AppCompatActivity {

    private ListView lista;
    private DbManager manager;
    private Cursor cursor;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion_consultar);

        manager = new DbManager(this);
        cursor = manager.listarEmpleados();

        lista = (ListView) findViewById(R.id.lista_empleados);

        listarEmpleados();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){
            case R.id.eliminar_unidad:
                AlertDialog.Builder msj_eliminar = new AlertDialog.Builder(this);
                msj_eliminar.setMessage("¿Desea eliminar los empleados?");
                msj_eliminar.setTitle("Eliminar empleados");
                msj_eliminar.setIcon(android.R.drawable.ic_dialog_alert);
                msj_eliminar.setCancelable(false);
                msj_eliminar.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        eliminarEmpleados();
                        Toast.makeText(getApplicationContext(),"Empleados eliminados", Toast.LENGTH_SHORT).show();
                        adapter.changeCursor(cursor);
                        startActivity(new Intent(getApplicationContext(),MenuDatosEstructurados.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_eliminar.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                msj_eliminar.show();
                return true;
            case R.id.mod_nombre_unidad:
                AlertDialog.Builder msj_mod_nombre = new AlertDialog.Builder(this);
                msj_mod_nombre.setMessage("¿Desea modificar el nombre de los empleados?");
                msj_mod_nombre.setTitle("Modificar empleados");
                msj_mod_nombre.setIcon(android.R.drawable.ic_dialog_alert);
                msj_mod_nombre.setCancelable(false);
                msj_mod_nombre.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cursor.moveToFirst();
                        modificarNombre();
                        Toast.makeText(getApplicationContext(),"Nombres modificados", Toast.LENGTH_SHORT).show();
                        adapter.changeCursor(cursor);
                        startActivity(new Intent(getApplicationContext(),MenuDatosEstructurados.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_nombre.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                msj_mod_nombre.show();
                return true;
            case R.id.mod_fecha_ingreso_unidad:
                AlertDialog.Builder msj_mod_fecha_ingreso = new AlertDialog.Builder(this);
                msj_mod_fecha_ingreso.setMessage("¿Desea modificar la fecha de ingreso de los empleados?");
                msj_mod_fecha_ingreso.setTitle("Modificar empleados");
                msj_mod_fecha_ingreso.setIcon(android.R.drawable.ic_dialog_alert);
                msj_mod_fecha_ingreso.setCancelable(false);
                msj_mod_fecha_ingreso.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cursor.moveToFirst();
                        modificarFechaIngreso();
                        Toast.makeText(getApplicationContext(),"Fecha de ingreso modificadas", Toast.LENGTH_SHORT).show();
                        adapter.changeCursor(cursor);
                        startActivity(new Intent(getApplicationContext(),MenuDatosEstructurados.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_fecha_ingreso.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                msj_mod_fecha_ingreso.show();
                return true;
            case R.id.mod_salario_unidad:
                AlertDialog.Builder msj_mod_salario = new AlertDialog.Builder(this);
                msj_mod_salario.setMessage("¿Desea modificar el salario de los empleados?");
                msj_mod_salario.setTitle("Modificar empleados");
                msj_mod_salario.setIcon(android.R.drawable.ic_dialog_alert);
                msj_mod_salario.setCancelable(false);
                msj_mod_salario.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cursor.moveToFirst();
                        modificarSalario();
                        Toast.makeText(getApplicationContext(),"Fecha de ingreso modificadas", Toast.LENGTH_SHORT).show();
                        adapter.changeCursor(cursor);
                        startActivity(new Intent(getApplicationContext(),MenuDatosEstructurados.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_salario.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                msj_mod_salario.show();
                return true;
            case R.id.mod_estado_unidad:
                AlertDialog.Builder msj_mod_estado = new AlertDialog.Builder(this);
                msj_mod_estado.setMessage("¿Desea modificar el estado de los empleados?");
                msj_mod_estado.setTitle("Modificar empleados");
                msj_mod_estado.setIcon(android.R.drawable.ic_dialog_alert);
                msj_mod_estado.setCancelable(false);
                msj_mod_estado.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cursor.moveToFirst();
                        modificarEstado();
                        Toast.makeText(getApplicationContext(),"Fecha de ingreso modificadas", Toast.LENGTH_SHORT).show();
                        adapter.changeCursor(cursor);
                        startActivity(new Intent(getApplicationContext(),MenuDatosEstructurados.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_estado.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                msj_mod_estado.show();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void listarEmpleados () {
        String[] from = new  String[] {
                manager.ID_EMPLEADO,
                manager.NOMBRE_EMPLEADO,
                manager.APELLIDO_EMPLEADO,
                manager.SEXO_EMPLEADO,
                manager.FECHA_NACIMIENTO_EMPLEADO,
                manager.FECHA_INGRESO_EMPLEADO,
                manager.SALARIO_EMPLEADO,
                manager.ESTADO_EMPLEADO };

        int[] to = new int[]{
                R.id.empleado_id,
                R.id.empleado_nombre,
                R.id.empleado_apellido,
                R.id.empleado_sexo,
                R.id.empleado_fecha_nacimiento,
                R.id.empleado_fecha_ingreso,
                R.id.empleado_salario,
                R.id.empleado_estado };

        cursor = manager.listarEmpleados();
        adapter = new SimpleCursorAdapter(this, R.layout.formato_fila, cursor, from, to, 0);
        lista.setAdapter(adapter);
    }

    public void eliminarEmpleados() {
        cursor = manager.listarEmpleados();
        cursor.moveToFirst();
        int id = Integer.parseInt(cursor.getString(0));
        manager.eliminarEmpleado(id);
        if (cursor.moveToNext()){
            eliminarEmpleados();
        }
    }

    public void modificarNombre(){
        ContentValues cv = new ContentValues();
        cv.put(manager.NOMBRE_EMPLEADO, "NombreModificado");
        int id = Integer.parseInt(cursor.getString(0));
        manager.actualizarEmpleado(cv, id);
        while (cursor.moveToNext()){
            modificarNombre();
        }
    }

    public void modificarFechaIngreso(){
        ContentValues cv = new ContentValues();
        cv.put(manager.FECHA_INGRESO_EMPLEADO, 1456324199000l);
        int id = Integer.parseInt(cursor.getString(0));
        manager.actualizarEmpleado(cv, id);
        while (cursor.moveToNext()){
            modificarFechaIngreso();
        }
    }

    public void modificarSalario(){
        ContentValues cv = new ContentValues();
        cv.put(manager.SALARIO_EMPLEADO, 2000000);
        int id = Integer.parseInt(cursor.getString(0));
        manager.actualizarEmpleado(cv, id);
        while (cursor.moveToNext()){
            modificarSalario();
        }
    }

    public void modificarEstado(){
        ContentValues cv = new ContentValues();
        cv.put(manager.ESTADO_EMPLEADO, false);
        int id = Integer.parseInt(cursor.getString(0));
        manager.actualizarEmpleado(cv, id);
        while (cursor.moveToNext()){
            modificarEstado();
        }
    }

}
