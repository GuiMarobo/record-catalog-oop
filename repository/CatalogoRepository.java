package repository;

import model.Disco;

import java.util.ArrayList;
import java.util.List;

public class CatalogoRepository implements ICatalogoRepository{
    private List<Disco> discos = new ArrayList<>();

    @Override
    public void addDisco(Disco disco) {
        discos.add(disco);
    }

    @Override
    public void removeDisco(Disco disco) {
        discos.remove(disco);
    }

    @Override
    public List<Disco> getDiscos() {
        return discos;
    }

    @Override
    public Disco buscarDiscoPorTitulo(String titulo) {
        return discos.stream()
                .filter(disco -> disco.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }
}
