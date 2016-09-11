package app.umariana.com.persistenciaconclavevalor;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionAgregar extends AppCompatActivity implements View.OnClickListener {

    private static int PEQUEÑA_INFORMACION = 100;
    private static int MEDIANA_INFORMACION = 1000;
    private static int GRANDE_INFORMACION = 10000;

    private Button btn_pequeña_inf, btn_mediana_inf, btn_grande_inf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion_agregar);

        btn_pequeña_inf = (Button) findViewById(R.id.btn_pequeña_inf);
        btn_pequeña_inf.setOnClickListener(this);

        btn_mediana_inf = (Button) findViewById(R.id.btn_mediana_inf);
        btn_mediana_inf.setOnClickListener(this);

        btn_grande_inf = (Button) findViewById(R.id.btn_grande_inf);
        btn_grande_inf.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pequeña_inf:
                AlertDialog.Builder confirmarP = new AlertDialog.Builder(this);
                confirmarP.setMessage("¿Desea agregar pequeña cantidad de información?");
                confirmarP.setTitle("Agregar empleados");
                confirmarP.setIcon(android.R.drawable.ic_dialog_alert);
                confirmarP.setCancelable(false);
                confirmarP.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        agregarEmpleados(PEQUEÑA_INFORMACION);
                    }
                });
                confirmarP.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                confirmarP.show();
                break;
            case  R.id.btn_mediana_inf:
                AlertDialog.Builder confirmarM = new AlertDialog.Builder(this);
                confirmarM.setMessage("¿Desea agregar mediana cantidad de información?");
                confirmarM.setTitle("Agregar empleados");
                confirmarM.setIcon(android.R.drawable.ic_dialog_alert);
                confirmarM.setCancelable(false);
                confirmarM.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        agregarEmpleados(MEDIANA_INFORMACION);
                    }
                });
                confirmarM.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                confirmarM.show();
                break;
            case R.id.btn_grande_inf:
                AlertDialog.Builder confirmarG = new AlertDialog.Builder(this);
                confirmarG.setMessage("¿Desea agregar gran cantidad de información?");
                confirmarG.setTitle("Agregar empleados");
                confirmarG.setIcon(android.R.drawable.ic_dialog_alert);
                confirmarG.setCancelable(false);
                confirmarG.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        agregarEmpleados(GRANDE_INFORMACION);
                    }
                });
                confirmarG.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                confirmarG.show();
                break;
            default:
                break;
        }
    }

    public void agregarEmpleados (int cantidad){
        //TODO Crear método que agrege empleados
    }
}
