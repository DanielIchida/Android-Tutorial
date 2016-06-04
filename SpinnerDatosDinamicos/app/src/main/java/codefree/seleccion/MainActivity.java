package codefree.seleccion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //VARIABLES DE LOS COMPONENTES
    Spinner sp_estado_civil;
    List<String> equipos;
    Button add;
    EditText equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZACION DE COMPONENTES
        add = (Button)findViewById(R.id.bt_add_equipos);
        equipo = (EditText)findViewById(R.id.et_equipos);
        sp_estado_civil = (Spinner)findViewById(R.id.sp_equipos);


        //INICIALIZACION DEL ARREGLO
        equipos = new ArrayList<>();

        //EL SPINNER CON NUESTRO ADAPTADOR
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,equipos);
        sp_estado_civil.setAdapter(adapter);

        //EVENTO DEL BOTON
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!equipo.getText().toString().equals("")){
                    equipos.add(equipo.getText().toString());
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "Debes escribir un dato", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //EVENTO DEL SPINNER
        sp_estado_civil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selecciono: "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
