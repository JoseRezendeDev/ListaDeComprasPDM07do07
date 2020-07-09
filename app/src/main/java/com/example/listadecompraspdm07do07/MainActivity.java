package com.example.listadecompraspdm07do07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

        listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("arroz", 1));
        listaProdutos.add(new Produto("feijao", 2));
        listaProdutos.add(new Produto("batata", 3));
        listaProdutos.add(new Produto("pipoca", 4));
        listaProdutoAdapter = new ListaProdutoAdapter(this, listaProdutos);

        listView.setAdapter(listaProdutoAdapter);

        adicionarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdicionarItem.class);
                startActivityForResult(intent, 1);
            }
        });

        getSupportActionBar().hide();

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nome = view.findViewById(R.id.nome);
                if (nome.getPaintFlags() != Paint.STRIKE_THRU_TEXT_FLAG)
                    nome.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                else
                    nome.setPaintFlags(0);
            }
        });

        listView.setLongClickable(true);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaProdutos.remove(position);
                listaProdutoAdapter.notifyDataSetChanged();
                return true;
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
