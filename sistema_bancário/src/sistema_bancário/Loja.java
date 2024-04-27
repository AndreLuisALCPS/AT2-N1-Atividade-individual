package sistema_bancário;

 public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;
    public static Loja[] lojas;

    public Loja(double saldoInicial, int numFuncionarios) {
        this.conta = new Conta(new Cliente("Loja", saldoInicial), saldoInicial);
        this.funcionarios = new Funcionario[numFuncionarios];
        for (int i = 0; i < numFuncionarios; i++) {
            this.funcionarios[i] = new Funcionario(this);
            this.funcionarios[i].start();
        }
    }

    public void realizarCompra(Cliente cliente, double valor) {
        Banco.transferir(cliente.getConta(), conta, valor);
    }

    public void pagarSalario(Funcionario funcionario) {
        Banco.transferir(conta, funcionario.getContaSalario(), 1400);
        double investimento = 0.2 * 1400;
        funcionario.getContaInvestimento().creditar(investimento);
        System.out.println("Funcionário da loja " + funcionario.getLoja() + " recebeu salário de R$1400 e investiu R$" + investimento);
    }

    public synchronized void verificarSaldoParaPagamento() {
        double totalSalarios = funcionarios.length * 1400;
        if (conta.getSaldo() >= totalSalarios) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getContaSalario().getSaldo() == 0) {
                    pagarSalario(funcionario);
                }
            }
        }
    }
}