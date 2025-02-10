package br.ifsc.edu.br.gelasioebel.gelasiopaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
public class SimplePaint extends View {
    private Paint pincel;
    private Path caminho;
    private Bitmap bitmap;
    private Canvas tela;

    public SimplePaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.pincel = new Paint();
        this.caminho = new Path();
        configurar();
    }

    private void configurar() {
        pincel.setAntiAlias(true);
        pincel.setStrokeWidth(6f);
        pincel.setColor(0xff000000);
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        tela = new Canvas(bitmap);
        tela.drawColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas tela) {
        super.onDraw(tela);
        tela.drawBitmap(bitmap, 0, 0, null);
        tela.drawPath(caminho, pincel);
    }

    @Override
    public boolean onTouchEvent(MotionEvent evento) {
        float x = evento.getX();
        float y = evento.getY();

        switch (evento.getAction()) {
            case MotionEvent.ACTION_DOWN:
                caminho.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                caminho.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                tela.drawPath(caminho, pincel);
                caminho.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public void limpar() {
        caminho.reset();
        tela.drawColor(Color.WHITE);
        invalidate();
    }

    public void mudarCorPincel(int cor) {
        pincel.setColor(cor);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}