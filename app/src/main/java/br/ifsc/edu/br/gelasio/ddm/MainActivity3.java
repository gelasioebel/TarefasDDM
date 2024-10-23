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

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //botao 00 fechar
        //ja da cast do button aqui para nao ter que castear depois
        Button b301;
        b301 = (Button) findViewById(R.id.button301);
        Intent i2 = getIntent();
        Bundle bundle = i2.getExtras();
        // o i tem limits
        b301.setText(bundle.getString("nome"));
        b301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b301.setText("b301 no meu MainActivity 3");
                finish();
            }
        });
    }
}