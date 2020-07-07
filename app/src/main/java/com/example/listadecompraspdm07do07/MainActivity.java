package com.example.listadecompraspdm07do07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button adicionarItem;
    private ListView listView;

    private List<Produto> listaProdutos;

    private ListaProdutoAdapter listaProdutoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adicionarItem = findViewById(R.id.adicionarItem);
        listView = findViewById(R.id.listView);

        listaProdutoAdapter = new ListaProdutoAdapter(getApplicationContext(), listaProdutos);

        listaProdutos = new ArrayList<>();

        listView.setAdapter(listaProdutoAdapter);

        adicionarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdicionarItem.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Produto produto = (Produto) Objects.requireNonNull(data.getExtras()).getSerializable("produto");
            listaProdutos.add(produto);

            listaProdutoAdapter.notifyDataSetChanged();
        }
    }
}
