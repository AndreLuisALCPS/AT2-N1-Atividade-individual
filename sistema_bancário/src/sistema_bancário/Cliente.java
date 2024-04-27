package sistema_bancário;

import java.util.concurrent.ThreadLocalRandom;

public class Cliente extends Thread {
    private final String nome;
    private final Conta conta;

    public Cliente(String nome, Conta conta) {
        this.nome = nome;
        this.conta = conta;
    }
    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            int valorCompra = ThreadLocalRandom.current().nextBoolean() ? 100 : 200; 
            if (conta.getSaldo() >= valorCompra && conta.sacar(valorCompra)) {
                System.out.println(nome + " realizou uma compra de R$ " + valorCompra + ". Saldo restante: R$ " + conta.getSaldo());
                synchronized (Banco.lojas) {
                    int numberOfLojas = Banco.lojas.size();
                    if (numberOfLojas > 0) {
                        Loja loja = Banco.lojas.get(ThreadLocalRandom.current().nextInt(numberOfLojas));
                        loja.receberPagamento(valorCompra, nome);
                    }
                }
            }
        }
    }
}