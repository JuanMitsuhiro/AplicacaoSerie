package br.fateczl.aplicacaoserie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etNumero;
    private Button btCalcular;
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

        etNumero = findViewById(R.id.etNumero);
        etNumero.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btCalcular = findViewById(R.id.btCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btCalcular.setOnClickListener(op -> calcular());
    }

    private void calcular(){
        int numero = Integer.parseInt(etNumero.getText().toString());

        if (numero > 0 && numero < 20){
            float resultado = 0;
            for (int i = 1; i <= numero; i++){
                resultado += (1.0/i);
            }
            String res = getString(R.string.resultado) + resultado;
            tvResultado.setText(res);
        } else {
            tvResultado.setText("Não foi possivel calcular");
        }

    }

}