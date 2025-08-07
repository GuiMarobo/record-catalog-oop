package service;

import model.Artista;
import model.Disco;
import model.Faixa;
import repository.ICatalogoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoService implements ICatalogoService{
    private ICatalogoRepository repository;

    public CatalogoService(ICatalogoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarDisco(String titulo, int ano, Artista artista, List<Faixa> faixas) {
        Disco existente = repository.buscarDiscoPorTitulo(titulo);
        if (existente != null) {
            System.out.println("@@@ Erro: Um disco com esse título já existe @@@");
            return;
        }

        Disco novoDisco = new Disco(titulo, artista, ano, faixas);
        repository.addDisco(novoDisco);
        System.out.println("=== Disco cadastrado com sucesso! ===");
    }

    @Override
    public void listarDiscos() {
        List<Disco> discos = repository.getDiscos();
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado!");
        } else {
            discos.forEach(System.out::println);
        }
    }

    @Override
    public void editarDisco(String tituloAntigo, String novoTitulo, int anoNovo) {
        Disco disco = repository.buscarDiscoPorTitulo(tituloAntigo);
        if (disco == null) {
            System.out.println("@@@ Erro: Disco não encontrado. @@@");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        disco.setTitulo(novoTitulo);
        disco.setAno(anoNovo);

        System.out.println("Deseja alterar a tracklist do disco? (s/n)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")){
            List<Faixa> faixasNova = new ArrayList<>();
            System.out.println("Digite as novas faixas do disco. Digite '.' para finalizar.");
            while (true){
                System.out.println("Digite o título da faixa:");
                String tituloFaixa = scanner.nextLine();
                if (tituloFaixa.equalsIgnoreCase(".")) break;


                System.out.println("Digite a duração da faixa (em segundos)");
                int duracao = scanner.nextInt();
                scanner.nextLine();

                faixasNova.add(new Faixa(tituloFaixa, duracao));
            }
            disco.setFaixas(faixasNova);
            System.out.println("=== Faixas substituídas com sucesso! ===");
        }


        System.out.println("=== Disco editado com sucesso! ===");
    }

    @Override
    public void removerDisco(String titulo) {
        Disco disco = repository.buscarDiscoPorTitulo(titulo);
        if (disco == null){
            System.out.println("@@@ Erro: Disco não encontrado! @@@");
            return;
        }
        repository.removeDisco(disco);
        System.out.println("@@@ Disco removido com sucesso! @@@");
    }
}
