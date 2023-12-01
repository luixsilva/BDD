package br.com.facens.qtds;

import br.com.facens.qtds.model.Cliente;
import br.com.facens.qtds.model.ClienteComum;
import br.com.facens.qtds.model.ClienteEspecial;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Classe para definir os comportamentos de conta bancária em cenários de teste.
 */
public class Conta {

    private Cliente cliente; // Cliente é uma interface ou classe base
    private Exception saqueException;

    /**
     * Define um cliente com um tipo específico e saldo inicial.
     *
     * @param tipoCliente Tipo do cliente (comum ou especial).
     * @param saldo Saldo inicial do cliente.
     */
    @Given("um cliente {string} com saldo atual de {int} reais")
    public void um_cliente_com_saldo_atual_de_reais(String tipoCliente, int saldo) {
        if (tipoCliente.equals("comum")) {
            cliente = new ClienteComum(saldo);
        } else if (tipoCliente.equals("especial")) {
            cliente = new ClienteEspecial(saldo);
        }
        saqueException = null;
    }

    /**
     * Tenta realizar um saque na conta do cliente.
     *
     * @param valorSaque Valor a ser sacado.
     */
    @When("for solicitado um saque no valor de {int} reais")
    public void for_solicitado_um_saque_no_valor_de_reais(int valorSaque) {
        try {
            cliente.sacar(valorSaque);
        } catch (Exception e) {
            saqueException = e;
        }
    }

    /**
     * Verifica se o saque foi efetuado com sucesso e se o saldo foi atualizado corretamente.
     *
     * @param saldoEsperado Saldo esperado após o saque.
     */
    @Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int saldoEsperado) {
        Assert.assertEquals(saldoEsperado, cliente.getSaldo());
    }

    /**
     * Verifica se o saque não foi realizado devido a saldo insuficiente e se a mensagem correta foi gerada.
     */
    @Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
    public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
        Assert.assertNotNull("Uma exceção deveria ter sido lançada.", saqueException);
        Assert.assertEquals("Saldo Insuficiente", saqueException.getMessage());
    }

    /**
     * Método para verificar outros resultados conforme necessário.
     * Implemente verificações adicionais conforme necessário.
     */
    @And("Check more outcomes")
    public void check_more_outcomes() {
        // Implemente verificações adicionais conforme necessário
    }
}
