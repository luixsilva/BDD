package br.com.facens.qtds.model;

public abstract class Cliente {
    protected int saldo;

    public Cliente(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public abstract void sacar(int valorSaque);

    public int getSaldo() {
        return saldo;
    }
}