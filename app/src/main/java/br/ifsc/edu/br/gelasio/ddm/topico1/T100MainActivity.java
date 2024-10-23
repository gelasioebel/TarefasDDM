package br.ifsc.edu.br.gelasio.ddm.topico1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ifsc.edu.br.gelasio.ddm.R;

public class T100MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t100_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //botao 00 fechar
        //ja da cast do button aqui para nao ter que castear depois
        Button b1001;
        b1001 = (Button) findViewById(R.id.button1001);
        b1001.setBackgroundColor(ContextCompat.getColor(b1001.getContext(), R.color.white));
        b1001.setText("Arquivo\n" +
                "Semana 01 - Lista Atividades 0 - P.O.O RememberArquivo\n" +
                "Uma lista de exercicíos não obrigatória sugerida para verificar o nível de compreensão de orientação a objetos\n" +
                "É uma revisão ultra básica, leia e tente resolver mentalmente e depois implemente a solução.");
        b1001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}