package cadastroDeVeiculos.dominio;

public class Locadora {
    private String nome;
    private Carro carros[];
    private int totalCarros;
    private int capacidade;

    public Locadora(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.carros = new Carro[capacidade];
    }

    public void cadastrarCarro(String marca, String modelo, String placa, int ano, String cor) {
        if (totalCarros >= capacidade) {
            System.out.println("Limite de veículos atingido!");
            return;
        }
        for (int i = 0; i < totalCarros; i++) {
            if (carros[i].getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Placa já cadastrada");
                return;
            }
        }
        carros[totalCarros] = new Carro(marca, modelo, placa, ano, cor);
        totalCarros++;
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void removerCarro(String placa) {
        if (totalCarros == 0) {
            System.out.println("Nenhum carro cadastrado! ");
            return;
        }
        boolean encontrado = false;
        for (int i = 0; i < totalCarros; i++) {
            if (carros[i].getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                for (int j = i; j < totalCarros - 1; j++) {
                    carros[j] = carros[j + 1];
                }
                carros[totalCarros - 1] = null;
                totalCarros--;
                System.out.println("Veículo removido com sucesso!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Placa não encontrada!");
        }
    }

    public void buscarCarro(String placa) {
        if (totalCarros == 0) {
            System.out.println("Nenhum carro cadastrado!");
            return;
        }
        boolean encontrado = false;
        for (int i = 0; i < totalCarros; i++) {
            if (carros[i].getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                carros[i].resumo(true);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado. Verifique a placa!");
        }
    }

    public void alugarCarro(String placa, String nomeCliente) {
        if (totalCarros == 0) {
            System.out.println("Nenhum carro cadastrado");
            return;
        }
        boolean encontrado = false;
        for (int i = 0; i < totalCarros; i++) {
            if (carros[i].getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                carros[i].alugar(nomeCliente);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado. Verifique a placa!");
        }
    }

    public void devolverCarro(String placa) {
        if (totalCarros == 0) {
            System.out.println("Nenhum carro cadastrado!");
            return;
        }
        boolean encontrado = false;
        for (int i = 0; i < totalCarros; i++) {
            if (carros[i].getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                carros[i].devolver();
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado. Verifique a placa!");
        }
    }

    public void listarCarros() {
        if (totalCarros == 0) {
            System.out.println("Nenhum carro cadastrado!");
            return;
        }
        for (int i = 0; i < totalCarros; i++) {
            System.out.print(i + 1 + ". ");
            carros[i].resumo(true);
        }
        System.out.println("\nTotal de veículos: " + totalCarros + " / Capacidade: " + capacidade);
    }

    public boolean temCarrosCadastrados() {
        return totalCarros > 0;
    }

    public boolean placaDisponivel(String placa) {
        for (int i = 0; i < totalCarros; i++) {
            if (carros[i].getPlaca().equalsIgnoreCase(placa)) {
                return false;
            }
        }
        return true;
    }
}