package br.com.facens.qtds.model;

public class ClienteEspecial extends Cliente {

    public ClienteEspecial(int saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(int valorSaque) {
        // Se o valor do saque for maior que o saldo, aumenta a dívida
        saldo -= valorSaque; // Isso irá diminuir o saldo ou aumentar a dívida se o saldo for insuficiente
    }
}
