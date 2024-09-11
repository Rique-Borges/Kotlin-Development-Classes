package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;
    Button btnRemover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = (Button)findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(view -> {
            Toast.makeText(this, "Seus dados foram salvos", Toast.LENGTH_SHORT).show();
                });
        btnRemover = (Button)findViewById(R.id.buttonRemover);
        btnRemover.setOnClickListener(v ->{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Atenção");
            alert.setMessage("Deseja remover esse registro?");
            alert.setIcon(R.mipmap.ic_launcher);
            alert.setNegativeButton("Não", null);
            alert.setPositiveButton("Sim",(dialog, which)-> {
                Toast.makeText(this, "Dados do registro foram removidos com sucesso", Toast.LENGTH_SHORT).show();
            });
        });

    }
}