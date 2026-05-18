# 🚗 Locadora de Veículos - POO

Sistema de gerenciamento de locadora de veículos desenvolvido em Java,
aplicando os conceitos de Programação Orientada a Objetos (POO).

> 📌 Evolução do projeto [Cadastro de Veículos](https://github.com/eliasliverosampaio/cadastro-veiculos-java),
> reescrito com POO para melhor organização e manutenção do código.

## 📋 Funcionalidades

- Cadastrar carros com validação de placa duplicada
- Remover veículos por placa
- Buscar veículo por placa
- Alugar veículo para um cliente
- Devolver veículo alugado
- Listar todos os veículos com status de disponibilidade

## 🏗️ Estrutura do Projeto

```text
src/
└── cadastroDeVeiculos/
    ├── dominio/
    │   ├── Carro.java
    │   └── Locadora.java
    └── test/
        └── CarroTest.java
```

## 🛠️ Tecnologias

- Java
- Scanner (entrada de dados via console)

## ▶️ Como executar

1. Clone o repositório
2. Abra no IntelliJ IDEA
3. Execute a classe `CarroTest`

## 📚 Conceitos de POO aplicados

- **Encapsulamento** — atributos privados com getters e setters
- **Classes e objetos** — `Carro` e `Locadora` com responsabilidades bem definidas
- **Construtores encadeados** — uso de `this()` para reaproveitar construtores
- **Sobrecarga de métodos** — método `resumo()` com e sem parâmetro
- **Separação de responsabilidades** — domínio isolado da camada de teste
- **Tratamento de exceções** — validação de entradas com `try/catch`
