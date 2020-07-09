package com.example.listadecompraspdm07do07;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListaProdutoAdapter extends ArrayAdapter {

    private Context context;
    private List<Produto> listaProdutos;

    public ListaProdutoAdapter(Context context, List<Produto> listaProdutos) {
        super(context, R.layout.item_lista_produto, listaProdutos);
        this.context = context;
        this.listaProdutos = listaProdutos;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Produto produto = listaProdutos.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView = layoutInflater.inflate(R.layout.item_lista_produto, parent, false);

        TextView lbNome = itemView.findViewById(R.id.nome);
        TextView lbQuantidade = itemView.findViewById(R.id.quantidade);

        lbNome.setText(produto.getNome());
        lbQuantidade.setText(Integer.toString(produto.getQuantidade()));

        return itemView;
    }
}
