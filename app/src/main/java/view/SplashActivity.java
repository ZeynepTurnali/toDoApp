package view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todoapp.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

        /**bu yapı main activity hazırlanana kadar splash screenin gözükmesini sağlayacağı için
         appte şimdilik çok kısa zamanda görünüp kayboluyor. */
    }
}
