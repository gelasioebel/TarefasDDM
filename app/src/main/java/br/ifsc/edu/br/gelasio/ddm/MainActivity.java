package br.ifsc.edu.br.gelasio.ddm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ifsc.edu.br.gelasio.ddm.topico1.T100MainActivity;

public class MainActivity extends AppCompatActivity {

    Intent i;

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

        //botao 00 fechar
        //ja da cast do button aqui para nao ter que castear depois
            Button myButton00 = (Button) findViewById(R.id.button00);
            myButton00.setText("--- Fechar ---");
            myButton00.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   myButton00.setText("FECHANDO...");
                   finish();
                }

            });

            //botao01 click
            // exemplo prof novo activity em "nova" onTop "janela"

//            Button myButton01 = (Button) findViewById(R.id.button01);
//            myButton01.setText("1 -Tópico 01 \ud83d\udcec");
//
//            myButton01.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    myButton01.setText("1 -Tópico 01 \ud83d\udcea");
//                    Intent i;
//                    i = new Intent(MainActivity.this, T100MainActivity.class);
//                    //Abaixo: mandando coisas (objetos?) pro main2 no estilo tipo json
//                    i.putExtra("nome", "Dado setado no Main Principal\n" +
//                            "Button01 onclick");
//                    startActivity(i);
//                }
//            });
        //bugado ARRUMARRRRRR as vez não builda arrumou sozinho vai saber

            Button myButton01 = (Button) findViewById(R.id.button01);
            myButton01.setText("1 -Tópico 01 \ud83d\udcec");
            myButton01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myButton01.setText("1 -Tópico 01 \ud83d\udcea");
                    i = new Intent(MainActivity.this, T100MainActivity.class);
                    //Abaixo: mandando coisas (objetos?) pro main2 no estilo tipo json
                    startActivity(i);

                }
            });



        Button myButton02 = (Button) findViewById(R.id.button02);
        myButton02.setText("2 - Tarefa:\n2 - Sorteio Aleatorio");
        //Ctrl+C Ctrl+V do de acima
        myButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myButton02.setText("2 - Abrindo\nSorteio Aleatorio");
                Intent i;
                i = new Intent(MainActivity.this, MainActivity3.class);
                //Abaixo: mandando coisas (objetos?) pro main2 no estilo tipo json
                i.putExtra("nome", "Vim do Activity 1");
                startActivity(i);
            }
        });

            Button myButton03 = findViewById(R.id.button03);
            Button myButton04 = findViewById(R.id.button04);
            Button myButton05 = findViewById(R.id.button05);
            Button myButton06 = findViewById(R.id.button06);
            Button myButton07 = findViewById(R.id.button07);
            Button myButton08 = findViewById(R.id.button08);
            Button myButton09 = findViewById(R.id.button09);
            Button myButton10 = findViewById(R.id.button10);

        };

    }

//source: https://it-tools.tech/emoji-picker search term: mailbox
//    📬
//Open mailbox with raised flag
//0x1f4ec
//        \ud83d\udcec
//📭
//Open mailbox with lowered flag
//0x1f4ed
//        \ud83d\udced
//📫
//Closed mailbox with raised flag
//0x1f4eb
//        \ud83d\udceb
//📪
//Closed mailbox with lowered flag
//0x1f4ea
//        \ud83d\udcea
