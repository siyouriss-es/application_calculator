package com.example.calculatrice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.standard:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                //Toast.makeText(this, "Calc Standard", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.scientific:
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                //Toast.makeText(this, "Calc Scientifique", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.graphic:
                startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                Toast.makeText(this, "Calc graphique", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return
                        super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}