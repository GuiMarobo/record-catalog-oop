package repository;

import model.Disco;
import java.util.List;

public interface ICatalogoRepository {
    void addDisco (Disco disco);
    void removeDisco (Disco disco);
    List<Disco> getDiscos();
    Disco buscarDiscoPorTitulo(String titulo);
}
