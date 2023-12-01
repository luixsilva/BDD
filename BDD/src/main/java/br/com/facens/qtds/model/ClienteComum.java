package br.com.facens.qtds.model;

public class ClienteComum extends Cliente{

    public ClienteComum(int saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(int valorSaque) {
        if (valorSaque <= saldo) {
            saldo -= valorSaque;
        } else {
            // Lançar exceção ou lidar com o caso de saque maior que o saldo
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }
}
