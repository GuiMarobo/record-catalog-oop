package main;

import model.Artista;
import model.Faixa;
import repository.CatalogoRepository;
import repository.ICatalogoRepository;
import service.CatalogoService;
import service.ICatalogoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ICatalogoRepository repository = new CatalogoRepository();
        ICatalogoService service = new CatalogoService(repository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Disco");
            System.out.println("2. Listar Discos");
            System.out.println("3. Editar Disco");
            System.out.println("4. Remover Disco");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Título do disco: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Ano de lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nome do artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.println("Gênero do artista: ");
                    String genero = scanner.nextLine();

                    Artista artista = new Artista(nomeArtista, genero);

                    List<Faixa> faixas = new ArrayList<>();
                    System.out.println("Digite as faixas (título e duração em segundos). Digite 'fim' para finalizar");
                    while (true) {
                        System.out.println("Título da faixa: ");
                        String tituloFaixa = scanner.nextLine();
                        if (tituloFaixa.equalsIgnoreCase("fim")) break;
                        System.out.println("Duração (segundos): ");
                        int duracao = scanner.nextInt();
                        scanner.nextLine();
                        faixas.add(new Faixa(tituloFaixa, duracao));
                    }
                    service.cadastrarDisco(titulo, ano, artista, faixas);
                    break;
                case 2:
                    service.listarDiscos();
                    break;

                case 3:
                    System.out.print("Título do disco a editar: ");
                    String tituloAntigo = scanner.nextLine();
                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Novo ano: ");
                    int novoAno = scanner.nextInt();
                    service.editarDisco(tituloAntigo, novoTitulo, novoAno);
                    break;

                case 4:
                    System.out.print("Título do disco a remover: ");
                    String tituloRemover = scanner.nextLine();
                    service.removerDisco(tituloRemover);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}