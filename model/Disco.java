package model;

import java.util.List;

public class Disco {
    private String titulo;
    private int ano;
    private Artista artista;
    private List<Faixa> faixas;

    public Disco(String titulo, Artista artista, int ano, List<Faixa> faixas) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        this.faixas = faixas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título do Disco: ").append(titulo).append("\n");
        sb.append("Ano de Lançamento: ").append(ano).append("\n");
        sb.append(artista).append("\n");
        sb.append("Lista de Faixas:\n");

        for (Faixa faixa : faixas) {
            sb.append("  - ").append(faixa).append("\n");
        }
        return sb.toString();
    }
}
