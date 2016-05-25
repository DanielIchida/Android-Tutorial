package codefree.botones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre , apellido , edad , sueldo;
    CheckBox horasExtras;
    RadioGroup numHijos;
    Button registro;
    ToggleButton habilitarFoto;
    ImageView foto;

    private String texto_horas , texto_hijos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.et_nombre);
        apellido = (EditText)findViewById(R.id.et_apellido);
        edad = (EditText)findViewById(R.id.et_edad);
        sueldo = (EditText)findViewById(R.id.et_sueldo);
        horasExtras = (CheckBox)findViewById(R.id.ch_horas_extras);
        numHijos = (RadioGroup)findViewById(R.id.rd_num_hijos);
        registro = (Button)findViewById(R.id.bt_registro);
        habilitarFoto = (ToggleButton)findViewById(R.id.tg_estado_boton);
        foto = (ImageView)findViewById(R.id.img_foto);
        registro.setOnClickListener(this);

        horasExtras.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if(isChecked){
                     texto_horas = "Que si realiza horas extras";
                  }else{
                     texto_horas = "No realiza horas extras";
                  }
            }
        });

        numHijos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                  switch (checkedId){
                      case R.id.rd_uno:
                          texto_hijos = "Un Hijo";
                          break;
                      case R.id.rd_dos:
                          texto_hijos = "Dos Hijos";
                          break;
                      case R.id.rd_mas:
                          texto_hijos = "Tres o Mas Hijos";
                          break;
                  }
            }
        });

        habilitarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(habilitarFoto.isChecked()){
                   foto.setVisibility(View.GONE);
                }else{
                   foto.setVisibility(View.VISIBLE);
                }
            }
        });




    }


    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Nombre: "+nombre.getText().toString()+"\n"+
                                          "Apellido: "+apellido.getText().toString()+"\n"+
                                          "Edad: "+edad.getText().toString()+"\n"+
                                          "Sueldo: "+sueldo.getText().toString()+"\n"+
                                          "Horas Extras: "+texto_horas+"\n"+
                                          "Numero de Hijos: "+texto_hijos+"\n", Toast.LENGTH_LONG).show();
    }
}
