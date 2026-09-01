package com.example.aula3;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mail);

        TextView tv = findViewById(R.id.tvTexto);
        Intent i = getIntent();

        tv.setText(i.getExtras().getString("msg"));


    }
}
