package br.ifsc.edu.br.gelasioebel.gelasiopaint;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStream;

public class MainActivityPaint extends AppCompatActivity {
    private SimplePaint areaDesenho;
    private static final int CODIGO_PERMISSAO = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paint);

        areaDesenho = findViewById(R.id.paintView);
        Button botaoSalvar = findViewById(R.id.botaoSalvar);
        Button botaoLimpar = findViewById(R.id.botaoLimpar);

        botaoSalvar.setOnClickListener(v -> salvarDesenho());
        botaoLimpar.setOnClickListener(v -> areaDesenho.limpar());
    }

    private void salvarDesenho() {
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    CODIGO_PERMISSAO
            );
            return;
        }

        String nomeArquivo = "Desenho_" + System.currentTimeMillis() + ".png";
        ContentValues valores = new ContentValues();
        valores.put(MediaStore.Images.Media.DISPLAY_NAME, nomeArquivo);
        valores.put(MediaStore.Images.Media.MIME_TYPE, "image/png");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            valores.put(MediaStore.Images.Media.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES);
        }

        ContentResolver resolver = getContentResolver();
        Uri uriImagem = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, valores);

        try {
            OutputStream stream = resolver.openOutputStream(uriImagem);
            areaDesenho.getBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
            if (stream != null) {
                stream.close();
            }
            Toast.makeText(this, "Desenho salvo!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao salvar desenho", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CODIGO_PERMISSAO &&
                grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            salvarDesenho();
        }
    }
}