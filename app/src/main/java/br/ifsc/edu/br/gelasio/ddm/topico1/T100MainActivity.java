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
        b1001.setBackgroundColor(ContextCompat.getColor(b1001.getContext(), R.color.win11darkroxobackground));
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

        //botao 00 fechar
        //ja da cast do button aqui para nao ter que castear depois
        Button b1002;
        b1002 = (Button) findViewById(R.id.button1002);
        b1002.setBackgroundColor(ContextCompat.getColor(b1002.getContext(), R.color.black));
        b1002.setText("URL - PDF\n" +
                "Slide 1 - Introdução ao Desenvolvimento Móvel com AndroidURL\n" +
                "Slide da aula em que foi abordado introdução a desenvolvimento móvel.");
        b1002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button b1003;
        b1003 = (Button) findViewById(R.id.button1003);
        b1003.setBackgroundColor(ContextCompat.getColor(b1003.getContext(), R.color.black));
        b1003.setText("Tarefa:  \ud83d\udcec\n" +
                "Sorteio de número AleatóriosTarefa\n" +
                "Desenvolva uma aplicação de sorteio de números aleatórios que receba como entrada dois valores informados pelo usuário, sendo estes os limites inferiores e superiores do intervalo, em seguida faça o sorteio de um número do intervalo indicado pelo usuário. Após o desenvolvimento conforme instruções abaixo faça-o o envio no moodle.");
        b1003.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1003.setText("Sorteio Números Aleatórios \ud83d\udcea");
                Intent i;
                // PQ AS VEZES NÃO BUILDA A .class??????
                i = new Intent(T100MainActivity.this, T103MainActivity.class);
                startActivity(i);
                //finish();
            }
        });

        Button b1004;
        b1004 = (Button) findViewById(R.id.button1004);
        b1004.setBackgroundColor(ContextCompat.getColor(b1004.getContext(), R.color.black));
        b1004.setText("Tarefa:\n" +
                "App 2 - Descobrindo compoenentes widgets\n" +
                "Explore os componentes visuais disponiveis no framework e proponha e desenvolva uma aplicação utilizando diferentes componentes.");
        b1004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T100MainActivity.this, T104MainActivity.class);
                startActivity(i);
                //finish();
            }
        });

    }
}