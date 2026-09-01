
package com.example.contador;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numero =0;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edmin,edmax;
        edmin=findViewById(R.id.EdMin);

        edmax=findViewById(R.id.EdMax);
        Button bt = findViewById(R.id.bt);
        TextView tv = findViewById(R.id.tv);

        bt.setOnClickListener( v->{
            String smin = edmin.getText().toString();
            String smax = edmax.getText().toString();

            if (smin.isEmpty() ){
                edmin.setError("Informe um inteiro");
            } else if (smin.isEmpty()) {
                edmax.setError("Informe um inteiro");
            } else {
                int min = Integer.parseInt(smin);
                int max = Integer.parseInt(smax);
                if (min > max){
                    edmin.setError("Informe um número menor");
                    edmax.setError("Informe um número maior");
                }else {
                    numero = r.nextInt(max - min + 1) + min;

                    tv.setText(Integer.toString(numero));
                }
            }

        });
    }
}