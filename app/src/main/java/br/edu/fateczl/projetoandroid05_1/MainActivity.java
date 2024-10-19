package br.edu.fateczl.projetoandroid05_1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgQuantDados;
    private RadioButton rbQuantDados1;
    private RadioButton rbQuantDados2;
    private RadioButton rbQuantDados3;
    private Spinner spTipoDado;
    private TextView tvResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgQuantDados = findViewById(R.id.rgQuantDados);
        rbQuantDados1 = findViewById(R.id.rbQuantDados1);
        rbQuantDados2 = findViewById(R.id.rbQuantDados2);
        rbQuantDados3 = findViewById(R.id.rbQuantDados3);
        spTipoDado = findViewById(R.id.spTipoDado);
        tvResultado= findViewById(R.id.tvResultado);
        Button btnRodarDados = findViewById(R.id.btnRodarDados);

        rbQuantDados1.setChecked(true);
        preencherSpinner();
        btnRodarDados.setOnClickListener(e ->exibirResultado() );
    }


    private void preencherSpinner() {
        List<String> lista = new ArrayList<>();
        lista.add("D4");
        lista.add("D6");
        lista.add("D8");
        lista.add("D10");
        lista.add("D12");
        lista.add("D20");
        lista.add("D100");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoDado.setAdapter(adapter);
    }

    private void exibirResultado(){
        StringBuilder resultado = new StringBuilder();
        if (rbQuantDados1.isChecked()){
            resultado.append("Dado 1: ").append(rodarDado());
        } else if (rbQuantDados2.isChecked()) {
            resultado.append("Dado 1: ").append(rodarDado());
            resultado.append("\nDado 2: ").append(rodarDado());
        }else {
            resultado.append("Dado 1: ").append(rodarDado());
            resultado.append("\nDado 2: ").append(rodarDado());
            resultado.append("\nDado 3: ").append(rodarDado());
        }

         tvResultado.setText(resultado);

    }

    private int rodarDado(){
        String tipoDado = (String) spTipoDado.getSelectedItem();
        return (int) (Math.random() * (Integer.parseInt(tipoDado.replaceFirst("D","")))+1);
    }


}