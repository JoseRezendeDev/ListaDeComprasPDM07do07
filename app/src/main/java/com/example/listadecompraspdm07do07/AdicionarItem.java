package com.example.listadecompraspdm07do07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdicionarItem extends AppCompatActivity {

    private EditText nome;
    private EditText quantidade;
    private Button adicionar;
    private Button cancelar;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_item);

        nome = findViewById(R.id.txtNome);
        quantidade = findViewById(R.id.txtQuantidade);
        adicionar = findViewById(R.id.btnAdicionar);
        cancelar = findViewById(R.id.btnCancelar);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produto = new Produto(
                        nome.getText().toString(),
                        Integer.parseInt(quantidade.getText().toString())
                );
                Intent intent = new Intent();
                intent.putExtra("produto", produto);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
