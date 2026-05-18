package cadastroDeVeiculos.dominio;

public class Carro {
    private String modelo;
    private String placa;
    private String marca;
    private String cor;
    private int ano;
    private boolean alugado;
    private String nomeCliente;

    public Carro(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public Carro(String marca, String modelo, String placa, int ano, String cor) {
        this(modelo, placa);
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
    }

    public void alugar(String nomeCliente) {
        if (alugado) {
            System.out.println("Veículo já se encontra alugado!");
            return;
        }
        alugado = true;
        this.nomeCliente = nomeCliente;
        System.out.println("Veículo alugado com sucesso para " + this.nomeCliente);
    }

    public void devolver() {
        if (!alugado) {
            System.out.println("Veículo não se encontra alugado!");
            return;
        }
        alugado = false;
        this.nomeCliente = null;
        System.out.println("Veículo devolvido com sucesso!");
    }

    public void resumo() {
        System.out.print("Modelo: " + this.modelo + " | Placa: " + this.placa);
        System.out.println("\nStatus: " + (alugado ? "Alugado para " + this.nomeCliente : "Disponível"));
    }

    public void resumo(boolean detalhado) {
        if (detalhado) {
            System.out.print("Modelo: " + this.modelo + " | Placa: " + this.placa + " | Marca: " + this.marca + " | Cor: " + this.cor + " | Ano: " + this.ano+"\nStatus: " + (alugado ? "Alugado para " + this.nomeCliente : "Disponível"));
            return;
        }
        this.resumo();
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getCor() {
        return this.cor;
    }

    public int getAno() {
        return this.ano;
    }

    public boolean isAlugado() {
        return this.alugado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}