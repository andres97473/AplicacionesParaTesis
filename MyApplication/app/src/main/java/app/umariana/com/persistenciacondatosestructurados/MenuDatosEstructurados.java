package app.umariana.com.persistenciacondatosestructurados;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuDatosEstructurados extends AppCompatActivity implements View.OnClickListener{

    private DbManager manager;
    private Button op_agregar, op_consultar, op_modificar, op_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_datos_estructurados);

        manager = new DbManager(this);

        op_agregar = (Button) findViewById(R.id.btn_op_agregar);
        op_agregar.setOnClickListener(this);

        op_consultar = (Button) findViewById(R.id.btn_op_consultar);
        op_consultar.setOnClickListener(this);

        op_modificar = (Button) findViewById(R.id.btn_op_modificar);
        op_modificar.setOnClickListener(this);

        op_eliminar = (Button) findViewById(R.id.btn_op_eliminar);
        op_eliminar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_op_agregar:
                Intent intentA = new Intent(this, OpcionAgregar.class);
                startActivity(intentA);
                break;
            case  R.id.btn_op_consultar:
                Intent intentC = new Intent(this, OpcionConsultar.class);
                startActivity(intentC);
                break;
            case R.id.btn_op_modificar:
                Intent intentM = new Intent(this, OpcionModificar.class);
                startActivity(intentM);
                break;
            case R.id.btn_op_eliminar:
                AlertDialog.Builder msj_eliminar_todo = new AlertDialog.Builder(this);
                msj_eliminar_todo.setMessage("¿Desea eliminar todos los empleados?");
                msj_eliminar_todo.setTitle("Eliminar empleados");
                msj_eliminar_todo.setIcon(android.R.drawable.ic_dialog_alert);
                msj_eliminar_todo.setCancelable(false);
                msj_eliminar_todo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        manager.eliminarEmpleados();
                        Toast.makeText(getApplicationContext(), "Todos los empleados se han eliminado correctamente", Toast.LENGTH_SHORT).show();
                    }
                });
                msj_eliminar_todo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                msj_eliminar_todo.show();
                break;
            default:
                break;
        }
    }
}
