package app.umariana.com.persistenciaconficheros;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OpcionConsultar extends AppCompatActivity {

    private ListView lista;
    private ArrayAdapter<String> adapter;
    private String[] empleados = {"No hay empleados registrados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion_consultar);

        lista = (ListView) findViewById(R.id.lista_empleados);
        empleados = new String[numFilas()];
        listarEmpleados();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, empleados);
        lista.setAdapter(adapter);
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
                        //TODO actualizar adaptador

                        startActivity(new Intent(getApplicationContext(), MenuFicheros.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_eliminar.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
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
                        modificarNombre();
                        Toast.makeText(getApplicationContext(),"Nombres modificados", Toast.LENGTH_SHORT).show();
                        //TODO actualizar adaptador
                        startActivity(new Intent(getApplicationContext(), MenuFicheros.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_nombre.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
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
                        modificarFechaIngreso();
                        Toast.makeText(getApplicationContext(),"Fecha de ingreso modificadas", Toast.LENGTH_SHORT).show();
                        //TODO actualizar adaptador
                        startActivity(new Intent(getApplicationContext(), MenuFicheros.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_fecha_ingreso.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
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
                        modificarSalario();
                        Toast.makeText(getApplicationContext(),"Fecha de ingreso modificadas", Toast.LENGTH_SHORT).show();
                        //TODO actualizar adaptador
                        startActivity(new Intent(getApplicationContext(), MenuFicheros.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_salario.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
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
                        modificarEstado();
                        Toast.makeText(getApplicationContext(),"Fecha de ingreso modificadas", Toast.LENGTH_SHORT).show();
                        //TODO actualizar adaptador
                        startActivity(new Intent(getApplicationContext(), MenuFicheros.class));
                        startActivity(new Intent(getApplicationContext(), OpcionConsultar.class));
                    }
                });
                msj_mod_estado.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                msj_mod_estado.show();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void listarEmpleados () {
        //TODO Crear método de listar empleados
        InputStreamReader flujo=null;
        BufferedReader lector=null;
        try  {
            flujo= new InputStreamReader(openFileInput("empleados.txt"));
            lector= new BufferedReader(flujo);
            String texto = lector.readLine();
            int i = 0;
            while (texto!=null) {
                empleados[i] = texto;
                texto=lector.readLine();
                i++;
            }
        } catch (Exception ex)  {
            Log.e("Error", "Error al leer fichero desde memoria interna");
        } finally {
            try {
                if(flujo!=null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int numFilas(){
        int contador = 0;
        try  {
            InputStreamReader flujo= new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader lector= new BufferedReader(flujo);
            while (lector.readLine()!=null) {
                contador++;
            }
            flujo.close();
        } catch (Exception ex)  {
            Log.e("Error", "Error al leer fichero desde memoria interna");
        }
        return contador;
    }

    public void eliminarEmpleados () {
        //TODO Crear método de eliminar empleados
        try {
            InputStreamReader reader = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader br = new BufferedReader(reader);
            String texto = null;
            OutputStreamWriter pw = new OutputStreamWriter(openFileOutput("empleados.tmp", Context.MODE_PRIVATE));
            while ((texto = br.readLine() ) != null) {
                String[] linea = texto.split(":");
                linea[0] = "";
                linea[1] = "";
                linea[2] = "";
                linea[3] = "";
                linea[4] = "";
                linea[5] = "";
                linea[6] = "";
                pw.write(linea[0]  + //nombre
                        linea[1]  + //apellido
                        linea[2]  + //sexo
                        linea[3] + //fechaNacimiento
                        linea[4] + //fechaIngreso
                        linea[5] + //salario
                        linea[6]  //estado empleado
                        );
                pw.flush();
            }
            pw.close();
            br.close();


            File archivo = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.txt");
            File temp = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.tmp");

            if (!archivo.delete()) {
                Toast.makeText(this, "No se pudo eliminar el archivo", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!temp.renameTo(archivo)) {
                Toast.makeText(this, "No se pudo renombrar el archivo", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Archivo no encontrado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al escribir", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarNombre () {
        //TODO Crear método de modificar el nombre de los empleados
        try {
            InputStreamReader reader = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader br = new BufferedReader(reader);
            String texto = null;
            OutputStreamWriter pw = new OutputStreamWriter(openFileOutput("empleados.tmp", Context.MODE_PRIVATE));
            while ((texto = br.readLine() ) != null) {
                String[] linea = texto.split(":");
                linea[0] = "Nombre modificado";
                pw.write(linea[0] + ":" + //nombre
                        linea[1] + ":" + //apellido
                        linea[2] + ":" + //sexo
                        linea[3] + ":" + //fechaNacimiento
                        linea[4] + ":" + //fechaIngreso
                        linea[5] + ":" + //salario
                        linea[6] + ":" + //estado empleado
                        "\n"); //salto de linea
                pw.flush();
            }
            pw.close();
            br.close();


            File archivo = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.txt");
            File temp = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.tmp");

            if (!archivo.delete()) {
                Toast.makeText(this, "No se pudo eliminar el archivo", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!temp.renameTo(archivo)) {
                Toast.makeText(this, "No se pudo renombrar el archivo", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Archivo no encontrado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al escribir", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarFechaIngreso () {
        //TODO Crear método de modificar la fecha de ingreso de los empleados
        try {
            InputStreamReader reader = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader br = new BufferedReader(reader);
            String texto = null;
            OutputStreamWriter pw = new OutputStreamWriter(openFileOutput("empleados.tmp", Context.MODE_PRIVATE));
            while ((texto = br.readLine() ) != null) {
                String[] linea = texto.split(":");
                linea[4] = "1234524201200l";
                pw.write(linea[0] + ":" + //nombre
                        linea[1] + ":" + //apellido
                        linea[2] + ":" + //sexo
                        linea[3] + ":" + //fechaNacimiento
                        linea[4] + ":" + //fechaIngreso
                        linea[5] + ":" + //salario
                        linea[6] + ":" + //estado empleado
                        "\n"); //salto de linea
                pw.flush();
            }
            pw.close();
            br.close();


            File archivo = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.txt");
            File temp = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.tmp");

            if (!archivo.delete()) {
                Toast.makeText(this, "No se pudo eliminar el archivo", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!temp.renameTo(archivo)) {
                Toast.makeText(this, "No se pudo renombrar el archivo", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Archivo no encontrado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al escribir", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarSalario () {
        //TODO Crear método de modificar el salario de los empleados
        try {
            InputStreamReader reader = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader br = new BufferedReader(reader);
            String texto = null;
            OutputStreamWriter pw = new OutputStreamWriter(openFileOutput("empleados.tmp", Context.MODE_PRIVATE));
            while ((texto = br.readLine() ) != null) {
                String[] linea = texto.split(":");
                linea[5] = "1500000";
                pw.write(linea[0] + ":" + //nombre
                        linea[1] + ":" + //apellido
                        linea[2] + ":" + //sexo
                        linea[3] + ":" + //fechaNacimiento
                        linea[4] + ":" + //fechaIngreso
                        linea[5] + ":" + //salario
                        linea[6] + ":" + //estado empleado
                        "\n"); //salto de linea
                pw.flush();
            }
            pw.close();
            br.close();


            File archivo = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.txt");
            File temp = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.tmp");

            if (!archivo.delete()) {
                Toast.makeText(this, "No se pudo eliminar el archivo", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!temp.renameTo(archivo)) {
                Toast.makeText(this, "No se pudo renombrar el archivo", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Archivo no encontrado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al escribir", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarEstado () {
        //TODO Crear método de modificar el estado de los empleados
        try {
            InputStreamReader reader = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader br = new BufferedReader(reader);
            String texto = null;
            OutputStreamWriter pw = new OutputStreamWriter(openFileOutput("empleados.tmp", Context.MODE_PRIVATE));
            while ((texto = br.readLine() ) != null) {
                String[] linea = texto.split(":");
                linea[6] = "false";
                pw.write(linea[0] + ":" + //nombre
                        linea[1] + ":" + //apellido
                        linea[2] + ":" + //sexo
                        linea[3] + ":" + //fechaNacimiento
                        linea[4] + ":" + //fechaIngreso
                        linea[5] + ":" + //salario
                        linea[6] + ":" + //estado empleado
                        "\n"); //salto de linea
                pw.flush();
            }
            pw.close();
            br.close();


            File archivo = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.txt");
            File temp = new File("/data/data/app.umariana.com.persistenciaconficheros/files/empleados.tmp");

            if (!archivo.delete()) {
                Toast.makeText(this, "No se pudo eliminar el archivo", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!temp.renameTo(archivo)) {
                Toast.makeText(this, "No se pudo renombrar el archivo", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Archivo no encontrado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al escribir", Toast.LENGTH_SHORT).show();
        }
    }
}
