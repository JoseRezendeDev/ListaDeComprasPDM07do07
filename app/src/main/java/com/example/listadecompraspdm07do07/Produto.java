package com.example.listadecompraspdm07do07;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private int quantidade;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
