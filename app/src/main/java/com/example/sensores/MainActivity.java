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
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv;
    SQLiteDatabase database;
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
        SensorManager sn = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor ac = sn.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sn.registerListener(this,ac ,SensorManager.SENSOR_DELAY_NORMAL);
        tv = findViewById(R.id.Texto);
        database = openOrCreateDatabase("bd",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS eventos (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "value1 REAL(5,2)," +
                "value2 REAL(5,2)," +
                "value3 REAL(5,2))");
        getAllEvents();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tv.setText(Float.toString(sensorEvent.values[0])+ Float.toString(sensorEvent.values[1]) + Float.toString(sensorEvent.values[2]));

        ContentValues contentValues = new ContentValues();
        contentValues.put("value1",sensorEvent.values[0]);
        contentValues.put("value2",sensorEvent.values[1]);
        contentValues.put("value2",sensorEvent.values[2]);;
        Log.v("Evento:","Inserido:"+sensorEvent);

        database.insert("eventos",null,contentValues);
    }
    public ArrayList<Eventos> getAllEvents(){
        Cursor cursor = database.rawQuery("SELECT * FROM eventos limit 1000",new String[]{"1000"});
        cursor.moveToFirst();
        ArrayList<Eventos> result = new ArrayList<>();
        while (!cursor.isAfterLast()){
            result.add(
           new Eventos(cursor.getInt(0),
                   new Float[]{cursor.getFloat(1), cursor.getFloat(2),cursor.getFloat(3)})
        );
        }
        return result;
    }
}