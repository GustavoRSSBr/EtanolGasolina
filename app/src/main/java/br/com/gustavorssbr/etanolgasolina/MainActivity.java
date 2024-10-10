package br.com.gustavorssbr.etanolgasolina;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValorGasolina;
    private EditText etvalorEtanol;
    private Button btComparar;
    private TextView tvValor;

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


        etValorGasolina = findViewById(R.id.etValorGasolina);
        etvalorEtanol = findViewById(R.id.etValorEtanol);
        btComparar = findViewById(R.id.btComparar);
        tvValor = findViewById(R.id.tvValor);

        btComparar.setOnClickListener(op -> calcular());
    }

    private void calcular(){
        float valorGasolina = Float.parseFloat(etValorGasolina.getText().toString());
        float valorEtanol = Float.parseFloat(etvalorEtanol.getText().toString());

        if(valorEtanol <= (valorGasolina * 0.7)){
            String texto = getString(R.string.comp_etanol);
            tvValor.setText(texto);
        }else{
            String texto = getString(R.string.comp_gasolina);
            tvValor.setText(texto);
        }

    }
}