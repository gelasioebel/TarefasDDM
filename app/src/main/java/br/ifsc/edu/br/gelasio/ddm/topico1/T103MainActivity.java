package br.ifsc.edu.br.gelasio.ddm.topico1;

import android.content.Intent;
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

import com.google.android.material.textfield.TextInputEditText;

import java.text.BreakIterator;
import java.util.Random;

import br.ifsc.edu.br.gelasio.ddm.R;

public class T103MainActivity extends AppCompatActivity {

    int cliques = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t103_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


                });


        TextView textView1033 = (TextView) findViewById(R.id.textView1033);

        Button button1031 = (Button) findViewById(R.id.button1031);
        button1031.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                 cliques++;
                 EditText editTextNumber1031 = (EditText) findViewById(R.id.editTextNumber1031);
                EditText editTextNumber1032 = (EditText) findViewById(R.id.editTextNumber1032);
                findViewById(R.id.editTextNumber1032);

                 if (cliques > 3){
                     textView1033.setText("");
                     cliques=0;
                 }

                //Eu tento tento e sempre catcheio errado!!! Google arrumou Ass. Gelasio Ebel Junior
                try {
                    int n1 = Integer.parseInt(editTextNumber1031.getText().toString());
                    int n2 = Integer.parseInt(editTextNumber1032.getText().toString());
                    sortear(n1, n2, button1031);
                } catch (NumberFormatException e) {
                    TextView textView1033 = (TextView) findViewById(R.id.textView1033);
                    textView1033.setText(textView1033.getText() + "Me erra\n Insira números Inteiros válidos.\n");
                }}});
        }
    public void sortear(int n1, int n2, Button button1031){
        if (n1 > n2) {
            int aux = n1;
            n1 = n2;
            n2 = aux;
        }
        int numeroSorteado = new Random().nextInt(n2 - n1) + n1;
        TextView textView1033 = (TextView) findViewById(R.id.textView1033);
        textView1033.setText(textView1033.getText() + "" + numeroSorteado + "\n");
        //https://stackoverflow.com/questions/3506696/auto-scrolling-textview-in-android-to-bring-text-into-view
}}