package com.example.sensores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GraficoView extends View {

    private List<Eventos> listaEventos = new ArrayList<>();

    private Paint paintLinhaX;
    private Paint paintLinhaY;
    private Paint paintLinhaZ;
    private Paint paintEixo;
    private Paint paintTexto;
    private Paint paintGrade;

    private final Path pathX = new Path();
    private final Path pathY = new Path();
    private final Path pathZ = new Path();

    public GraficoView(Context context) {
        super(context);
        init();
    }

    public GraficoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GraficoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paintLinhaX = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLinhaX.setColor(Color.RED);
        paintLinhaX.setStrokeWidth(5f);
        paintLinhaX.setStyle(Paint.Style.STROKE);

        paintLinhaY = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLinhaY.setColor(Color.GREEN);
        paintLinhaY.setStrokeWidth(5f);
        paintLinhaY.setStyle(Paint.Style.STROKE);

        paintLinhaZ = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLinhaZ.setColor(Color.BLUE);
        paintLinhaZ.setStrokeWidth(5f);
        paintLinhaZ.setStyle(Paint.Style.STROKE);

        paintEixo = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintEixo.setColor(Color.DKGRAY);
        paintEixo.setStrokeWidth(3f);

        paintGrade = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintGrade.setColor(Color.LTGRAY);
        paintGrade.setStrokeWidth(1.5f);
        paintGrade.setPathEffect(new DashPathEffect(new float[]{10, 10}, 0));

        paintTexto = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintTexto.setColor(Color.BLACK);
        paintTexto.setTextSize(32f);
    }

    public void setEventos(List<Eventos> eventos) {
        this.listaEventos = (eventos != null) ? eventos : new ArrayList<>();
        invalidate();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        int largura = getWidth();
        int altura = getHeight();

        if (largura == 0 || altura == 0) return;

        float paddingEsquerda = 90f;
        float paddingDireita = 30f;
        float paddingTopo = 80f;
        float paddingBase = 80f;

        float areaLargura = largura - paddingEsquerda - paddingDireita;
        float areaAltura = altura - paddingTopo - paddingBase;

        // Legenda
        paintTexto.setTextSize(30f);
        paintTexto.setColor(Color.RED);
        canvas.drawText("X (Val 1)", paddingEsquerda, 50, paintTexto);

        paintTexto.setColor(Color.GREEN);
        canvas.drawText("Y (Val 2)", paddingEsquerda + 200, 50, paintTexto);

        paintTexto.setColor(Color.BLUE);
        canvas.drawText("Z (Val 3)", paddingEsquerda + 400, 50, paintTexto);

        if (listaEventos == null || listaEventos.isEmpty()) {
            paintTexto.setColor(Color.GRAY);
            paintTexto.setTextSize(36f);
            canvas.drawText("Sem dados no banco de dados", largura / 6f, altura / 2f, paintTexto);
            return;
        }

        // Eixos
        canvas.drawLine(paddingEsquerda, paddingTopo, paddingEsquerda, altura - paddingBase, paintEixo);
        canvas.drawLine(paddingEsquerda, altura - paddingBase, largura - paddingDireita, altura - paddingBase, paintEixo);

        float minYCalculado = -10f;
        float maxYCalculado = 10f;

        for (Eventos e : listaEventos) {
            if (e.values != null && e.values.length >= 3) {
                for (int i = 0; i < 3; i++) {
                    if (e.values[i] != null) {
                        if (e.values[i] < minYCalculado) minYCalculado = e.values[i];
                        if (e.values[i] > maxYCalculado) maxYCalculado = e.values[i];
                    }
                }
            }
        }

        float minAjustado = minYCalculado - 2f;
        float maxAjustado = maxYCalculado + 2f;
        float intervaloY = maxAjustado - minAjustado;

        // Linha do zero
        if (minAjustado <= 0 && maxAjustado >= 0) {
            float zeroY = (altura - paddingBase) - ((0 - minAjustado) / intervaloY) * areaAltura;
            canvas.drawLine(paddingEsquerda, zeroY, largura - paddingDireita, zeroY, paintGrade);
            paintTexto.setColor(Color.GRAY);
            paintTexto.setTextSize(24f);
            canvas.drawText("0", 30, zeroY + 8, paintTexto);
        }

        // Rótulos min/max no eixo Y
        paintTexto.setColor(Color.BLACK);
        paintTexto.setTextSize(24f);
        canvas.drawText(String.format(Locale.getDefault(), "%.1f", maxAjustado), 10, paddingTopo + 20, paintTexto);
        canvas.drawText(String.format(Locale.getDefault(), "%.1f", minAjustado), 10, altura - paddingBase, paintTexto);

        pathX.reset();
        pathY.reset();
        pathZ.reset();

        int totalPontos = listaEventos.size();
        float passoX = totalPontos > 1 ? areaLargura / (totalPontos - 1) : areaLargura;

        for (int i = 0; i < totalPontos; i++) {
            Eventos evento = listaEventos.get(i);
            if (evento.values == null || evento.values.length < 3) continue;

            float x = paddingEsquerda + (i * passoX);

            float valX = evento.values[0] != null ? evento.values[0] : 0f;
            float valY = evento.values[1] != null ? evento.values[1] : 0f;
            float valZ = evento.values[2] != null ? evento.values[2] : 0f;

            float yX = (altura - paddingBase) - ((valX - minAjustado) / intervaloY) * areaAltura;
            float yY = (altura - paddingBase) - ((valY - minAjustado) / intervaloY) * areaAltura;
            float yZ = (altura - paddingBase) - ((valZ - minAjustado) / intervaloY) * areaAltura;

            if (i == 0) {
                pathX.moveTo(x, yX);
                pathY.moveTo(x, yY);
                pathZ.moveTo(x, yZ);
            } else {
                pathX.lineTo(x, yX);
                pathY.lineTo(x, yY);
                pathZ.lineTo(x, yZ);
            }
        }

        canvas.drawPath(pathX, paintLinhaX);
        canvas.drawPath(pathY, paintLinhaY);
        canvas.drawPath(pathZ, paintLinhaZ);
    }
}
