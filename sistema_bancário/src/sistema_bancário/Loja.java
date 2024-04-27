package sistema_bancário;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private final Conta conta;
    private final List<Funcionario> funcionarios;

    public Loja(Conta conta) {
        this.conta = conta;
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public synchronized void receberPagamento(double valor, String nomeCliente) {
        conta.depositar(valor);
        System.out.println("Loja recebeu pagamento de R$ " + valor + " do cliente " + nomeCliente);

        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.recebeuSalario()) {
                if (conta.getSaldo() >= 1400) {
                    conta.sacar(1400);
                    funcionario.receberSalario();
                }
            }

            funcionario.start();
        }

        boolean todosPagos = true;
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.recebeuSalario()) {
                todosPagos = false;
                break;
            }
        }
        if (todosPagos) {
            System.out.println("Pagamento de salários e investimentos efetuado para todos os funcionários.");
        }
    }
}
