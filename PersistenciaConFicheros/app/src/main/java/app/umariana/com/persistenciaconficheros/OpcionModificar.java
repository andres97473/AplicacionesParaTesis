package app.umariana.com.persistenciaconficheros;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class OpcionModificar extends AppCompatActivity implements View.OnClickListener{

    private Button btn_modNombre, btn_modFechaIngreso, btn_modSalario, btn_modEstado, btn_modTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion_modificar);

        btn_modNombre = (Button) findViewById(R.id.btn_mod_nombre);
        btn_modNombre.setOnClickListener(this);

        btn_modFechaIngreso = (Button) findViewById(R.id.btn_mod_fecha_ingreso);
        btn_modFechaIngreso.setOnClickListener(this);

        btn_modSalario = (Button) findViewById(R.id.btn_mod_salario);
        btn_modSalario.setOnClickListener(this);

        btn_modEstado = (Button) findViewById(R.id.btn_mod_estado);
        btn_modEstado.setOnClickListener(this);

        btn_modTodo = (Button) findViewById(R.id.btn_mod_todo);
        btn_modTodo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_mod_nombre:
                AlertDialog.Builder msj_modNombre = new AlertDialog.Builder(this);
                msj_modNombre.setMessage("¿Desea modificar el nombre de todos los empleados?");
                msj_modNombre.setTitle("Modificar empleados");
                msj_modNombre.setIcon(android.R.drawable.ic_dialog_alert);
                msj_modNombre.setCancelable(false);
                msj_modNombre.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modNombre();
                        Toast.makeText(getApplicationContext(), "Nombre de los empleados modificado correctamente", Toast.LENGTH_SHORT).show();
                    }
                });
                msj_modNombre.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                msj_modNombre.show();
                break;
            case R.id.btn_mod_fecha_ingreso:
                AlertDialog.Builder msj_modFechaIngreso = new AlertDialog.Builder(this);
                msj_modFechaIngreso.setMessage("¿Desea modificar fecha de ingreso de todos los empleados?");
                msj_modFechaIngreso.setTitle("Modificar empleados");
                msj_modFechaIngreso.setIcon(android.R.drawable.ic_dialog_alert);
                msj_modFechaIngreso.setCancelable(false);
                msj_modFechaIngreso.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modFechaIngreso();
                        Toast.makeText(getApplicationContext(), "Fecha de ingreso de los empleados modificada correctamente", Toast.LENGTH_SHORT).show();
                    }
                });
                msj_modFechaIngreso.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                msj_modFechaIngreso.show();
                break;
            case R.id.btn_mod_salario:
                AlertDialog.Builder msj_modSalario = new AlertDialog.Builder(this);
                msj_modSalario.setMessage("¿Desea modificar el salario de todos los empleados?");
                msj_modSalario.setTitle("Modificar empleados");
                msj_modSalario.setIcon(android.R.drawable.ic_dialog_alert);
                msj_modSalario.setCancelable(false);
                msj_modSalario.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modSalario();
                        Toast.makeText(getApplicationContext(), "Salario de los empleados modificado correctamente", Toast.LENGTH_SHORT).show();
                    }
                });
                msj_modSalario.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                msj_modSalario.show();
                break;
            case R.id.btn_mod_estado:
                AlertDialog.Builder msj_modEstado = new AlertDialog.Builder(this);
                msj_modEstado.setMessage("¿Desea modificar el estado de todos los empleados?");
                msj_modEstado.setTitle("Modificar empleados");
                msj_modEstado.setIcon(android.R.drawable.ic_dialog_alert);
                msj_modEstado.setCancelable(false);
                msj_modEstado.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modEstado();
                        Toast.makeText(getApplicationContext(), "Estado de los empleados modificado correctamente", Toast.LENGTH_SHORT).show();
                    }
                });
                msj_modEstado.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                msj_modEstado.show();
                break;
            case R.id.btn_mod_todo:
                AlertDialog.Builder msj_modTodo = new AlertDialog.Builder(this);
                msj_modTodo.setMessage("¿Desea modificar todos los campos de los empleados?");
                msj_modTodo.setTitle("Modificar empleados");
                msj_modTodo.setIcon(android.R.drawable.ic_dialog_alert);
                msj_modTodo.setCancelable(false);
                msj_modTodo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        modTodo();
                        Toast.makeText(getApplicationContext(), "Empleados modificados correctamente", Toast.LENGTH_SHORT).show();
                    }
                });
                msj_modTodo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                msj_modTodo.show();
                break;
            default:
                break;
        }
    }

    public void modNombre () {
        //TODO Crear método que modifique el nombre de todos los empleados
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

    public void modFechaIngreso () {
        //TODO Crear método que modifique la fecha de ingreso de todos los empleados
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

    public void modSalario () {
        //TODO Crear método que modifique el salario de todos los empleados
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

    public void modEstado () {
        //TODO Crear método que modifique el estado de todos los empleados
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

    public void modTodo ()
    {
        //TODO Crear método que modifique todos los campos de todos los empleados
        try {
            InputStreamReader reader = new InputStreamReader(openFileInput("empleados.txt"));
            BufferedReader br = new BufferedReader(reader);
            String texto = null;
            OutputStreamWriter pw = new OutputStreamWriter(openFileOutput("empleados.tmp", Context.MODE_PRIVATE));
            while ((texto = br.readLine() ) != null) {
                String[] linea = texto.split(":");
                linea[0] = "Nombre Todo";
                linea[1] = "Apellido Todo";
                linea[2] = "F";
                linea[3] = "5432124199000l";
                linea[4] = "5432124199000l";
                linea[5] = "2000000";
                linea[6] = "true";
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
