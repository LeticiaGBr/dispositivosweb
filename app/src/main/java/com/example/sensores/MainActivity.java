package com.example.sensores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView tv;
    private GraficoView graficoView;
    private SQLiteDatabase database;

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

        tv = findViewById(R.id.Texto);
        graficoView = findViewById(R.id.graficoView);
        Button btnAtualizar = findViewById(R.id.btnAtualizar);

        database = openOrCreateDatabase("bd", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS eventos (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "value1 REAL," +
                "value2 REAL," +
                "value3 REAL)");

        btnAtualizar.setOnClickListener(v -> atualizarGrafico());

        SensorManager sn = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sn != null) {
            Sensor ac = sn.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (ac != null) {
                sn.registerListener(this, ac, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }

        atualizarGrafico();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        tv.setText(String.format(Locale.getDefault(), "X: %.2f | Y: %.2f | Z: %.2f", x, y, z));

        ContentValues contentValues = new ContentValues();
        contentValues.put("value1", x);
        contentValues.put("value2", y);
        contentValues.put("value3", z);
        Log.v("Evento:", "Inserido: X=" + x + " Y=" + y + " Z=" + z);

        database.insert("eventos", null, contentValues);
    }

    public void atualizarGrafico() {
        ArrayList<Eventos> eventos = getAllEvents();
        graficoView.setEventos(eventos);
    }

    public ArrayList<Eventos> getAllEvents() {
        ArrayList<Eventos> result = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT id, value1, value2, value3 FROM eventos ORDER BY id DESC LIMIT 50", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                float v1 = cursor.getFloat(1);
                float v2 = cursor.getFloat(2);
                float v3 = cursor.getFloat(3);

                result.add(0, new Eventos(id, new Float[]{v1, v2, v3}));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return result;
    }
}
