package cadastroDeVeiculos.test;

import cadastroDeVeiculos.dominio.Locadora;

import java.util.Scanner;

public class CarroTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora("São José", 50);
        int opcao = 0;

        String marca;
        String modelo;
        String placa;
        String cor;
        int ano;

        String nomeCliente;

        while (opcao != 7) {
            System.out.println("\n***LOCADORA SÃO JOSÉ***");
            System.out.println("1 - Cadastrar carro");
            System.out.println("2 - Remover carro");
            System.out.println("3 - Buscar carro");
            System.out.println("4 - Alugar carro");
            System.out.println("5 - Devolver carro");
            System.out.println("6 - Listar carros");
            System.out.println("7 - Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite apenas números.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CADASTRAR CARRO===");
                    System.out.print("Informe a marca: ");
                    marca = scanner.nextLine();
                    System.out.print("Informe o modelo: ");
                    modelo = scanner.nextLine();
                    System.out.print("Informe a placa: ");
                    placa = scanner.nextLine();
                    if (!locadora.placaDisponivel(placa)) {
                        System.out.println("\n=== Placa já cadastrada! ====");
                        break;
                    }

                    ano = 0;
                    while (true) {
                        System.out.print("Informe o ano: ");
                        try {
                            ano = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ano inválido! Digite apenas números.");
                        }
                    }

                    System.out.print("Informe a cor: ");
                    cor = scanner.nextLine();
                    locadora.cadastrarCarro(marca, modelo, placa, ano, cor);
                    break;

                case 2:
                    System.out.println("\n=== REMOVER VEÍCULO ===");
                    if (!locadora.temCarrosCadastrados()) {
                        System.out.println("Nenhum carro cadastrado!");
                        break;
                    }
                    System.out.print("Informe a placa: ");
                    placa = scanner.nextLine();
                    locadora.removerCarro(placa);
                    break;

                case 3:
                    System.out.println("\n===BUSCAR VEÍCULO===");
                    if (!locadora.temCarrosCadastrados()) {
                        System.out.println("Nenhum carro cadastrado!");
                        break;
                    }
                    System.out.print("Informe a placa: ");
                    placa = scanner.nextLine();
                    locadora.buscarCarro(placa);
                    break;

                case 4:
                    System.out.println("\n===ALUGAR VEÍCULO===");
                    if (!locadora.temCarrosCadastrados()) {
                        System.out.println("Nenhum carro cadastrado!");
                        break;
                    }
                    System.out.print("Informe a placa: ");
                    placa = scanner.nextLine();
                    System.out.print("Informe o nome do cliente: ");
                    nomeCliente = scanner.nextLine();
                    locadora.alugarCarro(placa, nomeCliente);
                    break;

                case 5:
                    System.out.println("\n===DEVOLVER VEÍCULO===");
                    if (!locadora.temCarrosCadastrados()) {
                        System.out.println("Nenhum carro cadastrado!");
                        break;
                    }
                    System.out.print("Informe a placa: ");
                    placa = scanner.nextLine();
                    locadora.devolverCarro(placa);
                    break;

                case 6:
                    System.out.println("\n===LISTANDO VEÍCULOS===");
                    locadora.listarCarros();
                    break;

                case 7:
                    System.out.println("Encerrando..");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        scanner.close();
    }
}