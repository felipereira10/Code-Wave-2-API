package net.codewave.models;

import java.time.LocalDate;

public class Registro {
    private String nome;
    private String title;
    private LocalDate data;

    public Registro(String nome, String title, LocalDate data) {
        this.nome = nome;
        this.title = title;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
