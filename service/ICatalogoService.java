package service;

import model.Artista;
import model.Faixa;
import model.Disco;

import java.util.List;

public interface ICatalogoService {
    void cadastrarDisco(String titulo, int ano, Artista artista, List<Faixa> faixas);
    void listarDiscos();
    void editarDisco(String tituloAntigo, String novoTitulo, int anoNovo);
    void removerDisco(String titulo);

}
