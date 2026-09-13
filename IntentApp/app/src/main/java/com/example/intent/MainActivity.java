package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnIntentExplicita =
                findViewById(R.id.btnIntentExplicita);

        Button btnIntentImplicita =
                findViewById(R.id.btnIntentImplicita);

        btnIntentExplicita.setOnClickListener(view -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    SegundaActivity.class
            );

            startActivity(intent);
        });

        btnIntentImplicita.setOnClickListener(view -> {

            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/search?q=me+da+10+romulo+pfvr+%3A%29")
            );

            startActivity(intent);
        });
    }
}